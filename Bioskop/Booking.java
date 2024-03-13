import java.util.Random;

class Booking {
    private Film film;
    private int numberOfTickets;
    private int bookingId;

    public Booking(Film film, int numberOfTickets) {
        this.film = film;
        this.numberOfTickets = numberOfTickets;
        this.bookingId = new Random().nextInt(1000);
    }

    public Film getFilm() {
        return film;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public int getBookingId() {
        return bookingId;
    }
}