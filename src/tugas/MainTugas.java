package tugas;

// Nama : Noor Alamsyah
// NPM  : 2410010052

public class MainTugas {

    public static void main(String[] args) {

        String[] kategori = {
            "Novel",
            "Teknologi",
            "Pendidikan"
        };

        System.out.println("=== KATEGORI BUKU ===");

        for (String k : kategori) {
            System.out.println("- " + k);
        }

        System.out.println();

        Perpustakaan perpus = new Perpustakaan("buku.txt");

        perpus.tambahBuku(new Buku(
                "Laskar Pelangi",
                "Andrea Hirata",
                10));

        perpus.tambahBuku(new Buku(
                "Bumi",
                "Tere Liye",
                7));

        perpus.tambahBuku(new Buku(
                "Pemrograman Java",
                "Abdul Kadir",
                5));

        perpus.tambahBuku(new Buku(
                "Algoritma",
                "Rinaldi Munir",
                8));

        perpus.tambahBuku(new Buku(
                "Atomic Habits",
                "James Clear",
                4));

        System.out.println("\n=== DATA BUKU ===");
        perpus.tampilkanSemua();

        perpus.simpanKeBerkas();

        System.out.println();

        Perpustakaan perpusBaru =
                new Perpustakaan("buku.txt");

        perpusBaru.muatDariBerkas();

        System.out.println("\n=== DATA HASIL MEMBACA FILE ===");
        perpusBaru.tampilkanSemua();

        System.out.println("Total stok buku : "
                + perpusBaru.totalBuku());
    }
}