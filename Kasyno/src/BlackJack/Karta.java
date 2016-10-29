package BlackJack;

public class Karta {
    private Figura figura;
    private Wartosc wartosc;
    
    public Karta(Wartosc wartosc, Figura figura){
        this.wartosc = wartosc;
        this.figura = figura;
    }
    
    public String toString(){
        return this.wartosc.toString() + " - " + this.figura.toString();
    }
    
    public Wartosc getWartosc(){
        return this.wartosc;
    }
    
}
