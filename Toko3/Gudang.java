import java.util.HashMap;

enum Bahan {
    KAYU, BAUT, CAT
}

enum TipeBarang {
    MEJA, KURSI, LEMARI
}

class Gudang {
    private HashMap<Bahan, Integer> stokBahan = new HashMap<>();
    HashMap<TipeBarang, Integer> stokBarang = new HashMap<>();

    public void cekStokBahan() {
        System.out.println("Stok Bahan di Gudang:");
        for (Bahan bahan : Bahan.values()) {
            System.out.println(bahan + ": " + stokBahan.getOrDefault(bahan, 0));
        }
    }

    public void cekIsiGudang() {
        System.out.println("Stok Barang di Gudang:");
        
        for (TipeBarang barang : TipeBarang.values()) {
            System.out.println(barang + ": " + stokBarang.getOrDefault(barang, 0));
        }
    }

    public void tambahBahan(Bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.getOrDefault(bahan, 0) + jumlah);
    }

    public void kurangiBahan(Bahan bahan, int jumlah) {
        int sisa = stokBahan.getOrDefault(bahan, 0) - jumlah;
        stokBahan.put(bahan, Math.max(sisa, 0));
    }

    public void buatBarang(TipeBarang barang, int jumlah) {
        int kayu = 0, baut = 0, cat = 0;
        switch (barang) {
            case MEJA:
                kayu = 3;
                baut = 20;
                cat = 2;
                break;
            case KURSI:
                kayu = 2;
                baut = 10;
                cat = 1;
                break;
            case LEMARI:
                kayu = 5;
                baut = 30;
                cat = 3;
                break;
        }
        if (bahanPembuatanMencukupi(barang, jumlah)) {
            kurangiBahan(Bahan.KAYU, kayu * jumlah);
            kurangiBahan(Bahan.BAUT, baut * jumlah);
            kurangiBahan(Bahan.CAT, cat * jumlah);
            stokBarang.put(barang, stokBarang.getOrDefault(barang, 0) + jumlah);
            System.out.println("Berhasil membuat " + jumlah + " " + barang);
        } else {
            System.out.println("Gudang tidak memiliki bahan cukup untuk membuat " + jumlah + " " + barang);
        }
        return;
    }

    private boolean bahanPembuatanMencukupi(TipeBarang barang, int jumlah) {
        int kayu = 0, baut = 0, cat = 0;
        switch (barang) {
            case MEJA:
                kayu = 3;
                baut = 20;
                cat = 2;
                break;
            case KURSI:
                kayu = 2;
                baut = 10;
                cat = 1;
                break;
            case LEMARI:
                kayu = 5;
                baut = 30;
                cat = 3;
                break;
        }
        return stokBahan.getOrDefault(Bahan.KAYU, 0) >= kayu * jumlah &&
                stokBahan.getOrDefault(Bahan.BAUT, 0) >= baut * jumlah &&
                stokBahan.getOrDefault(Bahan.CAT, 0) >= cat * jumlah;
    }

    public boolean slotTersedia(TipeBarang barang) {
        int maksSlot = 0;
        switch (barang) {
            case MEJA:
                maksSlot = 10;
                break;
            case KURSI:
                maksSlot = 20;
                break;
            case LEMARI:
                maksSlot = 5;
                break;
        }
        return stokBarang.getOrDefault(barang, 0) < maksSlot;
    }

    public void masukanBarangKeGudang(TipeBarang barang, int jumlah) {
        stokBarang.put(barang, stokBarang.getOrDefault(barang, 0) + jumlah);
    }

    public void keluarkanBarangDariGudang(TipeBarang barang, int jumlah) {
        stokBarang.put(barang, stokBarang.getOrDefault(barang, 0) - jumlah);
    }
}