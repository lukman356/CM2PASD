import java.util.Scanner;

/**
 * Class Main - Program utama Sistem Manajemen Antrian (CM) Royal Delish
 * 
 * Implementasi sistem antrian berbasis Double Linked List untuk manajemen queue pelanggan.
 * Fitur:  
 * - Manajemen antrian real-time (tambah/hapus/cari)
 * - Input pesanan dengan pilihan menu
 * - Laporan pesanan dengan sorting dan statistik
 * - Tracking pendapatan dan analisis pesanan
 * 
 * Flow utama: Menu -> Input/Manajemen -> Laporan & Analisis
 */
public class Main {
    private static Antrian antrian;
    private static Laporan laporan;
    private static Scanner scanner;
    
    /**
     * Entry point program dengan loop menu interaktif
     */
    public static void main(String[] args) {
        antrian = new Antrian();
        laporan = new Laporan(100);
        scanner = new Scanner(System.in);
        
        int pilihan;
        boolean running = true;
        
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih menu : ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    tambahAntrian();
                    break;
                case 2:
                    cetakAntrian();
                    break;
                case 3:
                    hapusAntrian();
                    break;
                case 4:
                    cariPembaliPosisi();   /*kode baru untuk fitur cari pembeli berdasarkan posisi dalam antrian*/
                    break;
                case 5:
                    inputPesanan();
                    break;
                case 6:
                    laporanPesanan();
                    break;
                case 0:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem antrian Royal Delish!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    /**
     * Tampilkan menu utama pilihan operasi
     */
    private static void tampilkanMenu() {
        System.out.println("\n========== SISTEM ANTRIAN ROYAL DELISH ==========");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian dan Pesan Makanan");
        System.out.println("4. Cari Pembeli Berdasarkan Posisi"); /*kode baru untuk fitur cari pembeli berdasarkan posisi dalam antrian*/
        System.out.println("5. Input Pesanan ke Laporan");
        System.out.println("6. Laporan Pesanan");
        System.out.println("0. Keluar");
        System.out.println("================================================");
    }
    
    /**
     * Input data pembeli + pilih menu pesanan, tambah ke antrian
     */
    private static void tambahAntrian() {
        System.out.println("\n---------- TAMBAH ANTRIAN ----------");
        
        System.out.print("Nama Pembeli : ");
        String namaPembeli = scanner.nextLine();
        
        System.out.print("No HP : ");
        String noHp = scanner.nextLine();
        
        pembeli pembeliObj = new pembeli(namaPembeli, noHp);
        
        System.out.println("\nPilih Menu:");
        System.out.println("1. Es Teh - Rp 5000");
        System.out.println("2. Es Jeruk - Rp 5000");
        System.out.println("3. Es Degan - Rp 6000");
        System.out.println("4. Es Cendol - Rp 7000");
        System.out.print("Pilih menu : ");
        int pilihanMenu = scanner.nextInt();
        scanner.nextLine();
        
        pesanan pesananObj;
        switch (pilihanMenu) {
            case 1:
                pesananObj = new pesanan(1, "Es Teh", 5000);
                break;
            case 2:
                pesananObj = new pesanan(2, "Es Jeruk", 5000);
                break;
            case 3:
                pesananObj = new pesanan(3, "Es Degan", 6000);
                break;
            case 4:
                pesananObj = new pesanan(4, "Es Cendol", 7000);
                break;
            default:
                System.out.println("Menu tidak valid!");
                return;
        }
        
        antrian.tambahAntrian(pembeliObj, pesananObj);
    }
    
    /**
     * Cetak daftar semua antrian yang sedang aktif
     */
    private static void cetakAntrian() {
        antrian.cetakAntrian();
    }
    
    /**
     * Cari pembeli berdasarkan posisi dalam antrian (fitur baru)
     * Pengguna input nomor posisi dan sistem menampilkan data pembeli tersebut
     */
    /**
     * Mencari dan menampilkan data pembeli berdasarkan posisi antrian.
     * Meminta input posisi antrian dari pengguna, kemudian menampilkan
     * informasi pembeli yang berada pada posisi tersebut dalam antrian.
     */
    private static void cariPembaliPosisi() {
        System.out.println("\n---------- CARI PEMBELI BERDASARKAN POSISI ----------");
        System.out.print("Masukkan posisi antrian (ke-): ");
        int posisi = scanner.nextInt();
        scanner.nextLine();
        
        antrian.tampilkanPembaliPosisi(posisi);
    }
    
    /**
     * Cari antrian berdasarkan nomor, tampilkan detail, lalu hapus & arsipkan ke laporan
     */
    private static void hapusAntrian() {
        System.out.println("\n---------- HAPUS ANTRIAN ----------");
        System.out.print("Masukkan nomor antrian yang akan dihapus : ");
        int nomor = scanner.nextInt();
        scanner.nextLine();
        
        node nd = antrian.cariAntrian(nomor);
        if (nd != null) {
            System.out.println("\nAntrian yang akan dihapus:");
            System.out.println("Nomor Antrian: " + nd.getNomorAntrian());
            System.out.println("Nama Pembeli: " + nd.getPembeli().getNamaPembeli());
            System.out.println("Menu: " + nd.getPesanan().getNamaPesanan());
            System.out.println("Harga: " + nd.getPesanan().getHarga());
            
            // Tambah ke laporan sebelum dihapus
            laporan.tambahPesananLaporan(nd);
            
            antrian.hapusAntrian(nomor);
        } else {
            System.out.println("Antrian nomor " + nomor + " tidak ditemukan!");
        }
    }
    
    /**
     * Tambahkan pesanan aktif ke laporan untuk tracking & analytics
     */
    private static void inputPesanan() {
        System.out.println("\n---------- INPUT PESANAN KE LAPORAN ----------");
        System.out.print("Masukkan nomor antrian : ");
        int nomor = scanner.nextInt();
        scanner.nextLine();
        
        node nd = antrian.cariAntrian(nomor);
        if (nd != null) {
            laporan.tambahPesananLaporan(nd);
            System.out.println("Pesanan berhasil ditambahkan ke laporan!");
        } else {
            System.out.println("Antrian nomor " + nomor + " tidak ditemukan!");
        }
    }
    
    /**
     * Menu laporan: view, sorting, atau lihat statistik penjualan
     */
    private static void laporanPesanan() {
        System.out.println("\n---------- LAPORAN PESANAN ----------");
        System.out.println("1. Tampilkan Laporan");
        System.out.println("2. Sorting Pesanan (Berdasarkan Nama)");
        System.out.println("3. Statistik Pesanan");
        System.out.print("Pilih menu : ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        
        switch (pilihan) {
            case 1:
                laporan.tampilkanLaporan();
                break;
            case 2:
                laporan.sortingBerdasarkanNama();
                laporan.tampilkanLaporan();
                break;
            case 3:
                tampilkanStatistik();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }
    
    /**
     * Tampilkan analisis: total pesanan, pendapatan, rata-rata, harga tertinggi/terendah
     */
    private static void tampilkanStatistik() {
        System.out.println("\n========== STATISTIK PESANAN ==========");
        System.out.println("Total Pesanan: " + laporan.getJumlahPesanan());
        System.out.println("Total Pendapatan: Rp " + laporan.hitungTotalPendapatan());
        System.out.println("Rata-rata Harga: Rp " + String.format("%.2f", laporan.hitungRataRataHarga()));
        
        node tertinggi = laporan.getPesananTertinggi();
        if (tertinggi != null) {
            System.out.println("\nPesanan Tertinggi:");
            System.out.println("  Menu: " + tertinggi.getPesanan().getNamaPesanan());
            System.out.println("  Harga: Rp " + tertinggi.getPesanan().getHarga());
        }
        
        node terendah = laporan.getPesananTerendah();
        if (terendah != null) {
            System.out.println("\nPesanan Terendah:");
            System.out.println("  Menu: " + terendah.getPesanan().getNamaPesanan());
            System.out.println("  Harga: Rp " + terendah.getPesanan().getHarga());
        }
        System.out.println("======================================");
    }
}
