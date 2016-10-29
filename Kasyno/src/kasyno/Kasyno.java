package kasyno;
import BlackJack.BlackJack;
import JednorekiBandyta.JednorekiBandyta;
import java.util.Scanner;

public class Kasyno {

    public static void main(String[] args) {
        int opt;
        Bank b = Bank.inst();
        Scanner s = new Scanner(System.in);
        String pow = "Witamy w kasynie! Proszę wybrać jedną z następujących opcji:\n";
        String jb = "1# Jednoręki Bandyta!\n";
        String bj = "2# Blackjack!\n";
        String cb = "3# Sprawdź stan banku.\n";
        String exit = "4# Wyjście.\n";
      
        do{
            System.out.println(pow + jb + bj + cb + exit);
            opt = s.nextInt();
            if(opt == 1){
                JednorekiBandyta g1 = new JednorekiBandyta();
                g1.JednorekiBandytaGra();
            }
            if(opt == 2){
                BlackJack g2 = new BlackJack();
                g2.BlackJackGra();
            }
            if(opt == 3){
                System.out.println("Stan konta: $"+ b.BankStatus());
            }
            
        }
        while(opt != 4);
 
    }
    
}
