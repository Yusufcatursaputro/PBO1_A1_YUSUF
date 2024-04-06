import java.util.*;

class Toko {
    private List<Pembeli> antrian = new ArrayList<>();
    private Gudang gudangBarang = new Gudang();

    public Gudang getGudangBarang() {
        return gudangBarang;
    }

    public void tambahAntrian(Pembeli pembeli) {
        antrian.add(pembeli);
        System.out.println("Antrian ditambahkan: " + pembeli.getNama() + " - " + pembeli.getBarangDiBeli() + " - "
                + pembeli.getJumlahBarang());
    }

    public void selesaikanAntrian() {
        Iterator<Pembeli> iterator = antrian.iterator();
        while (iterator.hasNext()) {
            Pembeli pembeli = iterator.next();
            if (gudangBarang.buatBarang(pembeli.getBarangDiBeli(), pembeli.getJumlahBarang())) {
                System.out.println("Pembelian berhasil untuk: " + pembeli.getNama());
                gudangBarang.keluarkanBarangDariGudang(pembeli.getBarangDiBeli(), pembeli.getJumlahBarang());
                iterator.remove();
            } else {
                System.out.println("Pembelian gagal untuk: " + pembeli.getNama() + ", stok barang tidak mencukupi");
            }
        }
    }

    public void cekIsiAntrian() {
        if (antrian.isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        System.out.println("Antrian:");
        for (Pembeli pembeli : antrian) {
            System.out.println(pembeli.getNama() + " - " + pembeli.getBarangDiBeli() + " - " + pembeli.getJumlahBarang());
        }
    }
}