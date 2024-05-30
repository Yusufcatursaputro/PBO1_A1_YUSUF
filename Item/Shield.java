class Shield extends Item {
    private int damageBlock;

    public Shield(String name, String rank, int price, int damageBlock) {
        super(name, rank, price);
        this.damageBlock = damageBlock;
    }

    public String defense() {
        return "Damage Mitigated by " + damageBlock;
    }

    public int getDamageBlock() {
        return damageBlock;
    }
}