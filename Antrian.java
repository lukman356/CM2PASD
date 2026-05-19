/**
 * Class Antrian - Manajemen sistem antrian di Sistem Manajemen Antrian (CM) menggunakan Double Linked List
 * 
 * Kelas inti yang mengelola queue pelanggan. Fitur utama:
 * - Tambah antrian baru dengan auto-increment nomor
 * - Cetak seluruh daftar antrian
 * - Hapus antrian dengan traversal double linked list
 * - Cari dan ubah pesanan dalam antrian
 * 
 * Implementasi Double Linked List memberikan efisiensi O(1) untuk penghapusan di tengah queue.
 */
public class Antrian {
    private node head;
    private node tail;
    private int nomorAntrian;
    
    /**
     * Membuat antrian kosong (head dan tail = null)
     */
    public Antrian() {
        this.head = null;
        this.tail = null;
        this.nomorAntrian = 0;
    }
    
    /**
     * Tambah pembeli+pesanan ke antrian dengan nomor urut otomatis
     */
    public void tambahAntrian(pembeli pembeli, pesanan pesanan) {
        nomorAntrian++;
        node nodeBaru = new node(nomorAntrian, pembeli, pesanan);
        
        if (head == null) {
            head = nodeBaru;
            tail = nodeBaru;
        } else {
            tail.setNext(nodeBaru);
            nodeBaru.setPrev(tail);
            tail = nodeBaru;
        }
        
        System.out.println("Antrian berhasil ditambahkan! Nomor Antrian: " + nomorAntrian);
    }
    
    /**
     * Cetak semua antrian dari head ke tail dengan detail pembeli & pesanan
     */
    public void cetakAntrian() {
        if (head == null) {
            System.out.println("Antrian kosong!");
            return;
        }
        
        System.out.println("\n========== DAFTAR ANTRIAN ==========");
        node current = head;
        while (current != null) {
            System.out.println("Nomor Antrian: " + current.getNomorAntrian());
            System.out.println("  Nama Pembeli: " + current.getPembeli().getNamaPembeli());
            System.out.println("  No HP: " + current.getPembeli().getNoHp());
            System.out.println("  Menu: " + current.getPesanan().getNamaPesanan());
            System.out.println("  Harga: " + current.getPesanan().getHarga());
            System.out.println("-----------------------------------");
            current = current.getNext();
        }
    }
    
    /**
     * Hapus antrian berdasarkan nomor dengan menyesuaikan pointer prev/next
     */
    public void hapusAntrian(int nomor) {
        if (head == null) {
            System.out.println("Antrian kosong! Tidak ada yang dihapus.");
            return;
        }
        
        node current = head;
        
        while (current != null) {
            if (current.getNomorAntrian() == nomor) {
                if (current == head && current == tail) {
                    // Satu-satunya node
                    head = null;
                    tail = null;
                } else if (current == head) {
                    // Hapus head
                    head = current.getNext();
                    head.setPrev(null);
                } else if (current == tail) {
                    // Hapus tail
                    tail = current.getPrev();
                    tail.setNext(null);
                } else {
                    // Hapus di tengah
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                
                System.out.println("Antrian nomor " + nomor + " berhasil dihapus!");
                return;
            }
            current = current.getNext();
        }
        
        System.out.println("Antrian nomor " + nomor + " tidak ditemukan!");
    }
    
    /**
     * Update pesanan untuk antrian tertentu
     */
    public void ubahPesanan(int nomor, pesanan pesananBaru) {
        node current = head;
        
        while (current != null) {
            if (current.getNomorAntrian() == nomor) {
                current.setPesanan(pesananBaru);
                System.out.println("Pesanan antrian nomor " + nomor + " berhasil diubah!");
                return;
            }
            current = current.getNext();
        }
        
        System.out.println("Antrian nomor " + nomor + " tidak ditemukan!");
    }
    
    /**
     * Cari node antrian berdasarkan nomor (traversal dari head)
     */
    public node cariAntrian(int nomor) {
        node current = head;
        
        while (current != null) {
            if (current.getNomorAntrian() == nomor) {
                return current;
            }
            current = current.getNext();
        }
        
        return null;
    }
    
    public int getTotalAntrian() {
        return nomorAntrian;
    }
    
    public node getHead() {
        return head;
    }
    
    public node getTail() {
        return tail;
    }
}
