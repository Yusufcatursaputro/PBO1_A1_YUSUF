class Item {
    private String name;
    private String rank;
    private int price;

    public Item(String name, String rank, int price) {
        this.name = name;
        this.rank = rank;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public int getPrice() {
        return price;
    }
}