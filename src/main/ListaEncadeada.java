package main;

public class ListaEncadeada<T> {
    private No<T> primeiro;
    private int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.tamanho = 0;
    }

    // Adiciona um elemento ao final da lista
    public void append(T elemento) {
        if (elemento == null) return;

        No<T> novo = new No<>(elemento);
        if (primeiro == null) {
            primeiro = novo;
        } else {
            No<T> atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
        tamanho++;
    }

    // Insere um elemento em uma posição específica
    public void inserir(int posicao, T elemento) {
        if (posicao < 0 || posicao > tamanho || elemento == null) return;

        No<T> novo = new No<>(elemento);

        if (posicao == 0) {
            novo.setProximo(primeiro);
            primeiro = novo;
        } else {
            No<T> anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }
            novo.setProximo(anterior.getProximo());
            anterior.setProximo(novo);
        }

        tamanho++;
    }

    // Obtém o elemento na posição especificada
    public T get(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return null;

        No<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual.getElemento();
    }

    // Remove o elemento na posição especificada
    public void remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return;

        if (posicao == 0) {
            primeiro = primeiro.getProximo();
        } else {
            No<T> anterior = primeiro;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = anterior.getProximo();
            }
            No<T> atual = anterior.getProximo();
            anterior.setProximo(atual.getProximo());
        }

        tamanho--;
    }

    // Retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Retorna a posição do elemento na lista
    public int posicaoDa(T elemento) {
        if (elemento == null) return -1;

        No<T> atual = primeiro;
        for (int i = 0; i < tamanho; i++) {
            if (atual.getElemento().equals(elemento)) return i;
            atual = atual.getProximo();
        }
        return -1;
    }

    // Classe interna No<T>
    private static class No<T> {
        private T elemento;
        private No<T> proximo;

        public No(T elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }

        public T getElemento() {
            return elemento;
        }

        public No<T> getProximo() {
            return proximo;
        }

        public void setProximo(No<T> proximo) {
            this.proximo = proximo;
        }
    }
}
