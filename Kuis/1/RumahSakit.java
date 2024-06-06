import java.util.ArrayList;
import java.util.List;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private List<Dokter> listDokter;
    private List<Antrian> listAntrianPasien;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.listDokter = new ArrayList<>();
        this.listAntrianPasien = new ArrayList<>();
    }

    public boolean tambahDokter(Dokter dokter) {
        for (Dokter d : listDokter) {
            if (d.getNama().equals(dokter.getNama())) {
                System.out.println("DOKTER SUDAH TERDAFTAR");
                return false;
            }
        }
        listDokter.add(dokter);
        System.out.println("SUKSES");
        return true;
    }

    public void tambahAntrianPasien(Pasien pasien, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        for (Antrian antrian : listAntrianPasien) {
            if (antrian.getNamaPendaftar().equals(pasien.getNama()) && antrian.getDokter().getNama().equals(namaDokter)) {
                System.out.println("PASIEN SUDAH TERDAFTAR");
                return;
            }
        }
        for (Dokter d : listDokter) {
            if (d.getNama().equals(namaDokter)) {
                String nomorAntrian = d.getIdDokter() + "_" + (d.getListAntrianPasien().size() + 1);
                Antrian antrian = new Antrian(nomorAntrian, pasien.getNama(), keluhan, d, tipePasien);
                listAntrianPasien.add(antrian);
                d.tambahAntrian(antrian);
                System.out.println("SUKSES");
                return;
            }
        }
        System.out.println("DOKTER TERSEBUT TIDAK TERSEDIA");
    }

    public void selesaikanAntrian(Pasien pasien) {
        if (!listAntrianPasien.isEmpty() && listAntrianPasien.get(0).getNamaPendaftar().equals(pasien.getNama())) {
            Antrian antrian = listAntrianPasien.remove(0);
            antrian.getDokter().getListAntrianPasien().remove(antrian);
            System.out.println("SUKSES");
        } else if (!listAntrianPasien.isEmpty()) {
            System.out.println("BELUM SAATNYA PERIKSA");
        } else {
            System.out.println("BELUM DAFTAR");
        }
    }

    public void cekListDokter() {
        if (listDokter.isEmpty()) {
            System.out.println("BELUM ADA DOKTER YANG TERSEDIA SAAT INI");
            return;
        }
        System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
        System.out.println("=======================================");
        for (int i = 0; i < listDokter.size(); i++) {
            Dokter dokter = listDokter.get(i);
            System.out.println((i + 1) + ". Nama Dokter : " + dokter.getNama() + ", Dokter spesialis : " + dokter.getSpesialisasi());
        }
    }

    public void cekAntrianPasien() {
        System.out.println("ANTRIAN RUMAH SAKIT SAAT INI");
        System.out.println("=======================================");
        for (Dokter dokter : listDokter) {
            System.out.println("DR. " + dokter.getNama());
            if (dokter.getListAntrianPasien().isEmpty()) {
                System.out.println("ANTRIAN KOSONG");
            } else {
                for (Antrian antrian : dokter.getListAntrianPasien()) {
                    System.out.println("IDE ANTRIAN: " + antrian.getNomorAntrian() + ", Atas nama : " + antrian.getNamaPendaftar());
                }
            }
            System.out.println("=================");
        }
    }

    public String getNama() {
        return nama;
    }

    public int getJumlahDokter() {
        return listDokter.size();
    }
    public String getAlamat() {
        return alamat;
    }
    public String getNoTelepon() {
        return noTelepon;
    }
    public List<Dokter> getListDokter() {
        return listDokter;
    }

}
