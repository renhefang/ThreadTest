package Thread17;

public class Bank {
	private final double[] accounts;
	public double[] getAccounts(){
		return accounts;
	}
	public Bank(int n, double initBalance){
		this.accounts = new double[n];
		for(int i = 0; i < accounts.length; i++){
			accounts[i] = initBalance;
		}
	}
	public double getTotal(){
		double total = 0;
		for(int i = 0; i < accounts.length; i++){
			total += accounts[i];
		}
		return total;
	}
	/**
	 * 在void前加上synchronized可实现线程同步，使总额不变
	 * 可替代方法，在if前加上synchronized(lock){....}
	 * 
	 * volatile只能用于变量的赋值
	 */
	public void transfer(int fromAccount, int toAccount, double money){
		if(accounts[fromAccount] < money){
			System.out.println(Thread.currentThread().getName() + "出现死锁");  
			// Thread.currentThread().wait();//如果是其他的多线程，可能在这里是wait，从而出现真正的死锁  
            return;  
		}
		accounts[fromAccount] -= money;
		System.out.printf("从" + fromAccount + "账户转出%10.2f元,", money);  
		accounts[toAccount] += money;  
        System.out.printf("从" + toAccount + "账户转入%10.2f元,", money);  
        System.out.printf("总数：%10.2f元", getTotal());  
        System.out.println();
	}
	public int size(){
		return accounts.length;
	}
}
