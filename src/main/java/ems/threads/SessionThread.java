package ems.threads;
public class SessionThread implements Runnable{
	public void run() {
		
	}
public static void main(String args[]) {
	SessionThread st=new SessionThread();
	Thread t=new Thread(st);
	t.setDaemon(true);
	t.start();
}
}
