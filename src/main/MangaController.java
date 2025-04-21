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

    public boolean adicionarMusicaAoRepositorio(String titulo, String artista, String path) {
        if (titulo == null || artista == null || path == null || titulo.isEmpty() || artista.isEmpty() || path.isEmpty()) {
            System.out.println("❌ Dados inválidos para a música.");
            return false;
        }

        Musica novaMusica = new Musica(titulo, artista, path);
        repositorioMusica.add(novaMusica);
        return true;
    }

    public void criarNovaLista(String nomeLista) {
        if (nomeLista == null || nomeLista.isEmpty()) {
            System.out.println("❌ Nome inválido para a lista.");
            return;
        }

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

    public boolean adicionarMusicaNaLista(int numeroLista, int indiceMusica, int novaPosicao) {
        if (numeroLista < 1 || numeroLista > listasReproducao.size()) {
            System.out.println("❌ Lista de reprodução não encontrada.");
            return false;
        }

        ListaReproducao lista = listasReproducao.get(numeroLista - 1);
        if (indiceMusica < 1 || indiceMusica > repositorioMusica.size()) {
            System.out.println("❌ Música não encontrada no repositório.");
            return false;
        }

        if (novaPosicao < 0 || novaPosicao > lista.quantidadeDeMusicas()) {
            System.out.println("❌ Posição inválida na lista.");
            return false;
        }

        Musica musica = repositorioMusica.get(indiceMusica - 1);
        lista.adicionarMusicaNaPosicao(musica, novaPosicao); 
        System.out.println("✅ Música adicionada à lista \"" + lista.getTitulo() + "\".");
        return true;
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

    public int quantidadeListas() {
        return listasReproducao.size();
    }
}