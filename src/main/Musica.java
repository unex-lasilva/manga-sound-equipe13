package main;

public class Musica {
    private String titulo;
    private String artista;
    private String album;
    private int anoLancamento;
    private String genero;
    private int duracao;
    private String path;

    // Construtor completo
    public Musica(String titulo, String artista, String album, int anoLancamento, String genero, int duracao, String path) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.duracao = duracao;
        this.path = path;
    }

    // Construtor simplificado
    public Musica(String titulo, String artista, String path) {
        this(titulo, artista, null, 0, null, 0, path); // reutiliza o construtor completo
    }

    // Getters
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

    // Método toString para facilitar a visualização
    @Override
    public String toString() {
        return String.format("%s - %s [%s, %d, %s, %ds]", titulo, artista, album != null ? album : "Desconhecido", anoLancamento, genero != null ? genero : "Desconhecido", duracao);
    }

    // Método equals para comparar músicas (utilizado, por exemplo, na busca ou comparação de elementos nas listas)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Musica musica = (Musica) obj;
        return titulo.equals(musica.titulo) && artista.equals(musica.artista) && path.equals(musica.path);
    }

    // Método hashCode para garantir que a comparação funcione corretamente em coleções como List, Set, etc.
    @Override
    public int hashCode() {
        return 31 * titulo.hashCode() + 31 * artista.hashCode() + path.hashCode();
    }
}