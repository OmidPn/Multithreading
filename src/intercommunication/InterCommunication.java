package intercommunication;


class Customer{  
int amount=10000;  
  
synchronized void withdraw(int amount){  
System.out.println("going to withdraw...");  
  
if(this.amount<amount){  
System.out.println("Less balance; waiting for deposit...");  
try{wait();}catch(Exception e){}  
}  
this.amount-=amount; 
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();}
System.out.println("withdraw completed...");  
}  
  
synchronized void deposit(int amount){  
System.out.println("going to deposit...");
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
this.amount+=amount;  
System.out.println("deposit completed... ");  
notify();  
}  
}  
  
public class InterCommunication{  
public static void main(String args[]){  
final Customer c=new Customer();  
new Thread(){  
public void run(){c.withdraw(15000);}  
}.start();  
new Thread(){  
public void run(){c.deposit(10000);}  
}.start();  
  
}}  