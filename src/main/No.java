package main;

public class No {
    private Musica musica;
    private No proximoNo;

    public No(Musica musica) {
        this.musica = musica;
        this.proximoNo = null;
    }

    public Musica getMusica() {
        return musica;
    }

    public No getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }
    
}
