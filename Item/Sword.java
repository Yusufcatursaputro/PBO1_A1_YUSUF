class Sword extends Item {
    private int damage;

    public Sword(String name, String rank, int price, int damage) {
        super(name, rank, price);
        this.damage = damage;
    }

    public String attack() {
        return "Damage dealt by " + damage;
    }

    public int getDamage() {
        return damage;
    }
}