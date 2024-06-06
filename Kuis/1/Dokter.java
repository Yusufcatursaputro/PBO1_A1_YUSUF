import java.util.ArrayList;
import java.util.List;

public class Dokter extends Orang {
    private String idDokter;
    private String nomorSTR;
    private String spesialisasi;
    private List<Antrian> listAntrianPasien;

    public Dokter(String nama, String tanggalLahir, JENIS_KELAMIN gender, String nomorSTR, String spesialisasi) {
        super(nama, tanggalLahir, gender);
        this.nomorSTR = nomorSTR;
        this.spesialisasi = spesialisasi;
        this.listAntrianPasien = new ArrayList<>();
    }

    public String getIdDokter() {
        return idDokter;
    }

    public String getNomorSTR() {
        return nomorSTR;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void daftar(RumahSakit rumahSakit) {
        if (rumahSakit.tambahDokter(this)) {
            this.idDokter = "D_" + spesialisasi + "_" + rumahSakit.getJumlahDokter();
        }
    }

    public void tambahAntrian(Antrian antrian) {
        listAntrianPasien.add(antrian);
    }

    public List<Antrian> getListAntrianPasien() {
        return listAntrianPasien;
    }
}
