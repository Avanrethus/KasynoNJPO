package kasyno;

public class Bank {
    private static Bank inst;
    int status = 2000;
    
    private Bank(){
        
    }
    
    public static Bank inst(){
        if(inst == null){
            inst = new Bank();
        }
        return inst;
    }
    
    public int BankStatus(){
        return status;
    }
    
    public int BankStatusPlus (int plus){
        status = status + plus;
        return status;
    }
    
    public int BankStatusMinus(int minus){
        status = status-minus;
        return status;
    }
}
