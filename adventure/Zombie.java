enum ZombieType {
    MELEE,
    RANGED
}

class Zombie extends Entity {
    ZombieType type;

    Zombie(int level, int hp, ZombieType type) {
        super(level, hp);
        this.type = type;
    }

    void entityInfo() {
        System.out.println("# ZOMBIE DENGAN TIPE : " + type + ", DAN LEVEL : " + level);
    }

    void attack(Player player) {
        if (hp > 0) {
            if (type == ZombieType.MELEE) {
                player.hp -= 20;
                System.out.println("Player : UGHH");
            } else {
                player.hp -= 15;
                System.out.println("Player : UGHH");
            }
            if (player.hp <= 0) {
                System.out.println("# YOU DIE, GAME OVER");
            }
        } else {
            System.out.println("# ZOMBIE SUDAH MATI");
        }
    }
}