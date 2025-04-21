package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MangaController controller = new MangaController();

        int opcao;

        do {
            System.out.println("=============== 🎧 MangaSound - Menu Principal ===============");
            System.out.println("1- Adicionar Música ao Repositório");
            System.out.println("2- Criar Nova Lista de Reprodução");
            System.out.println("3- Editar Lista de Reprodução");
            System.out.println("4- Executar Lista de Reprodução");
            System.out.println("5- Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, insira um número válido: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("🎵 Título da música: ");
                    String titulo = scanner.nextLine();

                    System.out.print("🎤 Artista: ");
                    String artista = scanner.nextLine();

                    System.out.print("📁 Caminho do arquivo (.wav): ");
                    String path = scanner.nextLine();

                    controller.adicionarMusicaAoRepositorio(titulo, artista, path);
                    System.out.println("✅ Música adicionada ao repositório com sucesso!\n");
                    break;

                case 2:
                    System.out.print("📄 Nome da nova lista de reprodução: ");
                    String nomeLista = scanner.nextLine();

                    controller.criarNovaLista(nomeLista);
                    System.out.println("✅ Lista \"" + nomeLista + "\" criada com sucesso!\n");
                    break;

                case 3:
                    controller.listarListas();
                    System.out.print("🔢 Número da lista para editar: ");
                    int numeroLista = scanner.nextInt();
                    scanner.nextLine();

                    controller.exibirMusicasRepositorio();
                    System.out.print("🎼 Índice da música para adicionar: ");
                    int indiceMusica = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("➡️ Posição para inserir na lista: ");
                    int novaPosicao = scanner.nextInt();
                    scanner.nextLine();

                    controller.adicionarMusicaNaLista(numeroLista, indiceMusica, novaPosicao);
                    break;

                case 4:
                    controller.listarListas();
                    System.out.print("🔢 Número da lista para executar: ");
                    int indice = scanner.nextInt();
                    scanner.nextLine();

                    controller.executarLista(indice, scanner);
                    break;

                case 5:
                    System.out.println("👋 Encerrando o MangaSound. Até a próxima!");
                    break;

                default:
                    System.out.println("❌ Opção inválida. Tente novamente.\n");
            }

        } while (opcao != 5);

        scanner.close();
    }
}