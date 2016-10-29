package JednorekiBandyta;
import java.util.Random;
import java.util.Scanner;
import kasyno.Bank;

public class JednorekiBandyta {
    public void JednorekiBandytaGra(){
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        Bank b = new Bank();
        int num;
        int prestat = b.BankStatus();
        System.out.println("Witamy w grze Jednoręki Bandyta!\n");
        System.out.println("Stan Twojego konta: $" +b.BankStatus());
        while (b.BankStatus()>5){
            System.out.println("Zakręcić? Koszt: $2 (Y/N)");
            String opt = s.nextLine();
            
            if(opt.equalsIgnoreCase("Y")){
                b.BankStatusMinus(2);
                int [][] slot = new int[3][3];
                for (int i = 0; i<slot.length; i++){
                    for(int j = 0; i<slot[i].length; j++){
                        num = r.nextInt(7)+1;
                        slot[i][j] = num;
                        System.out.print(slot[i][j]);
                    }
                    System.out.println();
                }
                if(slot[0][0]==slot[0][1] && slot[0][0]==slot[0][2] && slot[0][1]==slot[0][2])
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
                else if(slot[1][0]==slot[1][1] && slot[1][0]==slot[1][2] && slot[1][1]==slot[1][2])
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
                else if(slot[2][0]==slot[2][1] && slot[2][0]==slot[2][2] && slot[2][1]==slot[2][2])
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
                else if(slot[0][0]==slot[1][0] && slot[0][0]==slot[2][0] && slot[1][0]==slot[2][0])
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
                else if(slot[0][1]==slot[1][1] && slot[0][1]==slot[2][1] && slot[1][1]==slot[2][1]) 
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
                else if(slot[0][2]==slot[1][2] && slot[0][2]==slot[2][2] && slot[1][2]==slot[2][2])
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
                else if(slot[0][0]==slot[1][1] && slot[0][0]==slot[2][2] && slot[1][1]==slot[2][2])
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
                else if(slot[0][2]==slot[1][1] && slot[0][2]==slot[2][0] && slot[1][1]==slot[2][0])
                {
                    b.BankStatusPlus(15);
                    System.out.println("Wygrałeś $15!\nStan banku: "+b.BankStatus());
                }
            }
            
        }
    }
            
}
