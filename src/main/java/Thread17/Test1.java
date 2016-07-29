package Thread17;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * WriteTxtA和WriteTxtA共用fileWriter这个资源
 */
public class Test1 {
	public static void main(String[] args) throws IOException, InterruptedException{
		CountDownLatch countDownLatch = new CountDownLatch(2);
		FileWriter fileWriter = new FileWriter("d://123.txt");
		WriteTxtA writeTxtA = new WriteTxtA(fileWriter, countDownLatch);
		WriteTxtB writeTxtB = new WriteTxtB(fileWriter, countDownLatch);
		Thread threadA = new Thread(writeTxtA);
		Thread threadB = new Thread(writeTxtB);
		threadA.start();
		threadB.start();
		countDownLatch.await();
		fileWriter.close();
	}
}

class WriteTxtA implements Runnable {
	private FileWriter fileWriter;
	private CountDownLatch countDownLatch;
	public WriteTxtA(FileWriter fileWriter, CountDownLatch countDownLatch){
		this.fileWriter = fileWriter;
		this.countDownLatch = countDownLatch;
	}
	public void run() {
		// TODO Auto-generated method stub
		try{
			for (int i = 0; i < 5; i++) {
				System.out.println("WriteTxtA");
				fileWriter.write("WriteTxtA \n");
				Thread.sleep(50);
			}
			countDownLatch.countDown();
		} catch(IOException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

class WriteTxtB implements Runnable {
	private FileWriter fileWriter;
	private CountDownLatch countDownLatch;
	public WriteTxtB(FileWriter fileWriter, CountDownLatch countDownLatch){
		this.fileWriter = fileWriter;
		this.countDownLatch = countDownLatch;
	}
	public void run() {
		// TODO Auto-generated method stub
		try{
			for (int i = 0; i < 5; i++) {
				System.out.println("WriteTxtB");
				fileWriter.write("WriteTxtB \n");
				Thread.sleep(50);
			}
			countDownLatch.countDown();
		} catch(IOException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}