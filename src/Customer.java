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
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental : this.rentals) {
            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rental.getMovie().getCharge(rental.getDaysRented())).append("\n");
        }
        //add footer lines
        result.append("Amount owed is ").append(this.getTotalCharge()).append("\n");
        result.append("You earned ").append(this.getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
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
    