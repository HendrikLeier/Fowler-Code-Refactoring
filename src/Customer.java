import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.movie.getCharge(rental.getDaysRented())) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double totalCharge = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            totalCharge += rental.movie.getCharge(rental.getDaysRented());
        }

        return totalCharge;
    }

    private int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental rental = (Rental) enum_rentals.nextElement();
            totalPoints += rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());
        }

        return totalPoints;
    }

}
    