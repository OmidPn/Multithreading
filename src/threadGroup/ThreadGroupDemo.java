package threadGroup;

public class ThreadGroupDemo implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}
	public static void main(String[] args) {
	ThreadGroupDemo runnableObj=new ThreadGroupDemo();
	ThreadGroup tg=new ThreadGroup("threadGroupExample");
	
	//create 3 threads
	Thread t1=new Thread(tg, runnableObj, "one");
	Thread t2 =new Thread(tg, runnableObj, "two");
	Thread t3=new Thread(tg,runnableObj, "Three");
	t1.start();
	t2.start();
	t3.start();
	System.out.println("Thread Group Name is : "+tg.getName());
	tg.list();
	}

	

}
