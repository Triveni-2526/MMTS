package com.ticket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.binding.PassengerBinding;
import com.irctc.binding.TicketBinding;
import com.ticket.service.MmtService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/mmt")
public class MmtController {

	private MmtService mmtService;

	public MmtController(MmtService mmtService) {
		super();
		this.mmtService = mmtService;
	}

	@PostMapping("/bookTicket")
	public ResponseEntity<TicketBinding> bookTicketFromController(@RequestBody PassengerBinding passenger) {
		TicketBinding ticketInfo = mmtService.bookTicket()
		return new ResponseEntity<TicketBinding>(ticketInfo, HttpStatus.OK);
	}

	@GetMapping("/getTicket/{pnr}")
	public ResponseEntity<TicketBinding> getTicketDataFromRestController(@PathVariable String pnr) {
		TicketBinding trainInformation = mmtService.getTrainInformation(pnr);
		return new ResponseEntity<TicketBinding>(trainInformation, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{pnr}", produces = { "application/json" }, consumes = { "application/xml",
			"application/json" })
	public ResponseEntity<TicketBinding> updatedTicketDataFromRestController(@PathVariable String pnr,
			@RequestBody PassengerBinding passenger) {
		TicketBinding trainInformation = mmtService.updateTicket(pnr, null);
		return new ResponseEntity<TicketBinding>(trainInformation, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{pnr}")
	public ResponseEntity<String> cancelTicket(@PathVariable String pnr) {
		boolean isDeleted = mmtService.cancelTicket(pnr);
		if (isDeleted) {
			return new ResponseEntity<>("Ticket with PNR " + pnr + " has been cancelled.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Ticket not found with PNR " + pnr, HttpStatus.NOT_FOUND);
		}
	}

}
