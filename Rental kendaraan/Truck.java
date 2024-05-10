class Truck extends Vehicle {
    private int cargoCapacity;

    public Truck(String brand, int year, double rentalPrice, int cargoCapacity) {
        super(brand, year, rentalPrice);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateDiscount() {
        double discount = super.calculateDiscount();

        if (cargoCapacity > 2000) {
            discount += 0.1 * rentalPrice;
        }

        return discount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Detail Truk :");        
        super.displayInfo();
        System.out.println("Kapasitas Kargo : " + cargoCapacity);
        double discount = calculateDiscount();
        System.out.println("Total Diskon : " + discount);
        System.out.println("Harga sewa setelah diskon : " + (rentalPrice - discount));
        System.out.println("----------------------------------");
    }
}