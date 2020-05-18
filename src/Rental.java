class Rental {
    Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getFrequentRenterPoints() {
        if(this.getMovie().getPriceCode() == Movie.NEW_RELEASE && this.getDaysRented() > 1) {
            return 2;
        }else return 1;


    }
}