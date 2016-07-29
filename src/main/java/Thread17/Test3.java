package Thread17;

public class Test3 {
	public static void main(String[] args) {
		PrintB printB = new PrintB();
		Thread threadB = new Thread(printB);
		threadB.start();
	}
}

class PrintB implements Runnable{
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++){
			System.out.println("PrintB");
			Thread.currentThread().interrupt();
//			System.out.println(Thread.currentThread().isInterrupted());
		}
	}
}