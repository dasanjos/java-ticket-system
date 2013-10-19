package com.dasanjos.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasanjos.tickets.dao.TicketDAO;
import com.dasanjos.tickets.domain.Ticket;
import com.dasanjos.tickets.domain.TicketRequest;

@Transactional(readOnly = false)
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO ticketDAO;

	@Override
	public void reserve(TicketRequest request) {
		request.setTickets(reserve(request.getAmount(), 0));
	}

	@Override
	public void reReserve(TicketRequest request) {
		int offset = 0;

		while (!request.getTickets().isEmpty()) {
			Ticket ticket = request.getTickets().remove(0);
			ticket.setReserved(false);
			ticketDAO.saveTicket(ticket);
			if (ticket.getSeat() > offset) {
				offset = ticket.getSeat();
			}
		}

		request.setTickets(reserve(request.getAmount(), offset));
	}

	@Override
	public void unreserve(TicketRequest request) {
		while (!request.getTickets().isEmpty()) {
			Ticket ticket = request.getTickets().remove(0);
			ticket.setReserved(false);
			ticketDAO.saveTicket(ticket);
		}
	}

	@Override
	public void confirm(TicketRequest request) {
		for (Ticket ticket : request.getTickets()) {
			ticket.setName(request.getName());
			ticket.setReserved(true);
			ticketDAO.saveTicket(ticket);
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ticket> getTickets() {
		return ticketDAO.listTickets();
	}

	private List<Ticket> reserve(int limit, int offset) {
		List<Ticket> available = ticketDAO.getFreeTickets(limit, offset);
		for (Ticket ticket : available) {
			ticket.setReserved(true);
			ticketDAO.saveTicket(ticket);
		}
		return available;
	}

	public void setTicketDAO(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}
}
