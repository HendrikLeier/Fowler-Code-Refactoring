import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private List<Rental> rentals = new LinkedList<>();

    public Customer(String newname) {
        name = newname;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental rental : rentals) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.movie.getCharge(rental.getDaysRented())) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + this.getTotalCharge() + "\n";
        result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double totalCharge = 0;
        for (Rental rental : rentals) {
            totalCharge += rental.movie.getCharge(rental.getDaysRented());
        }

        return totalCharge;
    }

    private int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        for (Rental rental : rentals) {
            totalPoints += rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());
        }

        return totalPoints;
    }

}
    