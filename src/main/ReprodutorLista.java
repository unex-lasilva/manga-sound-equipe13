package main;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReprodutorLista {
    private ListaReproducao listaReproducao;
    private int musicaAtualIndex;
    private String status;

    private Clip clip;
    private AudioInputStream audioStream;

    private Thread playbackThread;
    private boolean skipRequest = false;
    private boolean stopRequest = false;

    public ReprodutorLista() {
        this.listaReproducao = null;
        this.musicaAtualIndex = 0;
        this.status = "parado";
    }

    public ReprodutorLista(ListaReproducao listaReproducao) {
        this.listaReproducao = listaReproducao;
        this.musicaAtualIndex = 0;
        this.status = "parado";
    }

    public void setListaReproducao(ListaReproducao listaReproducao) {
        stop();
        this.listaReproducao = listaReproducao;
        this.musicaAtualIndex = 0;
    }

    public void play() {
        if (listaReproducao == null || listaReproducao.tamanho() == 0) {
            System.out.println("Lista de reprodução vazia.");
            return;
        }

        if (status.equals("tocando")) {
            System.out.println("Já está tocando.");
            return;
        }

        if (status.equals("pausado")) {
            resume();
            return;
        }

        stopRequest = false;
        skipRequest = false;

        playbackThread = new Thread(() -> {
            while (musicaAtualIndex < listaReproducao.tamanho() && !stopRequest) {
                Musica musica = listaReproducao.obterMusica(musicaAtualIndex);
                tocarMusica(musica);
                if (!skipRequest) break;
                skipRequest = false;
                musicaAtualIndex++;
            }
        });

        playbackThread.start();
    }

    private void tocarMusica(Musica musica) {
        try {
            File audioFile = new File(musica.getPath());
            if (!audioFile.exists()) {
                System.out.println("❌ Arquivo não encontrado: " + musica.getPath());
                return;
            }

            audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Volume (opcional)
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volume.setValue(0.0f); // Pode ajustar volume aqui
            }

            clip.start();
            status = "tocando";
            System.out.println("🎧 Tocando: " + musica.getTitulo() + " - " + musica.getArtista());

            while (!skipRequest && !stopRequest && clip.isRunning()) {
                Thread.sleep(100);
            }

            clip.stop();
            clip.close();
            audioStream.close();

        } catch (Exception e) {
            System.err.println("⚠️ Erro ao tocar música: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            status = "pausado";
            System.out.println("⏸ Música pausada.");
        }
    }

    public void resume() {
        if (clip != null && status.equals("pausado")) {
            clip.start();
            status = "tocando";
            System.out.println("▶️ Música retomada.");
        }
    }

    public void stop() {
        stopRequest = true;

        if (clip != null && clip.isRunning()) {
            clip.stop();
        }

        if (clip != null && clip.isOpen()) {
            clip.close();
        }

        try {
            if (audioStream != null) {
                audioStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        status = "parado";
        System.out.println("⏹ Reprodução parada.");
    }

    public void proximaMusica() {
        if (listaReproducao != null && musicaAtualIndex < listaReproducao.tamanho() - 1) {
            musicaAtualIndex++;
            skipRequest = true;
            stop();
            play();
        } else {
            System.out.println("⚠️ Fim da lista.");
        }
    }

    public void musicaAnterior() {
        if (listaReproducao != null && musicaAtualIndex > 0) {
            musicaAtualIndex--;
            skipRequest = true;
            stop();
            play();
        } else {
            System.out.println("⚠️ Você está no início da lista.");
        }
    }

    public void adicionarMusica(Musica musica) {
        if (listaReproducao != null) {
            listaReproducao.addMusica(musica);
        } else {
            System.out.println("❌ Lista de reprodução não definida.");
        }
    }

    public void adicionarMusicaNaPosicao(Musica musica, int posicao) {
        if (listaReproducao != null) {
            listaReproducao.adicionarMusicaNaPosicao(musica, posicao);
        } else {
            System.out.println("❌ Lista de reprodução não definida.");
        }
    }
}