package main;

public class No<T> {
    private T elemento;  // Usando generics para permitir tipos específicos
    private No<T> proximo;  // Referência para o próximo nó

    // Construtor
    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    // Getter e Setter para o elemento
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    // Getter e Setter para o próximo nó
    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}