/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_2301010544;

import static java.nio.file.Files.size;
import java.util.Scanner;

/**
 *
 * @author LAB F
 */
public class Baju {
    private String modelBaju;
    private String sizeBaju;
    private double hargaBaju;

    public Baju(String modelBaju, String sizeBaju, double hargaBaju) {
        this.modelBaju = modelBaju;
        this.sizeBaju = sizeBaju;
        this.hargaBaju = hargaBaju;
    }

    // Getter dan Setter
    public String getModelBaju() { return modelBaju; }
    public void setModelBaju(String modelBaju) { this.modelBaju = modelBaju; }
    public String getSizeBaju() { return sizeBaju; }
    public void setSizeBaju(String sizeBaju) { this.sizeBaju = sizeBaju; }
    public double getHargaBaju() { return hargaBaju; }
    public void setHargaBaju(double hargaBaju) { this.hargaBaju = hargaBaju; }

    @Override
    public String toString() {
        return "Baju{" +
                "modelBaju='" + modelBaju + '\'' +
                ", sizeBaju='" + sizeBaju + '\'' +
                ", hargaBaju=" + hargaBaju +
                '}';
    }
}

class AplikasiPembelianBaju {
    private Baju[] daftarBaju;
    private int jumlahBaju;
    private Scanner input;

    public AplikasiPembelianBaju() {
        daftarBaju = new Baju[100]; // Batas maksimal baju yang bisa disimpan
        jumlahBaju = 0;
        input = new Scanner(System.in);
    }

    public void menuAplikasi() {
        int pilihan;
        do {
            System.out.println("\nMenu Aplikasi Pembelian Baju");
            System.out.println("1. Tambah Baju");
            System.out.println("2. Tampilkan Baju");
            System.out.println("3. Ubah Data Baju");
            System.out.println("4. Hapus Baju");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = input.nextInt();
            input.nextLine(); // Consume newline

            switch (pilihan) {
                case 1: tambahBaju(); break;
                case 2: tampilkanBaju(); break;
                case 3: ubahBaju(); break;
                case 4: hapusBaju(); break;
                case 0: System.out.println("Keluar dari aplikasi."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        input.close();
    }

    private void tambahBaju() {
        System.out.print("Model Baju: ");
        String model = input.nextLine();
        System.out.print("Size Baju: ");
        String size = input.nextLine();
        System.out.print("Harga Baju: ");
        double harga = input.nextDouble();
        input.nextLine(); // Consume newline

        daftarBaju[jumlahBaju] = new Baju(model, size, harga);
        jumlahBaju++;
        System.out.println("Baju berhasil ditambahkan.");
    }

    private void tampilkanBaju() {
        if (jumlahBaju == 0) {
            System.out.println("Belum ada data baju.");
            return;
        }
        System.out.println("\nDaftar Baju:");
        for (int i = 0; i < jumlahBaju; i++) {
            System.out.println((i + 1) + ". " + daftarBaju[i]);
        }
    }

    private void ubahBaju() {
        tampilkanBaju();
        System.out.print("Pilih nomor baju yang akan diubah (1-" + jumlahBaju + "): ");
        int index = input.nextInt();
        input.nextLine(); // Consume newline

        if (index >= 1 && index <= jumlahBaju) {
            System.out.print("Model Baju baru: ");
            daftarBaju[index - 1].setModelBaju(input.nextLine());
            System.out.print("Size Baju baru: ");
            daftarBaju[index - 1].setSizeBaju(input.nextLine());
            System.out.print("Harga Baju baru: ");
            daftarBaju[index - 1].setHargaBaju(input.nextDouble());
            input.nextLine(); // Consume newline
            System.out.println("Data baju berhasil diubah.");
        } else {
            System.out.println("Nomor baju tidak valid.");
        }
    }

    private void hapusBaju() {
        tampilkanBaju();
        System.out.print("Pilih nomor baju yang akan dihapus (1-" + jumlahBaju + "): ");
        int index = input.nextInt();

        if (index >= 1 && index <= jumlahBaju) {
            for (int i = index - 1; i < jumlahBaju - 1; i++) {
                daftarBaju[i] = daftarBaju[i + 1];
            }
            jumlahBaju--;
            System.out.println("Baju berhasil dihapus.");
        } else {
            System.out.println("Nomor baju tidak valid.");
        }
    }
}