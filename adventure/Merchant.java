import java.util.ArrayList;

class Merchant extends Entity {
    ArrayList<String> listItem;

    Merchant(int level, int hp, ArrayList<String> listItem) {
        super(level, hp);
        this.listItem = listItem;
    }

    void entityInfo() {
        System.out.println("# MERCHANT DENGAN LEVEL : " + level);
    }
}