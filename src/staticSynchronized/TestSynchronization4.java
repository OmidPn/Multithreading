package staticSynchronized;


class Table{  
  
 synchronized static void printTable(int n){  
   for(int i=1;i<=10;i++){  
     System.out.println(n*i);  
     try{  
       Thread.sleep(1000);  
     }catch(Exception e){}  
   }  
 } 
 /* The equivalent of the static method above is like below
  *
      static void printTable(int n) {  
	    synchronized (Table.class) {       // Synchronized block on class A  
	        // ...  
	    }  
	}  */
}  
  
public class TestSynchronization4 {
	public static void main(String[] args){  
		
	new Thread(new Runnable(){

			@Override
			public void run() {
				Table.printTable(1);  
			}
		}).start();
	new Thread(new Runnable(){

		@Override
		public void run() {
			Table.printTable(10);  
		}
	}).start();
	new Thread(new Runnable(){

		@Override
		public void run() {
			Table.printTable(100);  
		}
	}).start();
	new Thread(new Runnable(){

		@Override
		public void run() {
			Table.printTable(1000);  
		}
	}).start();
 
 } //end of main 
}
