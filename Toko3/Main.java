public class Main {
    public static void main(String[] args) {
        Toko mebel1 = new Toko();
        mebel1.getGudangBarang().tambahBahan(Bahan.KAYU, 300);
        mebel1.getGudangBarang().tambahBahan(Bahan.BAUT, 300);
        mebel1.getGudangBarang().tambahBahan(Bahan.CAT, 300);

        mebel1.getGudangBarang().cekStokBahan();

        mebel1.getGudangBarang().buatBarang(TipeBarang.KURSI, 5);
        mebel1.getGudangBarang().buatBarang(TipeBarang.MEJA, 3);
        mebel1.getGudangBarang().buatBarang(TipeBarang.LEMARI, 2);

        mebel1.getGudangBarang().cekIsiGudang();
        mebel1.getGudangBarang().cekStokBahan();

        Pembeli pembeli1 = new Pembeli("Yusuf", TipeBarang.KURSI, 1);
        Pembeli pembeli2 = new Pembeli("Catur", TipeBarang.MEJA, 1);
        Pembeli pembeli3 = new Pembeli("Saputro", TipeBarang.LEMARI, 1);

        mebel1.tambahAntrian(pembeli1);
        mebel1.tambahAntrian(pembeli2);
        mebel1.tambahAntrian(pembeli3);
        mebel1.cekIsiAntrian();

        mebel1.selesaikanAntrian();
        mebel1.cekIsiAntrian();
        mebel1.getGudangBarang().cekIsiGudang();
    }
}
