class Vehicle {
    protected String brand;
    protected int year;
    protected double rentalPrice;

    public Vehicle(String brand, int year, double rentalPrice) {
        this.brand = brand;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public double calculateDiscount() {
        double discount = 0.0;

        if (year < 2010) {
            discount += 0.1 * rentalPrice;
        }

        return discount;
    }

    public void displayInfo() {
        System.out.println("Merk : " + brand);
        System.out.println("Tahun : " + year);
        System.out.println("Harga Sewa : " + rentalPrice);
    }
}