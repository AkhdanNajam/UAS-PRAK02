public class Film02 {
    public static void main(String[] args) {
        BinarySearchTreeFilm02InOrder bstInOrder = new BinarySearchTreeFilm02InOrder();
        BinarySearchTreeFilm02PreOrder bstPreOrder = new BinarySearchTreeFilm02PreOrder();
        
        Film02Data[] films = {
            new Film02Data("FL105", "Intertellar", "Sci-Fi", 8.6),
            new Film02Data("FL102", "Coco", "Animation", 8.4),
            new Film02Data("FL108", "Inception", "Sci-Fi", 8.8),
            new Film02Data("FL101", "Up", "Animation", 8.3),
            new Film02Data("FL104", "Parasite", "Thriller", 8.5),
            new Film02Data("FL107", "Spirited Away", "Fantasy", 8.6)
        };
        
        for (Film02Data film : films) {
            bstInOrder.add(film);
            bstPreOrder.add(film);
        }
        
        System.out.println("=== BINARY SEARCH TREE - FILM ===\n");
        
        System.out.println("1. In-Order Traversal:");
        System.out.println("Kode  | Judul                | Genre           | Rating");
        System.out.println("------|----------------------|-----------------|--------");
        bstInOrder.traverseInOrder(bstInOrder.root);
        
        System.out.println("\n2. Pre-Order Traversal:");
        System.out.println("Kode  | Judul                | Genre           | Rating");
        System.out.println("------|----------------------|-----------------|--------");
        bstPreOrder.traversePreOrder(bstPreOrder.root);
        
        System.out.println("\n3. Pencarian FL104:");
        Film02Data fl104 = bstInOrder.find("FL104");
        if (fl104 != null) {
            System.out.println("   Film: " + fl104);
        } else {
            System.out.println("   Film tidak ditemukan");
        }
        
        System.out.println("\n4. Pencarian FL110:");
        Film02Data fl110 = bstInOrder.find("FL110");
        if (fl110 != null) {
            System.out.println("   Film: " + fl110);
        } else {
            System.out.println("   Film tidak ditemukan");
        }
        
        System.out.println("\n5. Jumlah film: " + bstInOrder.hitungJumlahFilm(bstInOrder.root));
        
        System.out.println("\n6. Film dengan rating tertinggi:");
        double maxRating = bstInOrder.cariRatingTertinggi(bstInOrder.root);
        System.out.println("   Rating Tertinggi: " + maxRating);
        Film02Data filmTertinggi = bstInOrder.cariFilmRatingTertinggi(bstInOrder.root, maxRating);
        if (filmTertinggi != null) {
            System.out.println("   Film: " + filmTertinggi);
        }
    }
}