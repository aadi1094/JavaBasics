package OOPS.Inheritance.HierarchicalInheritance.MovieTicketBooking;

public class NormalTicket extends Ticket {
    float gst =5f;

    double totalNormalTicket(int quant){
        return calculateAmount(quant)+(calculateAmount(quant)*(gst/100.0));
    }
}
