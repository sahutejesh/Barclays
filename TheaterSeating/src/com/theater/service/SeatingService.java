package com.theater.service;
import java.util.List;
import com.theater.command.TheaterLayout;import com.theater.command.TicketRequest;
public interface SeatingService {
 TheaterLayout getTheaterLayout(String rawLayout);
 List<TicketRequest> getTicketRequests(String ticketRequests);
 void processTicketRequests(TheaterLayout layout,   List<TicketRequest> requests);
}
