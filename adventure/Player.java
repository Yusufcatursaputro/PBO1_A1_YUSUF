class Player extends Entity {
    String name;

    Player(int level, int hp, String name) {
        super(level, hp);
        this.name = name;
    }

    void entityInfo() {
        System.out.println("# PLAYER DENGAN NAMA : " + name + ", DAN LEVEL : " + level);
    }

    void interact(Merchant merchant) {
        if (merchant.hp > 0) {
            if (merchant.listItem.size() > 0) {
                System.out.println("Merchant : Barang yang tersedia hari ini");
                for (String item : merchant.listItem) {
                    System.out.println("# " + item);
                }
            } else {
                System.out.println("# TIDAK ADA BARANG");
            }
            
        } else {
            System.out.println("# TIDAK BISA BELI, MERCHANT NGAMBEK");
        }
    }

    void attack(Merchant merchant) {
        if (merchant.hp > 0) {
            merchant.hp -= 10;
            System.out.println("Merchant : hey heyy, ngapain nyerang");
            if (merchant.hp <= 0) {
                System.out.println("Merchant : Dah lah males jualan");
            }
        }
    }

    void attack(Zombie zombie) {
        if (hp > 0) {
            zombie.hp -= 10;
            System.out.println("Zombie : GRAAA!");
            if (zombie.hp <= 0) {
                System.out.println("# ZOMBIE MATI");
            }
        } else {
            System.out.println("# PLAYER SUDAH MATI");
        }
    }
}