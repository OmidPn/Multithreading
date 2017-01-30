package waitAndNotify;

import java.io.InputStream;
import java.io.OutputStream;

public class App {

	public static void main(String[] args) throws InterruptedException {
	Processor processor =new Processor();
	Thread t1=new Thread(new Runnable(){
		public void run(){
			try {
				processor.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	Thread t2=new Thread(new Runnable(){
		public void run(){
			try {
				processor.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	t1.setName("producer thread");
	t1.start();
	t2.setName("consumer Thread");
	t2.start();
	t1.join();
	//t2.join();
	
	

}
}
