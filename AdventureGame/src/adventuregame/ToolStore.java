package adventuregame;

public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean getLocation() {
        store();
        return true;
    }

    public void store() {
        System.out.println("======================================  MAĞAZA  ======================================");
        System.out.println("Mağazaya hoşgeldiniz, istediğiniz kategoriyi seçiniz.");
        System.out.println("Bakiyeniz : " + player.getMoney());
        System.out.println("1.Silahlar");
        System.out.println("2.Zırhlar");
        System.out.println("3.Çıkış");
        System.out.print("Seçilen kategori : ");
        int choose = input.nextInt();
        int selItemID;
        switch (choose) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                System.out.println("Çıkış yapılıyor");
                break;
            default:
                break;

        }
    }

    public int weaponMenu() {
        System.out.println("1.Tabanca \t Tutar : 25 \t Hasar : 2");
        System.out.println("2.Kılıç \t Tutar : 35 \t Hasar : 3");
        System.out.println("3.Tüfek \t Tutar : 45 \t Hasar : 7");
        System.out.println("4.Çıkış");
        System.out.print("Seçiminiz : ");
        int selWeaponID = input.nextInt();
        return selWeaponID;

    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                wName = "Tabanca";
                damage = 2;
                price = 25;
                break;
            case 2:
                wName = "Kılıç";
                damage = 3;
                price = 35;
                break;
            case 3:
                wName = "tüfek";
                damage = 7;
                price = 45;
                break;
            default:
                System.out.println("Geçersiz işlem!!!");
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setDamage(damage);
                player.getInv().setwName(wName);
                player.setMoney(player.getMoney() - price);
                System.out.println(wName.toUpperCase() + " aldınız yeni hasarınız " + player.getTotalDamage() + " olarak güncellendi.");
                System.out.println("Kalan bakiye : " + player.getMoney());
            } else {
                System.out.println("Bakiye yetersiz.");

            }
        }
    }

    public int armorMenu() {
        System.out.println("1.Hafif Zırh \t Tutar : 15 \t Savunma : 1");
        System.out.println("2.Orta Zırh \t Tutar : 25 \t Savunma : 3");
        System.out.println("3.Ağır Zırh \t Tutar : 40 \t Savunma : 5");
        System.out.println("4.Çıkış");
        System.out.print("Seçiminiz : ");
        int selArmorID = input.nextInt();
        return selArmorID;

    }

    public void buyArmor(int itemID) {
        int armor = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                aName = "Hafif Zırh";
                armor = 1;
                price = 5;
                break;
            case 2:
                aName = "Orta Zırh";
                armor = 3;
                price = 25;
                break;
            case 3:
                aName = "Ağır Zırh";
                armor = 5;
                price = 40;
                break;
            default:
                System.out.println("Geçersiz işlem!!!");
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
                player.getInv().setArmor(armor);
                player.getInv().setaName(aName);
                player.setMoney(player.getMoney() - price);
                System.out.println(aName.toUpperCase() + " aldınız yeni savunmanız " + player.getTotalArmor() + " olarak güncellendi.");
                System.out.println("Kalan bakiye : " + player.getMoney());
            } else {
                System.out.println("Bakiye yetersiz.");

            }
        }
    }

}
