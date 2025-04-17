package main;

import java.util.Scanner;

public class MangaSoundApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MangaSoundController controller = new MangaSoundController(); // Classe controladora

        int opcao;

        do {
            System.out.println("===== 🎧 MangaSound - Menu Principal =====");
            System.out.println("1. Adicionar Música ao Repositório");
            System.out.println("2. Criar Lista de Reprodução");
            System.out.println("3. Editar Lista de Reprodução");
            System.out.println("4. Executar Lista de Reprodução");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, insira um número válido: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("🎵 Título da música: ");
                    String titulo = scanner.nextLine();

                    System.out.print("🎤 Artista: ");
                    String artista = scanner.nextLine();

                    System.out.print("📁 Caminho do arquivo (.wav): ");
                    String path = scanner.nextLine();

                    controller.adicionarMusica(titulo, path, artista);

                    System.out.println("✅ Música adicionada com sucesso ao repositório!\n");
                    break;

                case 2:
                    System.out.print("📄 Nome da nova lista de reprodução: ");
                    String nomeLista = scanner.nextLine();

                    controller.criarListaReproducao(nomeLista);

                    System.out.println("✅ Lista \"" + nomeLista + "\" criada com sucesso!\n");
                    break;

                case 3:
                    System.out.print("🔢 Número da lista que deseja editar: ");
                    int numeroLista = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    System.out.print("🔢 Número da música que deseja mover: ");
                    int numeroMusica = scanner.nextInt();

                    System.out.print("➡️ Nova posição na lista: ");
                    int novaPosicao = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    controller.editarListaReproducao(numeroLista, numeroMusica, novaPosicao);

                    System.out.println("✅ Lista de reprodução editada com sucesso!\n");
                    break;

                case 4:
                    System.out.print("🔢 Número da lista que deseja executar: ");
                    int listaParaExecutar = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    System.out.println("🎶 Executando lista... Use os comandos:");
                    System.out.println("p - parar | v - voltar | n - próxima | s - sair da execução");

                    controller.executarLista(listaParaExecutar, scanner);

                    System.out.println("🏁 Execução finalizada.\n");
                    break;

                case 5:
                    System.out.println("👋 Saindo do MangaSound. Até logo!");
                    break;

                default:
                    System.out.println("❌ Opção inválida. Escolha entre 1 e 5.\n");
            }

        } while (opcao != 5);

        scanner.close();
    }
}