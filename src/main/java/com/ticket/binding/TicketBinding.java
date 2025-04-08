package com.ticket.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TicketBinding {

	private String fromLoc;
	private String toLoc;
	private String passengerName;
	private LocalDate journeyDate;
	private Long trainNum;
	private String pnr;
	private String ticketStatus;
	private Double ticketPrice;


}
