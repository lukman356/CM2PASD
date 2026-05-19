/**
 * Class node - Node untuk Double Linked List di Sistem Manajemen Antrian (CM)
 * 
 * Struktur data krusial yang menghubungkan pembeli, pesanan, dan nomor antrian.
 * Menggunakan double linked list untuk efisiensi operasi penghapusan dan traversal.
 * Setiap node menyimpan referensi ke node sebelum (prev) dan sesudah (next).
 */
public class node {
    private int nomorAntrian;
    private pembeli pembeli;
    private pesanan pesanan;
    private node prev;
    private node next;
    
    /**
     * Membuat node baru dalam antrian dengan data pembeli dan pesanan
     */
    public node(int nomorAntrian, pembeli pembeli, pesanan pesanan) {
        this.nomorAntrian = nomorAntrian;
        this.pembeli = pembeli;
        this.pesanan = pesanan;
        this.prev = null;
        this.next = null;
    }
    
    public int getNomorAntrian() {
        return nomorAntrian;
    }
    
    public void setNomorAntrian(int nomorAntrian) {
        this.nomorAntrian = nomorAntrian;
    }
    
    public pembeli getPembeli() {
        return pembeli;
    }
    
    public void setPembeli(pembeli pembeli) {
        this.pembeli = pembeli;
    }
    
    public pesanan getPesanan() {
        return pesanan;
    }
    
    public void setPesanan(pesanan pesanan) {
        this.pesanan = pesanan;
    }
    
    public node getPrev() {
        return prev;
    }
    
    public void setPrev(node prev) {
        this.prev = prev;
    }
    
    public node getNext() {
        return next;
    }
    
    public void setNext(node next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "Node{" +
                "Nomor Antrian=" + nomorAntrian +
                ", " + pembeli.toString() +
                ", " + pesanan.toString() +
                '}';
    }
}
