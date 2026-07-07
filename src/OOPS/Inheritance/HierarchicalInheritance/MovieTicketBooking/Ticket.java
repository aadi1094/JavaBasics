package OOPS.Inheritance.HierarchicalInheritance.MovieTicketBooking;

public class Ticket {
    String movieName="Bhaubali";
    double ticketPrice=200;
    int noOfTickets;
    float showTime=4.30f;

    double calculateAmount(int n){
        return ticketPrice*n;
    }
}
