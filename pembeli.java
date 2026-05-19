/**
 * Class pembeli - Menyimpan informasi pembeli untuk Sistem Manajemen Antrian (CM)
 * 
 * Entitas penting di CM yang merepresentasikan data customer yang melakukan pemesanan.
 * Setiap pembeli memiliki identitas unik berupa nama dan nomor HP untuk komunikasi.
 */
public class pembeli {
    private String namaPembeli;
    private String noHp;
    
    /**
     * Membuat data pembeli baru dengan identitas dasar
     */
    public pembeli(String namaPembeli, String noHp) {
        this.namaPembeli = namaPembeli;
        this.noHp = noHp;
    }
    
    public String getNamaPembeli() {
        return namaPembeli;
    }
    
    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }
    
    public String getNoHp() {
        return noHp;
    }
    
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    
    @Override
    public String toString() {
        return "Pembeli{" +
                "Nama='" + namaPembeli + '\'' +
                ", No HP='" + noHp + '\'' +
                '}';
    }
}
