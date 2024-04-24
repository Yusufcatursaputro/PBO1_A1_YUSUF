import java.util.ArrayList;
import java.util.List;

class Toko {
    private static final int max_antrian = 5;
    private List<Pembeli> antrian = new ArrayList<>();
    private Gudang gudangBarang = new Gudang();

    public void tambahAntrian(Pembeli pembeli) {
        if (antrian.size() < max_antrian) {
            antrian.add(pembeli);
            System.out.println("Pembeli " + pembeli.getNama() + " ditambahkan ke antrian.");
        } else {
            System.out.println("Antrian penuh, pembeli " + pembeli.getNama() + " tidak dapat ditambahkan.");
        }
    }

    public boolean antrianPenuh() {
        return antrian.size() >= max_antrian;
    }

    public void selesaikanAntrian() {
        for (Pembeli pembeli : antrian) {
            if (barangDiBeliTersedia(pembeli)) {
                gudangBarang.keluarkanBarangDariGudang(pembeli.getBarangDiBeli(), pembeli.getJumlahBarang());
            } else {
                System.out.println("Maaf, stok " + pembeli.getBarangDiBeli() + " tidak mencukupi untuk pembeli " + pembeli.getNama());
            }
        }
        antrian.clear();
    }

    public boolean barangDiBeliTersedia(Pembeli pembeli) {
        return gudangBarang.slotTersedia(pembeli.getBarangDiBeli()) &&
                gudangBarang.stokBarang.getOrDefault(pembeli.getBarangDiBeli(), 0) >= pembeli.getJumlahBarang();
    }

    public void cekIsiAntrian() {
        System.out.println("Isi Antrian:");
        if (antrian.isEmpty()) {
            System.out.println("Antrian Kosong");
            return;
        }
        for (Pembeli pembeli : antrian) {
            System.out.println(pembeli.getNama() + ": " + pembeli.getJumlahBarang() + " " + pembeli.getBarangDiBeli());
        }
    }

    public Gudang getGudangBarang() {
        return gudangBarang;
    }
}