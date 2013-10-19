package com.dasanjos.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dasanjos.tickets.service.TicketService;

@Controller
@RequestMapping("/ticketSuccess.htm")
@SessionAttributes("ticketRequest")
public class TicketSuccessController {

	private TicketService ticketService;

	@RequestMapping(method = RequestMethod.GET)
	public String redirect(ModelMap model) {
		model.addAttribute("tickets", ticketService.getTickets());
		return "ticketSuccess";
	}

	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
}
