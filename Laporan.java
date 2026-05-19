/**
 * Class Laporan - Mengelola laporan pesanan dan statistik di Sistem Manajemen Antrian (CM)
 * 
 * Kelas penting untuk analisis dan reporting. Fitur utama:
 * - Collect pesanan yang sudah diproses
 * - Sorting pesanan berdasarkan nama (Bubble Sort)
 * - Hitung total pendapatan dan rata-rata harga
 * - Statistik: pesanan tertinggi dan terendah
 * 
 * Array dinamis dengan kapasitas terbatas untuk menyimpan riwayat pesanan.
 */
public class Laporan {
    private node[] daftarPesanan;
    private int jumlahPesanan;
    
    /**
     * Inisialisasi laporan dengan kapasitas array tertentu
     */
    public Laporan(int kapasitas) {
        this.daftarPesanan = new node[kapasitas];
        this.jumlahPesanan = 0;
    }
    
    /**
     * Tambah node ke daftar pesanan untuk dianalisis nanti
     */
    public void tambahPesananLaporan(node nd) {
        if (jumlahPesanan < daftarPesanan.length) {
            daftarPesanan[jumlahPesanan] = nd;
            jumlahPesanan++;
        }
    }
    
    /**
     * Tampilkan laporan dengan format tabel lengkap (nomor antrian, pembeli, menu, harga)
     */
    public void tampilkanLaporan() {
        if (jumlahPesanan == 0) {
            System.out.println("\nLaporan kosong! Belum ada pesanan yang masuk.");
            return;
        }
        
        System.out.println("\n========== LAPORAN PESANAN (URUT NAMA PESANAN) ==========");
        System.out.printf("%-15s %-20s %-20s %-15s%n", 
                         "Nomor Antrian", "Nama Pembeli", "Menu", "Harga");
        System.out.println("======================================================");
        
        for (int i = 0; i < jumlahPesanan; i++) {
            node n = daftarPesanan[i];
            System.out.printf("%-15d %-20s %-20s %-15d%n",
                            n.getNomorAntrian(),
                            n.getPembeli().getNamaPembeli(),
                            n.getPesanan().getNamaPesanan(),
                            n.getPesanan().getHarga());
        }
        
        System.out.println("======================================================");
        System.out.println("Total Pesanan: " + jumlahPesanan);
        System.out.println("Total Pendapatan: " + hitungTotalPendapatan());
    }
    
    /**
     * Urutkan pesanan berdasarkan nama menu (ascending) menggunakan Bubble Sort
     */
    public void sortingBerdasarkanNama() {
        for (int i = 0; i < jumlahPesanan - 1; i++) {
            for (int j = 0; j < jumlahPesanan - i - 1; j++) {
                String nama1 = daftarPesanan[j].getPesanan().getNamaPesanan();
                String nama2 = daftarPesanan[j + 1].getPesanan().getNamaPesanan();
                
                // Perbandingan string (ascending)
                if (nama1.compareTo(nama2) > 0) {
                    // Tukar data
                    node temp = daftarPesanan[j];
                    daftarPesanan[j] = daftarPesanan[j + 1];
                    daftarPesanan[j + 1] = temp;
                }
            }
        }
        
        System.out.println("Data pesanan berhasil disort berdasarkan nama!");
    }
    
    /**
     * Hitung total pendapatan dari semua pesanan dalam laporan
     */
    public int hitungTotalPendapatan() {
        int total = 0;
        for (int i = 0; i < jumlahPesanan; i++) {
            total += daftarPesanan[i].getPesanan().getHarga();
        }
        return total;
    }
    
    /**
     * Hitung rata-rata harga pesanan (untuk analisis pricing)
     */
    public double hitungRataRataHarga() {
        if (jumlahPesanan == 0) {
            return 0;
        }
        return (double) hitungTotalPendapatan() / jumlahPesanan;
    }
    
    /**
     * Cari pesanan dengan harga tertinggi (best seller by price)
     */
    public node getPesananTertinggi() {
        if (jumlahPesanan == 0) {
            return null;
        }
        
        node tertinggi = daftarPesanan[0];
        for (int i = 1; i < jumlahPesanan; i++) {
            if (daftarPesanan[i].getPesanan().getHarga() > tertinggi.getPesanan().getHarga()) {
                tertinggi = daftarPesanan[i];
            }
        }
        return tertinggi;
    }
    
    /**
     * Cari pesanan dengan harga terendah (untuk promosi atau analisis)
     */
    public node getPesananTerendah() {
        if (jumlahPesanan == 0) {
            return null;
        }
        
        node terendah = daftarPesanan[0];
        for (int i = 1; i < jumlahPesanan; i++) {
            if (daftarPesanan[i].getPesanan().getHarga() < terendah.getPesanan().getHarga()) {
                terendah = daftarPesanan[i];
            }
        }
        return terendah;
    }
    
    public int getJumlahPesanan() {
        return jumlahPesanan;
    }
}
