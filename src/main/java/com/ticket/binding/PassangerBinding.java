package com.ticket.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PassangerBinding {

	private String passengerName;
	private String fromLoc;
	private String toLoc;
	private LocalDate journeyDate;
	private String email;
	private Long trainNum;

}
