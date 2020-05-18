import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private List<Rental> rentals = new LinkedList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return this.name;
    }

    public String statement() {
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental rental : this.rentals) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(rental.getMovie().getCharge(rental.getDaysRented())) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + this.getTotalCharge() + "\n";
        result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double totalCharge = 0;
        for (Rental rental : this.rentals) {
            totalCharge += rental.getMovie().getCharge(rental.getDaysRented());
        }

        return totalCharge;
    }

    private int getTotalFrequentRenterPoints() {
        int totalPoints = 0;
        for (Rental rental : this.rentals) {
            totalPoints += rental.getMovie().getFrequentRenterPoints(rental.getDaysRented());
        }

        return totalPoints;
    }

}
    