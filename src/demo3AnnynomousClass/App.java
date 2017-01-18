package demo3AnnynomousClass;

public class App {

	public static void main(String[] args) {
	  
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i=0;i<10;i++){
					 System.out.println("hello my thread: "+i);
				  }
				  try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			
			
		});
		
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {
				for (int i=0;i<10;i++){
					 System.out.println("hello my thread: "+i);
				  }
				  try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			
		});
		t1.start();
		t2.start();
	}

}
