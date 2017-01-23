package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
   private int id;
   public Processor(int id){
	   this.id=id;
   }
	@Override
	public void run() {
		System.out.println(" STARTING...."+id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("COMPLETED: "+id);
		
	}
	
}
public class App { 
	public static void main(String[] Args) throws InterruptedException{
		ExecutorService executor=Executors.newFixedThreadPool(5);
		
		for(int i=0;i<10;i++){
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		
		System.out.println("All tasks submittd");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All task completed.");
		Runtime.getRuntime().exit(0);;
		
	}
}
