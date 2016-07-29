package Thread17;

public class Thread3 { 
    public static void main(String[] args){ 
        RunnableTest rt = new RunnableTest(); 
        //定义两个线程，他们引用相同的数据 
        Thread t1 = new Thread(rt); 
        Thread t2 = new Thread(rt); 
        //设置线程的名字 
        t1.setName("线程1"); 
        t2.setName("线程2"); 
        //运行后，线程1 和线程2会交替运行 
        t1.start(); 
        t2.start(); 
    } 
} 
class RunnableTest implements Runnable{ 
    public void run(){ 
            for(int i=0;i<=20;i++){ 
                //得到当前线程的名字 
                String str = Thread.currentThread().getName(); 
                System.out.println(str+":"+i); 
            } 
        } 
} 