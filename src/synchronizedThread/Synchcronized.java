package synchronizedThread;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Synchcronized {
     private int count =0;
     
    private synchronized void increament(){
    	count++;
    }
	public static void main(String[] args) {
		Synchcronized sys=new Synchcronized();
		sys.doworkd();
	}
	private void doworkd() {
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0;i<10000;i++)increament();
			}
			
		});
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {
				
				for(int i=0;i<10000;i++)increament();
				
			}
			
		});
	t1.start();
	
	t2.start();
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("count is :"+count);
	}

}
