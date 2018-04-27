package com.theater.main;
import java.util.List;import java.util.Scanner;
import com.theater.command.TheaterLayout;import com.theater.command.TicketRequest;import com.theater.service.SeatingService;import com.theater.service.SeatingServiceImpl;
/* * Input while running the program 6 6  3 5 5 3 4 6 6 4  2 8 8 2 6 6 
 smith 2 Jones 5 Davis 6 wilson 100 johson 3 williams 4 brown 8 miller 12 finish * */
public class TestSeatRequest {
 public static void main(String[] args) {
  String line;  StringBuilder layout = new StringBuilder();  StringBuilder ticketRequests = new StringBuilder();  boolean isLayoutFinished = false;
  System.out    .println("Enter Theater Layout, Ticket requests and then enter 'finish'.\n");
  Scanner reqInput = new Scanner(System.in);
  while ((line = reqInput.nextLine()) != null && !line.equals("finish")) {
   if (line.length() == 0) {
    isLayoutFinished = true;    continue;
   }
   if (!isLayoutFinished) {
    layout.append(line + System.lineSeparator());
   } else {
    ticketRequests.append(line + System.lineSeparator());
   }
  }
  reqInput.close();
  SeatingService service = new SeatingServiceImpl();
  try {
   TheaterLayout theaterLayout = service.getTheaterLayout(layout     .toString());
   List<TicketRequest> requests = service     .getTicketRequests(ticketRequests.toString());
   service.processTicketRequests(theaterLayout, requests);
  } catch (NumberFormatException nfe) {
   System.out.println(nfe.getMessage());
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
