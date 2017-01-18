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
		System.out.println(Thread.currentThread().getName()+" is starting task number "+id);
		
		try {
			System.out.println(Thread.currentThread().getName()+" is working on task number "+id);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+ " completed task number "+id);
		
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
		// we can both use the following approach to be sure that executor finishes it's job
		 while(!executor.isTerminated()){}
//		try {		executor.awaitTermination(1, TimeUnit.DAYS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("All task completed and executor terminated it's job");
		
	}
}
