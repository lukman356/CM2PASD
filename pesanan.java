/**
 * Class pesanan - Menyimpan data menu/pesanan yang dipesan pelanggan di Sistem Manajemen Antrian (CM)
 * 
 * Entitas penting di CM yang merepresentasikan item pesanan (menu) dengan detail harga.
 * Digunakan untuk tracking pesanan dan perhitungan laporan keuangan.
 */
public class pesanan {
    private int kodePesanan;
    private String namaPesanan;
    private int harga;
    
    /**
     * Membuat data pesanan/menu baru dengan kode, nama, dan harga
     */
    public pesanan(int kodePesanan, String namaPesanan, int harga) {
        this.kodePesanan = kodePesanan;
        this.namaPesanan = namaPesanan;
        this.harga = harga;
    }
    
    public int getKodePesanan() {
        return kodePesanan;
    }
    
    public void setKodePesanan(int kodePesanan) {
        this.kodePesanan = kodePesanan;
    }
    
    public String getNamaPesanan() {
        return namaPesanan;
    }
    
    public void setNamaPesanan(String namaPesanan) {
        this.namaPesanan = namaPesanan;
    }
    
    public int getHarga() {
        return harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    @Override
    public String toString() {
        return "Pesanan{" +
                "Kode=" + kodePesanan +
                ", Nama='" + namaPesanan + '\'' +
                ", Harga=" + harga +
                '}';
    }
}
