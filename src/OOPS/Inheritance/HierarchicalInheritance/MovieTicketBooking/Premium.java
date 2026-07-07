package OOPS.Inheritance.HierarchicalInheritance.MovieTicketBooking;

public class Premium extends Ticket{
    float gst=12f;

    double totalPremiumTicket(int quant){
        return calculateAmount(quant)+(calculateAmount(quant)*(gst/100.0));
    }
}
