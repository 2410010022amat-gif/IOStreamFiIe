package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Perpustakaan {

    private ArrayList<Buku> daftarBuku = new ArrayList<>();
    private String namaBerkas;

    public Perpustakaan(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanSemua() {

        System.out.println("=== DAFTAR BUKU ===");

        for (int i = 0; i < daftarBuku.size(); i++) {
            System.out.println((i + 1) + ".");
            System.out.println(daftarBuku.get(i).info());
            System.out.println();
        }
    }

    public void simpanKeBerkas() {

        try (PrintWriter penulis =
                new PrintWriter(new FileWriter(namaBerkas))) {

            for (Buku b : daftarBuku) {
                penulis.println(b.keBaris());
            }

            System.out.println("Data berhasil disimpan ke " + namaBerkas);

        } catch (IOException e) {
            System.out.println("Gagal menyimpan : " + e.getMessage());
        }
    }

    public void muatDariBerkas() {

        daftarBuku.clear();

        try (BufferedReader pembaca =
                new BufferedReader(new FileReader(namaBerkas))) {

            String baris;

            while ((baris = pembaca.readLine()) != null) {

                String[] data = baris.split(";");

                if (data.length == 3) {

                    daftarBuku.add(
                            new Buku(
                                    data[0],
                                    data[1],
                                    Integer.parseInt(data[2])
                            )
                    );
                }
            }

            System.out.println("Data berhasil dimuat dari " + namaBerkas);

        } catch (IOException e) {
            System.out.println("Gagal memuat : " + e.getMessage());
        }
    }

    public int totalBuku() {

        int total = 0;

        for (Buku b : daftarBuku) {
            total += b.getStok();
        }

        return total;
    }
}