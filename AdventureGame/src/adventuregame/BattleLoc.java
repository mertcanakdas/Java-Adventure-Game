package adventuregame;

import java.util.Random;

public  class BattleLoc extends Location {

    protected Obstacle obstacle;
    protected boolean bCase = false;
    protected String award;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        preCombat();

        return bCase;
    }

    public void preCombat() {
        int obsCount = obstacle.count();
        System.out.println("Bulunduğunuz konum : " + this.getName());
        System.out.println("Dikkatli ol KAHRAMAN !!! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor");
        System.out.print("<S>avaş veya <K>aç : ");
        String selCase = input.nextLine();
        selCase = selCase.toUpperCase();
        if (selCase.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz.");
                if (this.award.equals("Yemek") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " elde ettiniz. Eşya çantanıza eklendi.");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Su") && player.getInv().isWater() == false) {
                    System.out.println(this.award + " elde ettiniz. Eşya çantanıza eklendi.");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Odun") && player.getInv().isFirewood() == false) {
                    System.out.println(this.award + " elde ettiniz. Eşya çantanıza eklendi.");
                    player.getInv().setFirewood(true);
                }
                this.bCase = true;
            } if(player.getHealty() <= 0) {
                System.out.println("Kahramanınız katledildi.");
                this.bCase = false;
            }

        }
        this.bCase = true;
    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int defObsHealty = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealty() > 0 && obstacle.getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç : ");
                String selCase = input.nextLine();
                selCase = selCase.toUpperCase();
                if (selCase.equals("V")) {
                    System.out.println(obstacle.getName() + "'(y)e hasar verdiniz.");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0) {
                        System.out.println(obstacle.getName() + " size hasar verdi");
                        if (player.getInv().getArmor() > obstacle.getDamage()) {
                            player.setHealty(player.getHealty());
                            afterHit();
                        } else {
                            player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInv().getArmor()));
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
                if (obstacle.getHealth() <= 0 && player.getHealty() > 0) {
                    System.out.println("1 " + obstacle.getName() + "(y)i katletdiniz.");
                    player.setMoney(player.getMoney() + obstacle.getAward());
                    System.out.println("Bakiye : " + player.getMoney());
                    obstacle.setHealth(defObsHealty);
                } else {
                    break;
                }
                System.out.println("=============================================");
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("=============================================  Kahramanın durumu  =============================================");
        System.out.println("Sağlık : " + player.getHealty());
        System.out.println("Hasar : " + player.getTotalDamage());
        System.out.println("Bakiye : " + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Silah : " + player.getInv().getwName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Zırh : " + player.getInv().getaName());
        }
    }

    public void enemyStats() {
        System.out.println("=============================================  " + obstacle.getName() + "'nin durumu  =============================================");
        System.out.println("Hasar : " + obstacle.getDamage());
        System.out.println("Sağlık : " + obstacle.getHealth());
        System.out.println("Ödül : " + obstacle.getAward());

    }

    public void afterHit() {
        System.out.println("Kahramanın canı : " + player.getHealty());
        System.out.println(obstacle.getName() + "'(n)in canı : " + obstacle.getHealth());
        System.out.println("----------------------------------------------------------------");
    }

}
