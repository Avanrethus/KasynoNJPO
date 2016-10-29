package BlackJack;
import java.util.ArrayList;
import java.util.Random;

public class Talia {
    private ArrayList<Karta> karty; 
    
    public Talia(){
        this.karty = new ArrayList<Karta>();
    }
    
    public void utworzNowaTalie(){
        for(Figura figuraKarty : Figura.values()){
            for(Wartosc wartoscKarty : Wartosc.values()){
                this.karty.add(new Karta(wartoscKarty,figuraKarty));
            }
        }
    }
    public void przetasuj(){
        ArrayList<Karta> tymTalia = new ArrayList<Karta>();
        Random r = new Random();
        int indeksKarty = 0;
        int oryginalnaTalia = this.karty.size();
        for (int i = 0; i<oryginalnaTalia; i++){
            indeksKarty = r.nextInt((this.karty.size()-1-0)+1)+0;
            tymTalia.add(this.karty.get(indeksKarty));
            this.karty.remove(indeksKarty);
        }
        this.karty = tymTalia;
    }
    public void usunKarte(int i){
        this.karty.remove(i);
    }
    public Karta getKarta (int i){
        return this.karty.get(i);
    }
    public void dodajKarte(Karta dodajKarte){
        this.karty.add(dodajKarte);
    }
    public void ciagnijKarte(Talia z){
        this.karty.add(z.getKarta(0));
        z.usunKarte(0);
    }
    public String toString(){
        String listaKart="";
        int i = 0;
        for (Karta aKarta : this.karty){
            listaKart = listaKart +"\n"+ aKarta.toString();
            i++;
        }
        return listaKart;
    }
    
    public void przeniesWszystkieDoTalii(Talia przenies){
        int rozmiarTalii = this.karty.size();
        for (int i = 0; i<rozmiarTalii; i++){
            przenies.dodajKarte(this.getKarta(i));
        }
        for (int i = 0; i<rozmiarTalii; i++){
            this.usunKarte(0);
        }
    }
    public int rozmiarTalii(){
        return this.karty.size();
    }
    public int wartoscKart(){
        int ogolnaWartosc = 0;
        
        for (Karta aKarta : this.karty){
            switch(aKarta.getWartosc()){
                case Dwa: ogolnaWartosc = ogolnaWartosc +2;
                break;
                case Trzy: ogolnaWartosc = ogolnaWartosc +3;
                break;
                case Cztery: ogolnaWartosc = ogolnaWartosc +4;
                break;
                case Pięć: ogolnaWartosc = ogolnaWartosc +5;
                break;
                case Sześć: ogolnaWartosc = ogolnaWartosc +6;
                break;
                case Siedem: ogolnaWartosc = ogolnaWartosc +7;
                break;
                case Osiem: ogolnaWartosc = ogolnaWartosc +8;
                break;
                case Dziewięć: ogolnaWartosc = ogolnaWartosc +9;
                break;
                case Dziesięć: ogolnaWartosc = ogolnaWartosc +10;
                break;
                case Walet: ogolnaWartosc = ogolnaWartosc +10;
                break;
                case Królowa: ogolnaWartosc = ogolnaWartosc +10;
                break;
                case Król: ogolnaWartosc = ogolnaWartosc +10;
                break;
                case As: ogolnaWartosc = ogolnaWartosc +1;
                break;
            }
                       
        }
        return ogolnaWartosc;
    }
}

