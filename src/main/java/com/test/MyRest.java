package com.test;


import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Car;
import com.util.HibernateConfiguration;

@RestController
@RequestMapping("/api/v1.0.0/")
public class MyRest {

	@RequestMapping(value="/test")
	public String getTestResult() {
		try {
			Car car = new Car("TestLicense","M1","D1","G1");
			Session session = HibernateConfiguration.openHibernateSession();
			Transaction tx = session.beginTransaction();
			session.save(car);
			tx.commit();
			HibernateConfiguration.closeHibernateSession(session);			
		}catch(ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violation = e.getConstraintViolations();
			for(ConstraintViolation<?> violation2 : violation) {
				System.err.println(violation2.getPropertyPath() + violation2.getMessage());
			}
		}
		return "Saved succesfully";
	}
}
