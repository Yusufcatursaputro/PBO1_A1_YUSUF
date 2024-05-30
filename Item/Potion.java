class Potion extends Item {
    private int duration;
    private int effectPoint;
    private String tipe;

    public Potion(String name, String rank, int price, int duration, int effectPoint, String tipe) {
        super(name, rank, price);
        this.duration = duration;
        this.effectPoint = effectPoint;
        this.tipe = tipe;
    }

    public String use(String inputType) {
        if (tipe.equals("Attack")) {
            return "Damage dealt by " + effectPoint;
        } else if (tipe.equals("Heal")) {
            return "Healed by " + effectPoint;
        } else {
            return "Invalid potion type";
        }
    }

    public int getDuration() {
        return duration;
    }

    public int getEffectPoint() {
        return effectPoint;
    }

    public String getTipe() {
        return tipe;
    }
}