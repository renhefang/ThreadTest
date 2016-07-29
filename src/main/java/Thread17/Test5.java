package Thread17;

public class Test5 {
	public static void main(String[] args) {  
        Bank bank = new Bank(100, 10000);  
        for (int i = 0; i < 3; i++) {  
            TransferThread transferThread = new TransferThread(bank, 10000);  
            Thread thread = new Thread(transferThread);  
            thread.start();  
        }  
    } 
}
