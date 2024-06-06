public abstract class Orang {
    public enum JENIS_KELAMIN {
        LAKI_LAKI, PEREMPUAN
    }

    protected String nama;
    protected String tanggalLahir;
    protected JENIS_KELAMIN gender;

    public Orang(String nama, String tanggalLahir, JENIS_KELAMIN gender) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.gender = gender;
    }

    public String getNama() {
        return nama;
    }
}