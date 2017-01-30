package waitAndNotify;

import java.util.Scanner;

public class Processor {
	Scanner scanner=new Scanner(System.in);
	public void producer() throws InterruptedException{
		synchronized (this) {
			System.out.println("producer Thread Running ....");
			wait();
			System.out.println("Resumed after waking up and get mutex from consumer.\npress inter key to notify consumer taking mutex again\n");
			scanner.nextLine();
			notify();
			Thread.sleep(2000);
			
		}//end of synchronized method
	}//end of producer
	public void consumer() throws InterruptedException{
		Thread.sleep(2000);
		
		synchronized (this) {	
			System.out.println("consumer Thread Running ....");
			System.out.println("To see Thead quite bit in detail look at the vmVisual tool--> Thread tab");
			System.out.println("waiting for pressing return key on keyboard to notify producer");
			scanner.nextLine();
			System.out.println("return key pressed.");
			notify();
			System.out.println("consumer Thread notify producer and release the mutex after 5s");
			Thread.sleep(5000);
			wait();
			System.out.println("2nd time consumer get the mutex and doing something for 5 second(sleeping simulate ");
			Thread.sleep(5000);
		}//end of consumer
	}

}
