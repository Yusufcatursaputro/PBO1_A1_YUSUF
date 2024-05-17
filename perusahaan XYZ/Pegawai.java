class Pegawai {
    protected String nama;
    protected String departemen;
    protected char jenisKelamin;
    protected int gaji;
    protected int cuti;
    protected String nip;

    public Pegawai(String nama, String departemen, char jenisKelamin) {
        this.nama = nama;
        this.departemen = departemen;
        this.jenisKelamin = jenisKelamin;
        this.cuti = 12;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public void setCuti(int tambahanCuti) {
        this.cuti += tambahanCuti;
    }

    public void setCuti(String tipeCuti) {
        if (tipeCuti.equalsIgnoreCase("pernikahan")) {
            this.cuti += 2;
        } else if (tipeCuti.equalsIgnoreCase("persalinan")) {
            if (this.jenisKelamin == 'P') {
                this.cuti += 90;
            } else if (this.jenisKelamin == 'L') {
                this.cuti += 3;
            }
        }
    }

    public void setNip(String nip) {
        if (nip.charAt(0) == 'P') {
            this.nip = nip;
        }
    }

    public void setNip(int urutanMasuk) {
        this.nip = "P" + String.format("%04d", urutanMasuk);
    }

    public int getThr() {
        return this.gaji;
    }

    public void displayInfo() {
        System.out.println("Jabatan : Pegawai");
        System.out.println("Nama : " + this.nama);
        System.out.println("Departemen : " + this.departemen);
        System.out.println("NIP : " + this.nip);
        System.out.println("Gaji : " + this.gaji);
        System.out.println("Gaji : " + getThr());
        System.out.println("Cuti : " + this.cuti);
        System.out.println("===============================");
    }
}
