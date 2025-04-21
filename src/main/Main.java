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
                    // código inalterado para adicionar música
                    System.out.print("🎵 Título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("🎤 Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("📁 Caminho do arquivo (.wav): ");
                    String path = scanner.nextLine();

                    if (controller.adicionarMusicaAoRepositorio(titulo, artista, path)) {
                        System.out.println("✅ Música adicionada ao repositório com sucesso!\n");
                    } else {
                        System.out.println("❌ Não foi possível adicionar a música. Verifique o caminho do arquivo.\n");
                    }
                    break;

                case 2:
                    // código inalterado para criar lista
                    System.out.print("📄 Nome da nova lista de reprodução: ");
                    String nomeLista = scanner.nextLine();
                    controller.criarNovaLista(nomeLista);
                    System.out.println("✅ Lista \"" + nomeLista + "\" criada com sucesso!\n");
                    break;

                case 3:
                    // editar lista: agora passa índice de lista e música sem subtrair 1
                    controller.listarListas();
                    System.out.print("🔢 Número da lista para editar: ");
                    int numeroLista = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    if (numeroLista < 1 || numeroLista > controller.quantidadeListas()) {
                        System.out.println("❌ Lista não encontrada. Tente novamente.\n");
                        break;
                    }

                    controller.exibirMusicasRepositorio();
                    System.out.print("🎼 Índice da música para adicionar: ");
                    int indiceMusica = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    System.out.print("➡️ Posição para inserir na lista (0 = início): ");
                    int novaPosicao = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    if (controller.adicionarMusicaNaLista(numeroLista, indiceMusica, novaPosicao)) {
                        System.out.println("✅ Música adicionada à lista com sucesso!\n");
                    } else {
                        System.out.println("❌ Não foi possível adicionar a música. Verifique os índices.\n");
                    }
                    break;

                case 4:
                    // executar lista: passa índice de lista sem subtrair 1
                    controller.listarListas();
                    System.out.print("🔢 Número da lista para executar: ");
                    int listaParaExec = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    if (listaParaExec < 1 || listaParaExec > controller.quantidadeListas()) {
                        System.out.println("❌ Lista não encontrada. Tente novamente.\n");
                        break;
                    }

                    controller.executarLista(listaParaExec, scanner);
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
