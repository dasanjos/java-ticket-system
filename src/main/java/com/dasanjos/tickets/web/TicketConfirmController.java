package com.dasanjos.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dasanjos.tickets.domain.TicketRequest;
import com.dasanjos.tickets.service.TicketService;

@Controller
@RequestMapping("/ticketConfirm.htm")
@SessionAttributes("ticketRequest")
public class TicketConfirmController {

	private TicketService ticketService;

	@RequestMapping(method = RequestMethod.GET)
	public String redirect() {
		return "ticketConfirmForm";
	}

	@RequestMapping(params = "save", method = RequestMethod.POST)
	public String onSave(@ModelAttribute("ticketRequest") TicketRequest request) {
		ticketService.confirm(request);
		return "redirect:ticketSuccess.htm";
	}

	@RequestMapping(params = "cancel", method = RequestMethod.POST)
	public String onReRequest(@ModelAttribute("ticketRequest") TicketRequest request) {
		ticketService.reReserve(request);
		return "redirect:ticketConfirm.htm";
	}

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String onDelete(@ModelAttribute("ticketRequest") TicketRequest request) {
		ticketService.unreserve(request);
		return "redirect:ticketReservation.htm";
	}

	@Autowired
	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}
}
