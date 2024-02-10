package adventuregame;

import java.util.Scanner;

public class Game {

    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void login() {
        Scanner ınput = new Scanner(System.in);
        System.out.println("Macera oyununa hoşgeldiniz");
        System.out.print("Oyuna başlamadan önce isminizi giriniz: ");
        String playerName = ınput.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("======================================  HARİTA  ======================================");
            System.out.println("Gitmek istediğiniz yeri seçiniz");
            System.out.println("1.Güvenli Ev --> Canavarlardan arındırılmış bölge, kahramanın dinlenme yeri.");
            System.out.println("2.Mağara --> Karşınıza zombi çıkabilir.");
            System.out.println("3.Orman  --> Karşınıza vampir çıkabilir.");
            System.out.println("4.Nehir --> Karşınıza ayı çıkabilir.");
            System.out.println("5.Mağaza --> Kahraman kendine silah ve zırh seçebilir.");
            System.out.print("Seçmek istediğiniz konumu belirtin : ");
            int selLoc = input.nextInt();

            while (selLoc < 0 || selLoc > 5) {
                System.out.println("Lütfen geçerli bir konum beilrtiniz.");
                System.out.print("Seçmek istediğiniz konumu belirtin : ");
                selLoc = input.nextInt();

            }
            switch (selLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if(location.getClass().getName().equals("SafeHouse")){
                System.out.println("Tebrikler oyunu kazandınız.");
                break;
            }
            
            
            if(!location.getLocation()){
                System.out.println("Oyun bitti.");
                break;
            }
        }
    }

}
