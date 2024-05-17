class Salesman extends Pegawai {
    private int target;
    private int penjualan;

    public Salesman(String nama, String departemen, char jenisKelamin) {
        super(nama, departemen, jenisKelamin);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    @Override
    public void setNip(String nip) {
        if (nip.charAt(0) == 'S') {
            this.nip = nip;
        }
    }

    @Override
    public void setNip(int urutanMasuk) {
        this.nip = "S" + String.format("%04d", urutanMasuk);
    }

    @Override
    public int getThr() {
        if (this.penjualan >= this.target) {
            return this.gaji * 2;
        } else {
            return this.gaji;
        }
    }

    @Override
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
