package Thread17;

import java.util.Random;

public class TransferThread implements Runnable {  
	  
    private Bank bank;  
  
    private final double MAX;  
  
    public TransferThread(Bank bank, double max) {  
        this.bank = bank;  
        this.MAX = max;  
    }  
  
    public void run() {  
        while (true) {  
            double amount = MAX * Math.random();  
            int countOfAccount = bank.getAccounts().length;  
            bank.transfer(new Random().nextInt(countOfAccount),  
                    new Random().nextInt(countOfAccount), amount);  
        }  
    }  
  
}  