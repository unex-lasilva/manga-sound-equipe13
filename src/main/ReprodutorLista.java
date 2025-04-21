package main;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReprodutorLista {
    private ListaReproducao lista;
    private int indiceAtual;
    private Clip clip;

    public ReprodutorLista(ListaReproducao lista) {
        this.lista = lista;
        this.indiceAtual = 0;
    }

    public void play() {
        stop(); // Para qualquer música anterior
        Musica musica = lista.getMusica(indiceAtual);
        if (musica == null) {
            System.out.println("❌ Música não encontrada.");
            return;
        }

        try {
            File arquivo = new File(musica.getPath());
            if (!arquivo.exists()) {
                System.out.println("❌ Arquivo de áudio não encontrado: " + musica.getPath());
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("🎧 Tocando: " + musica.getTitulo() + " - " + musica.getArtista());

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("❌ Erro ao reproduzir a música: " + e.getMessage());
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            System.out.println("⏸️ Música pausada.");
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public void proximaMusica() {
        if (indiceAtual < lista.quantidadeDeMusicas() - 1) {
            indiceAtual++;
            play();
        } else {
            System.out.println("🚫 Última música da lista.");
        }
    }

    public void musicaAnterior() {
        if (indiceAtual > 0) {
            indiceAtual--;
            play();
        } else {
            System.out.println("🚫 Já está na primeira música.");
        }
    }
}
