package AlQassam;

import java.util.Scanner;

class Soilder {
    String name;
    int age;
    String contry;
    long id;
}

class Rocket {
    String name;
    long rang;
}

public class AlQassam {
    static Soilder[] soilders = null;
    static Rocket[] rockets = null;
    static Scanner in = new Scanner(System.in);
    static String passowred = "AllahAkbar";

    public static void main(String[] args) {
        do {
            menu();
            int choose = in.nextInt();
            in.nextLine();

            if (checkPassowred()) {
                switch (choose) {
                    case 0: {
                        System.out.println("Al JEHAD ...");
                        System.exit(0);
                    }
                    case 1: {
                        do {
                            Soilder temp = new Soilder();
                            System.out.println("Enter soilder info > ");
                            System.out.print("Name: ");
                            temp.name = in.nextLine();
                            if (search(temp.name) != -1) {
                                System.out.println("this soilder is already in");
                                break;
                            }
                            System.out.print("Age: ");
                            temp.age = in.nextInt();
                            in.nextLine();
                            System.out.print("Contry: ");
                            temp.contry = in.nextLine();
                            do {
                                temp.id = (long) (Math.random() * 100000000000L);
                            } while (search(temp.id) != -1);
                            resize(soilders);
                            soilders[soilders.length - 1] = temp;
                            System.out.println("the soilder has added ");
                        } while (false);
                    }
                    break;
                    case 2: {
                        System.out.println("All soilders (Mojahdeen)");
                        printSoilders();
                    }
                    break;
                    case 3: {
                        Rocket temp = new Rocket();
                        System.out.println("Enter Rocket info > ");
                        System.out.print("Name: ");
                        temp.name = in.nextLine();
                        System.out.print("Rang: ");
                        temp.rang = in.nextInt();
                        System.out.println("please wait ..");
                        try {
                            Thread.sleep(2500);
                        } catch (Exception ex) {}
                        resize(rockets);
                        rockets[rockets.length - 1] = temp;
                        System.out.println("Rocket created ");
                    }break;
                    case 4:{
                        System.out.println("Al Qasam Rockets >> ");
                        printRockets();
                    }break;
                    default: {
                        System.out.println("Invalid choose .");
                    }
                }
            } else {
                System.out.println("Cannot reach this section .");
            }

            System.out.print("\n\n\nEnter any thing to back: ");
            in.nextLine();
        } while (true);
    }
    
    public static void resize(Rocket[] r){
        if(r == null){
            rockets = new Rocket[1];
            return;
        }
        Rocket temp[] = new Rocket[r.length + 1];
        for (int i = 0; i < r.length; i++) {
            temp[i] = r[i];
        }
        rockets = temp;
    }
    
    public static void resize(Soilder[] s){
        if(s == null){
            soilders = new Soilder[1];
            return;
        }
        Soilder temp[] = new Soilder[s.length + 1];
        for (int i = 0; i < s.length; i++) {
            temp[i] = s[i];
        }
        soilders = temp;
    }
    
    public static int search(long id){
        if(soilders == null)
            return -1;
        for (int i = 0; i < soilders.length; i++) {
            if(id == soilders[i].id)
                return i;
        }
        return -1;
    }
    
    public static int search(String name){
        if(soilders == null)
            return -1;
        for (int i = 0; i < soilders.length; i++) {
            if(name.equals(soilders[i].name))
                return i;
        }
        return -1;
    }
    
    public static void printSoilders(){
        int i = 1;
        for(Soilder s : soilders){
            System.out.printf("%s - %s [%s] : (%s)\n",(i++),s.name,s.age,s.id);
        }
    }
    
    public static void printRockets(){
        int i = 1;
        for(Rocket r : rockets){
            System.out.printf("%s - %s (%saKM)\n",(i++),r.name,r.rang);
        }
    }

    public static boolean checkPassowred() {
        int trys = 0;
        System.out.print("Enter passowred: ");
        String pass = in.nextLine(); 
        while ( !(pass.equals(passowred) && trys++ <= 3)) {
            System.out.print("Wrong passowred, try again: ");
            pass = in.nextLine();
        }
        return (trys <= 3);
    }
    
    public static void menu() {
        System.out.println("Al Qasam - soilders");
        System.out.println("Select option");
        System.out.println("1. add new soilder");
        System.out.println("2. get all soilders");
        System.out.println("3. make rocket");
        System.out.println("4. get all rockets");
        System.out.println("------------------");
        System.out.println("0. exit");
        System.out.print("Enter your choose: ");
    }

}
