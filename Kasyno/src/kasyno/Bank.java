package kasyno;

public class Bank {
    private static Bank inst;
    int status = 2000;
    
    public Bank(){
        
    }
    
    public static Bank inst(){
        if(inst == null){
            inst = new Bank();
        }
        return inst;
    }
    
    public int BankStatus(){
        System.out.println(status+"\n");
        return status;
    }
    
    public int bankStatusPlus (int plus){
        status = status + plus;
        return status;
    }
    
    public int BankStatusMinus(int minus){
        status = status-minus;
        return status;
    }
}
