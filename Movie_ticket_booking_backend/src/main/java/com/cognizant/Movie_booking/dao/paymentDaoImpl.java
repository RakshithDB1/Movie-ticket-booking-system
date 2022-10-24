package com.cognizant.Movie_booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import java.sql.Time;
import java.util.Date;

import com.cognizant.Movie_booking.models.payment;

@Repository
public class paymentDaoImpl implements paymentDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(paymentDaoImpl.class);

	@Autowired
	JdbcTemplate template;

	// get all the payments from the database
	@Override
	public List<payment> getAllpayment() {

		return template.query("select * from payment", new ResultSetExtractor<List<payment>>() {

			@Override
			public List<payment> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<payment> list = new ArrayList<payment>();
				while (rs.next()) {
					payment p = new payment();
					p.setPayment_id(rs.getInt(1));
					p.setMovie_cost(rs.getString(2));
					p.setPayment_time((Time) rs.getTime(3));
					p.setPayment_date((Date) rs.getDate(4));
					p.setUser_id(rs.getInt(5));
					p.setMovie_id(rs.getInt(6));

					list.add(p);
				}
				return list;
			}
		});

	}

	// return the payment by giving user id as input
	@Override
	public payment getPaymentByPayment_id(int payment_id) {
		List<payment> list = getAllpayment();
		for (payment payment : list) {
			if (payment.getPayment_id() == payment_id) {
				return payment;
			}

		}
		return null;
	}

	@Override
	public boolean Insertpaymentrecord(payment p) {
		boolean status = false;
		try {
			int update = 0;
			String sql = "INSERT INTO payment VALUES(?,?,?,?,?)";
			update = template.update(sql, p.getMovie_cost(), p.getPayment_time(), p.getPayment_date(), p.getUser_id(),
					p.getMovie_id());
			if (update != 0) {
				status = true;
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return status;
	}

}
