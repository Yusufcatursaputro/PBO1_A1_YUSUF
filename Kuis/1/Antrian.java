public class Antrian {
    public enum tipePasiens {
        BPJS, MANDIRI
    }

    private String nomorAntrian;
    private String namaPendaftar;
    private String keluhan;
    private Dokter dokter;
    private tipePasiens tipePasien;

    public Antrian(String nomorAntrian, String namaPendaftar, String keluhan, Dokter dokter, tipePasiens tipePasien) {
        this.nomorAntrian = nomorAntrian;
        this.namaPendaftar = namaPendaftar;
        this.keluhan = keluhan;
        this.dokter = dokter;
        this.tipePasien = tipePasien;
    }

    public String getNomorAntrian() {
        return nomorAntrian;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public String getNamaPendaftar() {
        return namaPendaftar;
    }

    public String getKeluhan() {
        return keluhan;
    }
    public tipePasiens getTipePasien() {
        return tipePasien;
    }

}
