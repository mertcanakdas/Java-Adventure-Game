
package adventuregame;


public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
        
    }

    @Override
    public boolean getLocation() {
        player.setHealty(player.getrHealty());
        System.out.println();
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Kahramanınız dinlendi, yolculuğa çıkabilir.");
        return true;
    }
    
}
