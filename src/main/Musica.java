package main;

public class Musica {
    private String titulo;
    private String artista;
    private String album;
    private int anoLancamento;
    private String genero;
    private int duracao;
    private String path; 

    public Musica(String titulo, String artista, String album, int anoLancamento, String genero, int duracao, String path) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.duracao = duracao;
        this.path = path;
    }

    public Musica(String titulo, String artista, String path) {
        this.titulo = titulo;
        this.artista = artista;
        this.path = path;
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

    public String getPath() {
        return path;
    }
    
}
