package Thread17;

import java.util.concurrent.LinkedBlockingQueue;

public class Test6 {
	  
    public static void main(String[] args) {  
        Basket basket = new Basket();  
        Thread thread1 = new Thread(new Chief(basket));  
        Thread thread2 = new Thread(new Customer(basket));  
        Thread thread3 = new Thread(new Customer(basket));  
        thread1.start();  
        thread2.start();  
        thread3.start();  
    }  
}  
  
class Cake {  
    private static int index = 0;  
    private final int id = index++;  
  
    public int getId() {  
        return id;  
    }  
  
    public Cake() {  
        System.out.println("生产了蛋糕,id:" + id);  
    }  
}  
  
class Chief implements Runnable {  
    private Basket basket = null;  
  
    public Chief(Basket basket) {  
        this.basket = basket;  
    }  
  
    public void makeCake() throws InterruptedException {  
        for (int i = 0; i < 20; i++) {  
            basket.put(new Cake());  
            System.out.println("现在框里面的蛋糕数量：" + basket.getQueueSize());  
            Thread.sleep(20);  
        }  
    }  
  
    public void run() {  
        try {  
            makeCake();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
  
}  
  
class Customer implements Runnable {  
    private Basket basket = null;  
  
    public Customer(Basket basket) {  
        this.basket = basket;  
    }  
  
    public void buyCake() throws InterruptedException {  
        System.out.println("消费了蛋糕,id:" + basket.take().getId());  
        System.out.println("现在框里面的蛋糕数量：" + basket.getQueueSize());  
    }  
  
    public void run() {  
        try {  
            for (int i = 0; i < 10; i++) {  
                buyCake();  
                Thread.sleep(100);  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}  
  
class Basket {  
    private LinkedBlockingQueue<Cake> queue = new LinkedBlockingQueue<Cake>(10);  
  
    public void put(Cake cake) throws InterruptedException {  
        queue.put(cake);  
    }  
  
    public Cake take() throws InterruptedException {  
        Cake cake = queue.take();  
        return cake;  
    }  
  
    public int getQueueSize() {  
        return queue.size();  
    }  
}  