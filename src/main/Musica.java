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
        this(titulo, artista, null, 0, null, 0, path);
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

    @Override
    public String toString() {
        return String.format("%s - %s [%s, %d, %s, %ds]", titulo, artista, album != null ? album : "Desconhecido", anoLancamento, genero != null ? genero : "Desconhecido", duracao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Musica musica = (Musica) obj;
        return titulo.equals(musica.titulo) && artista.equals(musica.artista) && path.equals(musica.path);
    }

    @Override
    public int hashCode() {
        return 31 * titulo.hashCode() + 31 * artista.hashCode() + path.hashCode();
    }
}
