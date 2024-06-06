public class Pasien extends Orang {
    private String pekerjaan;
    private String domisili;

    public Pasien(String nama, String tanggalLahir, JENIS_KELAMIN gender, String pekerjaan, String domisili) {
        super(nama, tanggalLahir, gender);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        rumahSakit.tambahAntrianPasien(this, keluhan, namaDokter, tipePasien);
    }

    public void periksa(RumahSakit rumahSakit) {
        rumahSakit.selesaikanAntrian(this);
    }
    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

}
