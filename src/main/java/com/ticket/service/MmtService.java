package com.ticket.service;

import com.irctc.binding.TicketBinding;
import com.irctc.entity.Passenger;

public interface MmtService {

	public TicketBinding bookTicket();
	public TicketBinding getTrainInformation(String pnr);
	public TicketBinding updateTicket(String pnr, Passenger passenger);
	public boolean cancelTicket(String pnr);

}
