package com.dasanjos.tickets.validator;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dasanjos.tickets.domain.TicketRequest;

public class TicketRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TicketRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		rejectIfEmptyOrWhitespace(errors, "amount", "amount.required");
		TicketRequest request = (TicketRequest) target;
		if (request.getAmount() < 1 || request.getAmount() > 60) {
			errors.rejectValue("amount", "amount.invalid");
		}
	}

}
