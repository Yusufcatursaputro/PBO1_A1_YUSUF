import java.util.*;

class Gudang {
    private HashMap<Bahan, Integer> stokBahan = new HashMap<>();
    private HashMap<TipeBarang, Integer> isiGudang = new HashMap<>();
    private final int MAX_KURSI = 20;
    private final int MAX_MEJA = 10;
    private final int MAX_LEMARI = 5;

    public HashMap<Bahan, Integer> cekStokBahan() {
        System.out.println("Stok Bahan:");
        for (Map.Entry<Bahan, Integer> entry : stokBahan.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return stokBahan;
    }

    public HashMap<TipeBarang, Integer> cekIsiGudang() {
        System.out.println("Isi Gudang:");
        for (Map.Entry<TipeBarang, Integer> entry : isiGudang.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return isiGudang;
    }

    public boolean tambahBahan(Bahan bahan, int jumlah) {
        if (stokBahan.containsKey(bahan)) {
            stokBahan.put(bahan, stokBahan.get(bahan) + jumlah);
        } else {
            stokBahan.put(bahan, jumlah);
        }
        return true;
    }

    public boolean kurangiBahan(Bahan bahan, int jumlah) {
        if (!stokBahan.containsKey(bahan) || stokBahan.get(bahan) < jumlah) {
            System.out.println("Bahan " + bahan + " tidak mencukupi");
            return false;
        }
        stokBahan.put(bahan, stokBahan.get(bahan) - jumlah);
        return true;
    }

    public boolean buatBarang(TipeBarang tipeBarang, int jumlah) {
        int kayuNeeded = 0;
        int bautNeeded = 0;
        int catNeeded = 0;

        switch (tipeBarang) {
            case KURSI:
                kayuNeeded = 2 * jumlah;
                bautNeeded = 10 * jumlah;
                catNeeded = 1 * jumlah;
                if (kurangiBahan(Bahan.KAYU, kayuNeeded) && kurangiBahan(Bahan.BAUT, bautNeeded)
                        && kurangiBahan(Bahan.CAT, catNeeded)) {
                    if (isiGudang.containsKey(tipeBarang)) {
                        isiGudang.put(tipeBarang, isiGudang.get(tipeBarang) + jumlah);
                    } else {
                        isiGudang.put(tipeBarang, jumlah);
                    }
                } else {
                    return false;
                }
                break;
            case MEJA:
                kayuNeeded = 3 * jumlah;
                bautNeeded = 20 * jumlah;
                catNeeded = 2 * jumlah;
                if (kurangiBahan(Bahan.KAYU, kayuNeeded) && kurangiBahan(Bahan.BAUT, bautNeeded)
                        && kurangiBahan(Bahan.CAT, catNeeded)) {
                    if (isiGudang.containsKey(tipeBarang)) {
                        isiGudang.put(tipeBarang, isiGudang.get(tipeBarang) + jumlah);
                    } else {
                        isiGudang.put(tipeBarang, jumlah);
                    }
                } else {
                    return false;
                }
                break;
            case LEMARI:
                kayuNeeded = 5 * jumlah;
                bautNeeded = 30 * jumlah;
                catNeeded = 3 * jumlah;
                if (kurangiBahan(Bahan.KAYU, kayuNeeded) && kurangiBahan(Bahan.BAUT, bautNeeded)
                        && kurangiBahan(Bahan.CAT, catNeeded)) {
                    if (isiGudang.containsKey(tipeBarang)) {
                        isiGudang.put(tipeBarang, isiGudang.get(tipeBarang) + jumlah);
                    } else {
                        isiGudang.put(tipeBarang, jumlah);
                    }
                } else {
                    return false;
                }
                break;
        }
        return true;
    }

    public boolean slotTersedia(TipeBarang tipeBarang, int jumlah) {
        switch (tipeBarang) {
            case KURSI:
                return isiGudang.getOrDefault(tipeBarang, 0) + jumlah <= MAX_KURSI;
            case MEJA:
                return isiGudang.getOrDefault(tipeBarang, 0) + jumlah <= MAX_MEJA;
            case LEMARI:
                return isiGudang.getOrDefault(tipeBarang, 0) + jumlah <= MAX_LEMARI;
        }
        return false;
    }

    public boolean masukanBarangKeGudang(TipeBarang tipeBarang, int jumlah) {
        if (slotTersedia(tipeBarang, jumlah)) {
            if (isiGudang.containsKey(tipeBarang)) {
                isiGudang.put(tipeBarang, isiGudang.get(tipeBarang) + jumlah);
            } else {
                isiGudang.put(tipeBarang, jumlah);
            }
            return true;
        }
        return false;
    }

    public boolean keluarkanBarangDariGudang(TipeBarang tipeBarang, int jumlah) {
        if (isiGudang.containsKey(tipeBarang) && isiGudang.get(tipeBarang) >= jumlah) {
            isiGudang.put(tipeBarang, isiGudang.get(tipeBarang) - jumlah);
            return true;
        }
        return false;
    }

    public boolean bahanPembuatanMencukupi(TipeBarang tipeBarang, int jumlah) {
        int kayuNeeded = 0;
        int bautNeeded = 0;
        int catNeeded = 0;

        switch (tipeBarang) {
            case KURSI:
                kayuNeeded = 2 * jumlah;
                bautNeeded = 10 * jumlah;
                catNeeded = 1 * jumlah;
                break;
            case MEJA:
                kayuNeeded = 3 * jumlah;
                bautNeeded = 20 * jumlah;
                catNeeded = 2 * jumlah;
                break;
            case LEMARI:
                kayuNeeded = 5 * jumlah;
                bautNeeded = 30 * jumlah;
                catNeeded = 3 * jumlah;
                break;
        }

        return isiGudang.getOrDefault(Bahan.KAYU, 0) >= kayuNeeded && isiGudang.getOrDefault(Bahan.BAUT, 0) >= bautNeeded
                && isiGudang.getOrDefault(Bahan.CAT, 0) >= catNeeded;
    }
}