package main;

public class ListaEncadeada {
    private No primeiro;
    private int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    public void append(Object elemento) {
        No novo = new No(elemento);
        if (primeiro == null) {
            primeiro = novo;
        } else {
            No atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
        tamanho++;
    }

    public void inserir(int posicao, Object elemento) {
        if (posicao < 0 || posicao > tamanho) return;

        No novo = new No(elemento);

        if (posicao == 0) {
            novo.setProximo(primeiro);
            primeiro = novo;
        } else {
            No anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }
            novo.setProximo(anterior.getProximo());
            anterior.setProximo(novo);
        }

        tamanho++;
    }

    public Object get(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return null;

        No atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual.getElemento();
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return;

        if (posicao == 0) {
            primeiro = primeiro.getProximo();
        } else {
            No anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }
            anterior.setProximo(anterior.getProximo().getProximo());
        }

        tamanho--;
    }

    public int size() {
        return tamanho;
    }

    public int posicaoDa(Object elemento) {
        No atual = primeiro;
        for (int i = 0; i < tamanho; i++) {
            if (atual.getElemento().equals(elemento)) return i;
            atual = atual.getProximo();
        }
        return -1;
    }
}
