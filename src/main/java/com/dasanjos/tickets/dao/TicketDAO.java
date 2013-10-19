package com.dasanjos.tickets.dao;

import java.util.List;

import com.dasanjos.tickets.domain.Ticket;

public interface TicketDAO {

	public void saveTicket(Ticket ticket);

	public List<Ticket> listTickets();

	public List<Ticket> getFreeTickets(int limit, int offset);
}
