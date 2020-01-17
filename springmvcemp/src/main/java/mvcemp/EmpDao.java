package mvcemp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvcemp.Employee;

@Repository
public class EmpDao {
	@Autowired
	SessionFactory sessionfactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionfactory = sessionFactory;
	}
	public void addEmployee(Employee emp){
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		session.close();
	}
	public List<Employee> getEmployee(){
		Session session = sessionfactory.openSession();
		@SuppressWarnings("unchecked")
		List<Employee> employeelist = session.createQuery("from employee").list();
		return employeelist;
	}
	public Employee getEmployee(int id){
		Session session = sessionfactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, id);
		return emp;
	}
	public void updateEmployee(Employee emp){
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(emp);
		tx.commit();
		session.close();
	}
	public void deleteEmployee(Employee emp){
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(emp);
		tx.commit();
		session.close();
	}
}
