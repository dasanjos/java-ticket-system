package com.dasanjos.tickets.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dasanjos.tickets.domain.Ticket;

@Repository
public class TicketDAOImpl implements TicketDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTicket(Ticket ticket) {
		sessionFactory.getCurrentSession().saveOrUpdate(ticket);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ticket> listTickets() {
		return sessionFactory.getCurrentSession().createQuery("FROM Ticket")
				.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ticket> getFreeTickets(int limit, int offset) {
		return sessionFactory.getCurrentSession().createQuery(
				"FROM Ticket WHERE reserved = :var ORDER BY seat").setBoolean(
				"var", false).setMaxResults(limit).setFirstResult(offset)
				.list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
