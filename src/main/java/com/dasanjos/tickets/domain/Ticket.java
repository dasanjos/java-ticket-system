package com.dasanjos.tickets.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket {

	private Long id;
	private String name;
	// private Date day;
	private int seat;
	private boolean reserved;

	@Id
	@GeneratedValue
	@Column(name = "TICKET_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TICKET_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEAT_NUMBER")
	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Column(name = "RESERVED")
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public boolean isReserved() {
		return reserved;
	}

	@Override
	public String toString() {
		return Integer.toString(seat);
	}
}
