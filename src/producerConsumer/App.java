package producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
   private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);
	public static void main(String[] args) throws InterruptedException {

     //providing Threads to take process for producer and consumer methods
		Thread trdProducer=new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(40);
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		Thread trdConsumer=new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		trdProducer.start();
		trdConsumer.start();
		trdProducer.join();
		trdConsumer.join();

	}//end of main
	
	public static void producer() throws InterruptedException{
		Random random=new Random();
		
		while(true){
			Integer value=random.nextInt(100);
			System.out.println("insert Value: "+value +" Queue size is : "+queue.size());
			queue.put(value);
		}
	}
	public static void consumer() throws InterruptedException{
		Random random=new Random();
		while(true){
			Thread.sleep(100);
			if(random.nextInt(40)==0) {
			 Integer value=	queue.take();
				System.out.println("Taken Value: "+value +" Queue size is : "+queue.size());
			}
		}
	}
	

}
