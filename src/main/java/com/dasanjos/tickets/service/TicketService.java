package com.dasanjos.tickets.service;

import java.util.List;

import com.dasanjos.tickets.domain.Ticket;
import com.dasanjos.tickets.domain.TicketRequest;

public interface TicketService {

	public void reserve(TicketRequest request);

	public void reReserve(TicketRequest request);
	
	public void unreserve(TicketRequest request);

	public void confirm(TicketRequest request);

	public List<Ticket> getTickets();
}
