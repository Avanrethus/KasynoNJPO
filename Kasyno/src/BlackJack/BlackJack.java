package BlackJack;
import java.util.Scanner;
import kasyno.Bank;

public class BlackJack {
    public void BlackJackGra(){
        System.out.println("Witamy w grze Blackjack!");
        Scanner s = new Scanner (System.in);
        Bank b = Bank.inst();
        String opt;
        do{
            System.out.println("Czy chcesz zagrać: (Y/N)");
            opt = s.nextLine();
            
            if(opt.equalsIgnoreCase("Y")){
                Talia grajaca = new Talia();
                grajaca.utworzNowaTalie();
                grajaca.przetasuj();
                
                Talia kartyGracza = new Talia();
                Talia kartyKrupiera = new Talia();
               
                
                    System.out.println("Stan konta: $"+ b.BankStatus()+". Ile chcesz postawić?\n ");
                    int stawka = s.nextInt();
                    boolean koniecRundy = false;
                    if(stawka>b.BankStatus()){
                        System.out.println("Nie masz tyle kasy!");
                        break;
                    }
                    kartyGracza.ciagnijKarte(grajaca);
                    kartyGracza.ciagnijKarte(grajaca);
                    
                    kartyKrupiera.ciagnijKarte(grajaca);
                    kartyKrupiera.ciagnijKarte(grajaca);
                    
                    while(true){
                        System.out.println("Twoje karty:" + kartyGracza.toString());
                        System.out.println("Wartość twoich kart:" + kartyGracza.wartoscKart());
                        System.out.println("Karty krupiera: " + kartyKrupiera.getKarta(0).toString()+ " i [ukryte]");
                        System.out.println("Co chcesz zrobić: 1 - Dobierasz lub 2- Pasujesz?");
                        int odp = s.nextInt();
                        if(odp == 1){
                            kartyGracza.ciagnijKarte(grajaca);
                            System.out.println("Twoja karta: " + kartyGracza.getKarta(kartyGracza.rozmiarTalii()-1).toString());
                            if(kartyGracza.wartoscKart() >21){
                                System.out.println("Za dużo! Wartość Twoich kart: "+ kartyGracza.wartoscKart());
                                b.BankStatusMinus(stawka);
                                koniecRundy = true;
                                break;
                            }
                        }
                        if(odp == 2){
                            break;
                        }
                    }
                   System.out.println("Karty krupiera: " + kartyKrupiera.toString());
                   if(kartyKrupiera.wartoscKart()>kartyGracza.wartoscKart()&& koniecRundy == false){
                       System.out.println("Krupier wygrywa!");
                       b.BankStatusMinus(stawka);
                       koniecRundy = true;
                    }
                   while ((kartyKrupiera.wartoscKart()<17) && koniecRundy == false){
                       kartyKrupiera.ciagnijKarte(grajaca);
                       System.out.println("Krupier ciągnie: "+ kartyKrupiera.getKarta(kartyKrupiera.rozmiarTalii()-1).toString());
                    }
                   System.out.println("Wartość kart krupiera: "+ kartyKrupiera.wartoscKart());
                   if((kartyKrupiera.wartoscKart()>21)&& koniecRundy == false){
                       System.out.println("Krupier przegrywa. Za dużo w kartach: "+ kartyKrupiera.wartoscKart());
                       b.BankStatusMinus(stawka);
                       koniecRundy = true;
                   }
                   if((kartyKrupiera.wartoscKart()==kartyGracza.wartoscKart())&& koniecRundy== false){
                       System.out.println("Remis");
                       koniecRundy = true;
                   }
                   if((kartyGracza.wartoscKart()>kartyKrupiera.wartoscKart())&& koniecRundy == false){
                       System.out.println("Wygrałeś!");
                       b.BankStatusPlus(stawka);
                    }
                   else if(koniecRundy==false){
                       System.out.println("Krupier wygrał!");
                       b.BankStatusMinus(stawka);
                   }
                   kartyGracza.przeniesWszystkieDoTalii(grajaca);
                   kartyKrupiera.przeniesWszystkieDoTalii(grajaca);
                   System.out.println("Koniec gry.");
                
            }
            
        }
        while(opt.toLowerCase().compareTo("n")!= 0);
        
    }
}
