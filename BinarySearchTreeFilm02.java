public class BinarySearchTreeFilm02 {
    NodeFilm02 root;
    
    public BinarySearchTreeFilm02() {
        this.root = null;
    }
    
    // Cek apakah tree kosong
    public boolean isEmpty() {
        return root == null;
    }
    
    // Tambah data film ke tree
    public void add(Film02Data data) {
        root = addRecursive(root, data);
    }
    
    private NodeFilm02 addRecursive(NodeFilm02 node, Film02Data data) {
        if (node == null) {
            return new NodeFilm02(data);
        }
        
        if (data.kodeFilm.compareTo(node.data.kodeFilm) < 0) {
            node.left = addRecursive(node.left, data);
        } else if (data.kodeFilm.compareTo(node.data.kodeFilm) > 0) {
            node.right = addRecursive(node.right, data);
        }
        
        return node;
    }
    
    // Cari film berdasarkan kode
    public Film02Data find(String kodeFilm) {
        return findRecursive(root, kodeFilm);
    }
    
    private Film02Data findRecursive(NodeFilm02 node, String kodeFilm) {
        if (node == null) {
            return null;
        }
        
        int compare = kodeFilm.compareTo(node.data.kodeFilm);
        if (compare == 0) {
            return node.data;
        } else if (compare < 0) {
            return findRecursive(node.left, kodeFilm);
        } else {
            return findRecursive(node.right, kodeFilm);
        }
    }
    
    // Traversal In-Order (Left, Root, Right)
    public void traverseInOrder(NodeFilm02 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node.data);
            traverseInOrder(node.right);
        }
    }
    
    // Traversal Pre-Order (Root, Left, Right)
    public void traversePreOrder(NodeFilm02 node) {
        if (node != null) {
            System.out.println(node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    
    // Traversal Post-Order (Left, Right, Root)
    public void traversePostOrder(NodeFilm02 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(node.data);
        }
    }
    
    // Hitung tinggi/height tree
    public int hitungHeightFilm(NodeFilm02 node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(hitungHeightFilm(node.left), hitungHeightFilm(node.right));
    }
    
    // Cari rating tertinggi
    public double cariRatingTertinggi(NodeFilm02 node) {
        if (node == null) {
            return 0;
        }
        
        double maxRating = node.data.rating;
        double leftMax = cariRatingTertinggi(node.left);
        double rightMax = cariRatingTertinggi(node.right);
        
        maxRating = Math.max(maxRating, leftMax);
        maxRating = Math.max(maxRating, rightMax);
        
        return maxRating;
    }
    
    // Cari film dengan rating tertinggi
    public Film02Data cariFilmRatingTertinggi(NodeFilm02 node, double ratingTarget) {
        if (node == null) {
            return null;
        }
        
        if (node.data.rating == ratingTarget) {
            return node.data;
        }
        
        Film02Data leftResult = cariFilmRatingTertinggi(node.left, ratingTarget);
        if (leftResult != null) {
            return leftResult;
        }
        
        return cariFilmRatingTertinggi(node.right, ratingTarget);
    }
    
    // Hitung jumlah node/film dalam tree
    public int hitungJumlahFilm(NodeFilm02 node) {
        if (node == null) {
            return 0;
        }
        return 1 + hitungJumlahFilm(node.left) + hitungJumlahFilm(node.right);
    }
}

