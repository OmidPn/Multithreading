package threadPriority;
class TestMultiPriority1 extends Thread{  
	 public void run(){  
	   System.out.println("running thread name is:"+Thread.currentThread().getName());  
	   System.out.println("running thread priority is:"+Thread.currentThread().getPriority());  
	  
	  }  
	 public static void main(String args[]){  
	  TestMultiPriority1 m1=new TestMultiPriority1(); 
	  m1.setPriority(Thread.MIN_PRIORITY);  
	  m1.start();
	  TestMultiPriority1 m2=new TestMultiPriority1();  	
	  m2.setPriority(Thread.NORM_PRIORITY);  	
	  m2.start();  
	  TestMultiPriority1 m3=new TestMultiPriority1();  	
	  m3.setPriority(Thread.MAX_PRIORITY); 
	  m3.start();  
	 }  
	}     