import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void testStatement() {



        String result;
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);
        Customer c1 = new Customer("joe");
        c1.addRental(r1);
        c1.addRental(r2);
        result = c1.statement();

        String intendedResult = "Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\t"+m1.getTitle()+"\t\t10\t30.0\n" +
                "\t"+m2.getTitle()+"\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";

        assertEquals(result, intendedResult);
    }

}
