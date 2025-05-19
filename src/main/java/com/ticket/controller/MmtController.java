package com.ticket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticket.binding.PassangerBinding;
import com.ticket.binding.TicketBinding;
import com.ticket.service.MmtService;

import java.awt.*;

@RestController
@RequestMapping("/mmt")
public class MmtController {

	private MmtService mmtService;

	public MmtController(MmtService mmtService) {
		super();
		this.mmtService = mmtService;
	}

	@PostMapping("/bookTicket")
	public ResponseEntity<TicketBinding> bookTicketFromController(@RequestBody PassangerBinding passenger) {
		TicketBinding ticketInfo = mmtService.bookTicket();
		System.out.println("1st line");
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
