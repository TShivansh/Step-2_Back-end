package p1;

public class AppLaunch {
	
	public static void main(String[]args) {
		
		HibernateManager hm = new HibernateManager();
		hm.connect();
	}

}
