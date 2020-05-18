public class Movie {
    private String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (this.getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if(this.getPriceCode() == PriceCode.NEW_RELEASE && daysRented > 1) {
            return 2;
        }else return 1;


    }
}