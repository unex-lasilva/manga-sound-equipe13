package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.sampled.*;

public class MangaController {
    private List<Musica> repositorioMusica;
    private List<ListaReproducao> listasReproducao;

    public MangaController() {
        repositorioMusica = new ArrayList<>();
        listasReproducao = new ArrayList<>();
    }

    public void adicionarMusicaAoRepositorio(String titulo, String artista, String path) {
        Musica novaMusica = new Musica(titulo, artista, path);
        repositorioMusica.add(novaMusica);
    }

    public void criarNovaLista(String nomeLista) {
        ListaReproducao novaLista = new ListaReproducao(nomeLista);
        listasReproducao.add(novaLista);
    }

    public void listarListas() {
        if (listasReproducao.isEmpty()) {
            System.out.println("❌ Nenhuma lista de reprodução encontrada.");
            return;
        }

        System.out.println("\n🎵 Listas de Reprodução:");
        for (int i = 0; i < listasReproducao.size(); i++) {
            System.out.println((i + 1) + ". " + listasReproducao.get(i).getTitulo());
        }
    }

    public void exibirMusicasRepositorio() {
        if (repositorioMusica.isEmpty()) {
            System.out.println("❌ Nenhuma música disponível no repositório.");
            return;
        }

        System.out.println("\n🎼 Músicas no Repositório:");
        for (int i = 0; i < repositorioMusica.size(); i++) {
            System.out.println((i + 1) + ". " + repositorioMusica.get(i).getTitulo() + " - " + repositorioMusica.get(i).getArtista());
        }
    }

    public void adicionarMusicaNaLista(int numeroLista, int indiceMusica, int novaPosicao) {
        if (numeroLista < 1 || numeroLista > listasReproducao.size()) {
            System.out.println("❌ Lista de reprodução não encontrada.");
            return;
        }

        ListaReproducao lista = listasReproducao.get(numeroLista - 1);
        if (indiceMusica < 1 || indiceMusica > repositorioMusica.size()) {
            System.out.println("❌ Música não encontrada no repositório.");
            return;
        }

        Musica musica = repositorioMusica.get(indiceMusica - 1);
        lista.adicionarMusicaNaPosicao(musica, novaPosicao - 1); 
        System.out.println("✅ Música adicionada à lista \"" + lista.getTitulo() + "\".");
    }

    public void executarLista(int numeroLista, Scanner scanner) {
        if (numeroLista < 1 || numeroLista > listasReproducao.size()) {
            System.out.println("❌ Lista de reprodução não encontrada.");
            return;
        }

        ListaReproducao lista = listasReproducao.get(numeroLista - 1);
        ReprodutorLista reprodutor = new ReprodutorLista(lista);
        System.out.println("🎶 Reproduzindo a lista: " + lista.getTitulo());

        String comando;
        do {
            reprodutor.play();
            System.out.print("Comando (p=parar, v=voltar, n=próxima, s=sair): ");
            comando = scanner.nextLine();

            switch (comando.toLowerCase()) {
                case "p":
                    reprodutor.pause();
                    break;
                case "v":
                    reprodutor.musicaAnterior();
                    break;
                case "n":
                    reprodutor.proximaMusica();
                    break;
                case "s":
                    reprodutor.stop();
                    break;
                default:
                    System.out.println("❌ Comando inválido.");
            }

        } while (!comando.equalsIgnoreCase("s"));
    }
}