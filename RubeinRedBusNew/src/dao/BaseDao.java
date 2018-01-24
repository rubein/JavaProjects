package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pojos.R_BusDetails;
import pojos.R_Customer;
import pojos.R_Stops;
import util.HibernateUtil;

public class BaseDao {
	public void add(Object obj) {
		// 1. We ned the SessionFactory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// 2. We need a sesssion object
		Session session = sessionFactory.getCurrentSession();
		// 3. We need to bind the session with transaction object
		Transaction tx = session.beginTransaction();

		try {
			session.save(obj); // will do insert only
			// session.saveOrUpdate(obj);
			System.out.println("in dao add" + obj);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public <E> E get(Class<E> classname, Serializable pk) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		// Transaction tx=session.beginTransaction();
		try {
			E e = (E) session.get(classname, pk); // select
			return e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public <E> List<E> getAll(Class<E> className) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from " + className.getName());
			List<E> list = query.list();
			return list;
		}

		finally {
			session.close();
		}
	}

	@SuppressWarnings("hiding")
	public <R_BusDetails> List<R_BusDetails> getAllAvailableBus() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("Select r from R_BusDetails r where r.status='Available'");
			@SuppressWarnings("unchecked")
			List<R_BusDetails> list = query.list();
			return list;
		}

		finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public <E> void deleteObject(Class<E> classname, Serializable pk) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			E eproc = (E) session.get(classname, pk); // select
			session.delete(eproc);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			throw e;
		}
	}

	public void edit(Object obj) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public int getTableData(String busNumber) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			String queryString = "select b from R_BusDetails b where b.busNo=:number";
			System.out.println(queryString);
			Query query = session.createQuery(queryString);
			query.setString("number", busNumber);
			List<R_BusDetails> list = query.list();
			R_BusDetails rbd1 = new R_BusDetails();
			for (R_BusDetails rbd : list) {
				rbd1 = rbd;
			}
			int id = rbd1.getBusId();
			// List<String> list =
			// session.createQuery(queryString).setString("busNumber",
			// busNumber).list();
			return id;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<R_Stops> displayAllStops() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx1 = session.beginTransaction();
		ArrayList<R_Stops> list = null;
		try {
			String queryString = "select distinct f from R_Stops f order by f.id";
			Query query = (Query) session.createQuery(queryString);
			// query.addEntity(BusStop.class);

			list = (ArrayList<R_Stops>) query.list();
			System.out.println(list + "in basedao");
			tx1.commit();
			return list;
			// System.out.println(list + "DAO");

		} catch (HibernateException he) {
			if (tx1 != null)
				tx1.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<R_Customer> getCustomerAuthenticated(String cust_email) {
		System.out.println(cust_email);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String queryString = "from R_Customer c where c.email=:email";
		Query query1 = session.createQuery(queryString);
		query1.setString("email", cust_email);
		List<R_Customer> cust = query1.list();
		System.out.println("end id " + cust);
		return cust;
	}

	@SuppressWarnings("rawtypes")
	public List getStartStopID(String start) {
		List list1;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString1 = "select p.id from R_Stops p where p.name=:stopStart";
		Query query = (Query) session.createQuery(queryString1);
		query.setString("stopStart", start);
		list1 = query.list();
		System.out.println("start id " + list1);
		session.close();
		return list1;
	}

	@SuppressWarnings("rawtypes")
	public List getEndID(String end) {
		List endId;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "select p.id from R_Stops p where p.name=:stopEnd";
		Query query1 = (Query) session.createQuery(queryString);
		query1.setString("stopEnd", end);
		endId = query1.list();
		System.out.println("end id " + endId);
		return endId;

	}
}