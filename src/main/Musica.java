package main;

public class Musica {
    private String titulo;
    private String artista;
    private String album;
    private int anoLancamento;
    private String genero;
    private int duracao; // em segundos

    public Musica(String titulo, String artista, String album, int anoLancamento, String genero, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }
    
}
