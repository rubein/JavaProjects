package test;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import dao.BaseDao;

import pojos.R_BusDetails;
import pojos.R_Stops;

import util.HibernateUtil;

public class TestBus {

	@Test
	public void testMyBus() {
		String queryString = "select b from R_BusDetails b where b.busNo=:number";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(queryString);
		query.setString("number", "ABC");
		List<R_BusDetails> bus = (List<R_BusDetails>)query.list();
		System.out.println(bus.get(0).getBusId());
	}
	

	
}
