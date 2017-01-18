package usingvolatile;

import java.util.Scanner;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane.ScalableIconUIResource;

class processor extends Thread{
	private volatile boolean running=true;
    public void run() {
		
    	while(running){
    		System.out.println("hello");
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
    	}
	}
   public void shotdown(){
	   running=false;
   }
}
public class VolatileApp {
	
	
	public static void main(String[] args) {
		processor proc1=new processor();
		proc1.start();
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		proc1.shotdown(); 

	}

}
