/**
 * 
 */
package demo1startAndRun;

/**
 * @author omid
 *
 */
 class Runner extends Thread{

		public void run(){
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
}
public class App  {
  
	
	public static void main(String[] args) {
		
       Runner runner1=new Runner();
        runner1.start();
        Runner runner2=new Runner();
        runner2.start();
        
	}

}