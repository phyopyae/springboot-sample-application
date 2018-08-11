package mm.co.sampleapplication.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mm.co.sampleapplication.entity.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public List<Customer> findById(Integer id){
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from customers where id = :id ");
		query.setParameter("id", id);
		List<Customer> customerList = query.list();
		return customerList;
	};

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByStatus(String status){
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from customers where status = :status ");
		query.setParameter("status", status);
		List<Customer> customerList = query.list();
		return customerList;
	};

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from customers").list();
		return customerList;
	};
	
	@Override
	public void addCustomer(Customer customer){
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
	};
	
	@Override
	public void updateCustomer(Customer customer){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> search(String searchObj){
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from customers where name like :search or mobile like :search ");
		query.setParameter("search", searchObj + '%');
		List<Customer> customerList = query.list();
		return customerList;
	}

	@Override
	public <S extends Customer> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Customer> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Customer> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Customer> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	};
}
