package com.dasanjos.tickets.domain;

import java.util.List;

public class TicketRequest {

	private String name;
	// private Date day;
	private int amount;
	private List<Ticket> tickets;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

}
