package p1;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.Iterator;
import javax.transaction.Transaction;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateManager {
	private static Session session;
	
	
	static boolean al1 = new ArrayList() != null;
	static ArrayList al2 = new ArrayList();
	
         public boolean connect() {
		
        	 Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); //connects to cfg
             ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
             SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());                  
             session =sessionFactory.openSession();    
             if(session!=null) {
                 System.out.println("Connected to the mysql database");
                 return true;
             }
             else {
                 System.out.println("Could not connect to the mysql database");
                 return false;
             }
	}
         public boolean insert(Student s) {
        	 org.hibernate.Transaction ref = session.beginTransaction();
        	 session.save(s);
        	 ref.commit();
        	 System.out.println("Data Inserted");
        	 return true;
         }
         
         public ArrayList getData() {
        	org.hibernate.Transaction ref = session.beginTransaction();
        	Query q =  session.createQuery("from Student");
        	List list = q.list();
        	ArrayList al1 = new ArrayList();
        	ArrayList al2 = new ArrayList();
        	Iterator itr = list.iterator();
        	while(itr.hasNext()==true) 
        	{
        		
        		Student s = (Student)itr.next();
        		al1.add(s.getSid());
        		al2.add(s.getSname());
        		ref.commit();
        		return al1;
        	}
         }
        	
        	public boolean getSpecificData(int id) {
        		Transaction ref = (Transaction) session.beginTransaction();
        		Student s = (Student)session.get(Student.class,id);
        		al1.clear();
        		al2.clear();
        		al1.add(s.getSid());
        		al2.add(s.getSname());
        		ref.commit();
        		return al1;
        	}
        	
        	
        	public boolean updateDate(int id,String new_nm) {
        		org.hibernate.Transaction ref =session.beginTransaction();
        		Student s = (Student) session.get(Student.class,id);
        		s.setSname(new_nm);
        		session.update(s);
        		ref.commit();
        		return true;
        	}
        	
        	public boolean deleteData(int id) {
        	org.hibernate.Transaction ref = session.beginTransaction();
        	Student s= (Student) session.get(Student.class,id);
        	session.delete(id);
        	ref.commit();
			return false;
        	
        	}
        	
		public boolean updateData(int i, String string) {
			// TODO Auto-generated method stub
			return false;
		}
        	
         }
         

