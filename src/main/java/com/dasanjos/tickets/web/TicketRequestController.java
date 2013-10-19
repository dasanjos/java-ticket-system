package com.dasanjos.tickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dasanjos.tickets.domain.TicketRequest;
import com.dasanjos.tickets.service.TicketService;
import com.dasanjos.tickets.validator.TicketRequestValidator;

@Controller
@RequestMapping("/ticketReservation.htm")
@SessionAttributes("ticketRequest")
public class TicketRequestController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private TicketRequestValidator ticketRequestValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		TicketRequest ticketRequest = new TicketRequest();
		model.addAttribute("ticketRequest", ticketRequest);
		model.addAttribute("tickets", ticketService.getTickets());
		return "ticketRequestForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("ticketRequest") TicketRequest request,
			BindingResult result) {
		ticketRequestValidator.validate(request, result);
		if (result.hasErrors()) {
			return "ticketRequestForm";
		} else {
			ticketService.reserve(request);
			return "redirect:ticketConfirm.htm";
		}
	}

	public void setTicketService(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	public void setTicketRequestValidator(
			TicketRequestValidator ticketRequestValidator) {
		this.ticketRequestValidator = ticketRequestValidator;
	}
}
