public class Main {
    public static void main(String[] args) {
        Potion potion1 = new Potion("Healing Potion", "A", 50, 5, 20, "Heal");
        Potion potion2 = new Potion("Attack Potion", "B", 75, 3, 15, "Attack");
        Sword sword = new Sword("Excalibur", "S", 300, 50);
        Shield shield = new Shield("Dragon Shield", "A", 200, 40);

        System.out.println(potion1.use("Heal"));  
        System.out.println(potion2.use("Attack"));  
        System.out.println(sword.attack());  
        System.out.println(shield.defense()); 
    }
}
