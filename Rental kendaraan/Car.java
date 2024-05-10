enum CarType {
    CITY_CAR,
    FAMILY_CAR,
    PREMIUM_CAR
}

class Car extends Vehicle {
    private CarType type;

    public Car(String brand, int year, double rentalPrice, CarType type) {
        super(brand, year, rentalPrice);
        this.type = type;
    }

    @Override
    public double calculateDiscount() {
        double discount = super.calculateDiscount();

        switch (type) {
            case FAMILY_CAR:
                discount += 0.05 * rentalPrice;
                break;
            case PREMIUM_CAR:
                discount += 0.1 * rentalPrice;
                break;
            default:
                break;
        }

        return discount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Detail Mobil :");
        super.displayInfo();
        System.out.println("Tipe Mobil : " + type);
        double discount = calculateDiscount();
        System.out.println("Total Diskon : " + discount);
        System.out.println("Harga sewa setelah diskon : " + (rentalPrice - discount));
        System.out.println("----------------------------------");
    }
}