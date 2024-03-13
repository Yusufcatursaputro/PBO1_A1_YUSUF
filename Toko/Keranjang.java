import java.util.ArrayList;

class Keranjang {
    ArrayList<Barang> daftarBarang;

    public Keranjang() {
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        int totalBarang = 0;
        for (Barang b : daftarBarang) {
            totalBarang += b.jumlah;
        }
        if (totalBarang + barang.jumlah <= 5) {
            daftarBarang.add(barang);
            System.out.println("Berhasil memasukkan ke keranjang");
        } else {
            System.out.println("Wes too, Keranjange wes mbludhag!!");
        }
    }

    public void printHasil() {
        System.out.println("Jumlah Barang Di Keranjang Saat Ini : " + getTotalItems());
        System.out.println("Barang Pada Keranjang:");
        for (Barang barang : daftarBarang) {
            System.out.println("# " + barang.nama + ", jumlah : " + barang.jumlah);
        }
        System.out.println("Total Harga Yang Harus di Bayar : " + calculateTotal());
    }

    private int getTotalItems() {
        int totalItems = 0;
        for (Barang barang : daftarBarang) {
            totalItems += barang.jumlah;
        }
        return totalItems;
    }

    public double calculateTotal() {
        double total = 0;
        for (Barang barang : daftarBarang) {
            total += barang.harga * barang.jumlah;
        }
        return total;
    }
}