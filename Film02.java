public class Film02Data {
    String kodeFilm;
    String judul;
    String genre;
    double rating;
    
    public Film02Data(String kodeFilm, String judul, String genre, double rating) {
        this.kodeFilm = kodeFilm;
        this.judul = judul;
        this.genre = genre;
        this.rating = rating;
    }
    
    public String toString() {
        return String.format("%-6s | %-20s | %-15s | %.1f", kodeFilm, judul, genre, rating);
    }
}
