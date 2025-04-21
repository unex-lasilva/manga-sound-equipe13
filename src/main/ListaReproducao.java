package main;

public class ListaReproducao {
    private String titulo;
    private ListaEncadeada<Musica> lista;

    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.lista = new ListaEncadeada<>(); 
    }

    public String getTitulo() {
        return titulo;
    }

    public ListaEncadeada<Musica> getLista() {
        return lista;
    }

    public Musica getMusica(int posicao) {
        if (posicao < 0 || posicao >= lista.size()) {
            return null;
        }
        return lista.get(posicao);
    }

    public int quantidadeDeMusicas() {
        return lista.size();
    }

    public void addMusica(Musica musica) {
        if (musica != null) {
            lista.append(musica);
        } else {
            System.out.println("Música inválida.");
        }
    }

    public void inserirMusica(int posicao, Musica musica) {
        if (musica == null) {
            System.out.println("Música inválida.");
            return;
        }
        if (posicao < 0 || posicao > lista.size()) {
            System.out.println("Posição inválida para inserir música.");
        } else {
            lista.inserir(posicao, musica);
        }
    }

    public boolean contemMusica(Musica musica) {
        return musica != null && lista.posicaoDa(musica) != -1;
    }

    public void removerMusica(int posicao) {
        if (posicao < 0 || posicao >= lista.size()) {
            System.out.println("Posição inválida para remover música.");
        } else {
            Musica musicaRemovida = lista.get(posicao);
            lista.remove(posicao);
            System.out.println("Música removida: " +
                musicaRemovida.getTitulo() + " - " + musicaRemovida.getArtista());
        }
    }

    public int posicaoDa(Musica musica) {
        if (musica == null) return -1;
        return lista.posicaoDa(musica);
    }

    public boolean limparLista() {
        if (lista.size() == 0) {
            System.out.println("A lista já está vazia.");
            return false;
        } else {
            lista = new ListaEncadeada<>();
            System.out.println("Lista de reprodução limpa com sucesso.");
            return true;
        }
    }

    public void criarListaReproducao(String nome) {
        this.titulo = nome != null ? nome : "Nova Lista de Reprodução";
        System.out.println("Criando nova lista de reprodução: " + titulo);
        lista = new ListaEncadeada<>();
    }

    public Musica obterMusica(int posicao) {
        if (posicao >= 0 && posicao < lista.size()) {
            return lista.get(posicao);
        }
        return null;
    }

    public void adicionarMusicaNaPosicao(Musica musica, int posicao) {
        if (musica != null && posicao >= 0 && posicao <= lista.size()) {
            lista.inserir(posicao, musica);
        } else {
            System.out.println("Posição inválida ou música não válida.");
        }
    }

    public void display() {
        System.out.println("Playlist: " + titulo);
        if (quantidadeDeMusicas() == 0) {
            System.out.println("  (Vazia)");
        } else {
            for (int i = 0; i < quantidadeDeMusicas(); i++) {
                Musica m = obterMusica(i);
                if (m != null) {
                    System.out.printf("  %d. %s - %s [%s, %d, %s, %ds]%n",
                        i + 1,
                        m.getTitulo(),
                        m.getArtista(),
                        m.getAlbum(),
                        m.getAnoLancamento(),
                        m.getGenero(),
                        m.getDuracao());
                } else {
                    System.out.println("  " + (i + 1) + ". [Erro ao obter música]");
                }
            }
        }
    }

    public int tamanho() {
        return lista.size();
    }
}
