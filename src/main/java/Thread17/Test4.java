package Thread17;

/**
 * 当sleep在interrupt之后使用，sleep会去掉interrupt这个标记，造成中断异常
 */
public class Test4 {
	public static void main(String[] args) {  
        PrintC printC = new PrintC();  
        Thread threadC = new Thread(printC);  
        threadC.start();  
    } 
}

class PrintC implements Runnable {  
    private static int i = 0;  
  
    public void run() {  
        while (!Thread.currentThread().isInterrupted()) {  
            System.out.println("PrintC");
            if (i !=  -2) {  
//            	System.out.println(Thread.currentThread());
                Thread.currentThread().interrupt();  
                try {  
                    Thread.currentThread().sleep(10);  
                    System.out.println("a");
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
            i++;  
        }  
    }  
}