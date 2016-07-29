package Thread17;

public class Test2 {
	public static void main(String[] args) {
		PrintA printA = new PrintA();
		Thread threadA = new Thread(printA);
		threadA.start();
	}
	
}

class PrintA implements Runnable {
	private static int i = 0;
	public void run(){
		while(!Thread.currentThread().isInterrupted()){
			System.out.println("PrintA");
			if(i == 2){
				Thread.currentThread().interrupt();
			}
//			System.out.println(Thread.currentThread().isInterrupted());
			i++;
		}
	}
}