package Thread17;

public class Thread3 { 
    public static void main(String[] args){ 
        RunnableTest rt = new RunnableTest(); 
        //���������̣߳�����������ͬ������ 
        Thread t1 = new Thread(rt); 
        Thread t2 = new Thread(rt); 
        //�����̵߳����� 
        t1.setName("�߳�1"); 
        t2.setName("�߳�2"); 
        //���к��߳�1 ���߳�2�ύ������ 
        t1.start(); 
        t2.start(); 
    } 
} 
class RunnableTest implements Runnable{ 
    public void run(){ 
            for(int i=0;i<=20;i++){ 
                //�õ���ǰ�̵߳����� 
                String str = Thread.currentThread().getName(); 
                System.out.println(str+":"+i); 
            } 
        } 
} 