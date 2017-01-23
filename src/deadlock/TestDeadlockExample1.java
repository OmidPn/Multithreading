package deadlock;
//both thread want to lock 2 resources and they are waiting for each other
public class TestDeadlockExample1 {  
	  public static void main(String[] args) {  
	    final String resource1 = "ratan jaiswal";  
	    final String resource2 = "vimal jaiswal"; 
	    
	    // first thread tries to lock resource1 first and then wants to lock resource2  
	    new Thread(new Runnable(){

			@Override
			public void run() {
				 synchronized (resource1) {  
			           System.out.println("Thread 1: locked resource 1");  
			  
			           try { Thread.sleep(100);} catch (Exception e) {}
			    synchronized (resource2) {
			        	 
			            System.out.println("Thread 1: locked resource 2"); 
			           }
				
			}
				 }
	    }).start();
	    
	    // second thread tries to lock resource2 at first and then wants to lock resource1  
	    new Thread(new Runnable(){

			@Override
			public void run() {
				 synchronized (resource2) {  
			           System.out.println("Thread 2: locked resource 2");  
			  
			           try { Thread.sleep(100);} catch (Exception e) {}  
			  
			           synchronized (resource1) {  
			            System.out.println("Thread 2: locked resource 1"); 
			           }
				
			}
				 }
	    }).start();
	    
	  
	  }  
	}  