package main;

public class ListaReproducao {
    private String titulo;
    private ListaEncadeada lista;

    public ListaReproducao(String titulo) {
        this.titulo = titulo;
        this.lista = new ListaEncadeada();
    }

    public String getTitulo() {
        return titulo;
    }

    public ListaEncadeada getlista() {
        return lista;
    }

    public Musica getMusica(int posicao) {
        return (Musica) lista.get(posicao);
    }


    public int quantidadelista() {
        return lista.size();
    }

    public void addMusica(Musica musica) {
        lista.append(musica);
    }

    public void inserirMusica(int posicao, Musica musica) {
        if (posicao < 0 || posicao > lista.size()) {
            System.out.println("Posição inválida para inserir música.");
        } else {
            lista.inserir(posicao, musica);
        }
    }

    public boolean contemMusica(Musica musica) {
        return lista.posicaoDa(musica) != -1;
    }

    public int tamanho() {
        return lista.size();
    }

    public void removerMusica(int posicao) {
        if (posicao < 0 || posicao >= lista.size()) {
            System.out.println("Posição inválida para remover música.");
        } else {
            Musica musicaRemovida = (Musica) lista.get(posicao);
            lista.remove(posicao);
            System.out.println("Música removida: " + musicaRemovida.getTitulo() + " - " + musicaRemovida.getArtista());
        }
    }

    public int posicaoDa(Musica musica) {
        for (int i = 0; i < lista.size(); i++) {
            Musica atual = (Musica) lista.get(i);
            if (atual.equals(musica)) {
                return i;
            }
        }
        return -1;
    }

    public boolean limparLista() {
        if (lista.size() == 0) {
            System.out.println("A lista já está vazia.");
            return false;
        } else {
            lista = new ListaEncadeada();
            System.out.println("Lista de reprodução limpa com sucesso.");
            return true;
        }
    }

    public void criarListaReproducao() {
        this.titulo = "Nova Lista de Reprodução";
        System.out.println("Criando nova lista de reprodução: " + titulo);
        lista = new ListaEncadeada();
    }

    public Musica obterMusica(int posicao) {
        if (posicao >= 0 && posicao < lista.size()) {
            return (Musica) lista.get(posicao);
        }
        return null;
    }

}
