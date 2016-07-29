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
	 * ��voidǰ����synchronized��ʵ���߳�ͬ����ʹ�ܶ��
	 * �������������ifǰ����synchronized(lock){....}
	 * 
	 * volatileֻ�����ڱ����ĸ�ֵ
	 */
	public void transfer(int fromAccount, int toAccount, double money){
		if(accounts[fromAccount] < money){
			System.out.println(Thread.currentThread().getName() + "��������");  
			// Thread.currentThread().wait();//����������Ķ��̣߳�������������wait���Ӷ���������������  
            return;  
		}
		accounts[fromAccount] -= money;
		System.out.printf("��" + fromAccount + "�˻�ת��%10.2fԪ,", money);  
		accounts[toAccount] += money;  
        System.out.printf("��" + toAccount + "�˻�ת��%10.2fԪ,", money);  
        System.out.printf("������%10.2fԪ", getTotal());  
        System.out.println();
	}
	public int size(){
		return accounts.length;
	}
}
