import java.util.ArrayList;

class MovieApp {
    private ArrayList<Film> films;
    private ArrayList<Booking> bookings;

    public MovieApp() {
        films = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void displayAllFilms() {
        System.out.println("List of Films:");
        for (Film film : films) {
            System.out.println(film.getTitle() + " - " + film.getGenre() + " - Duration: " + film.getDuration() + " mins - Available Seats: " + film.getAvailableSeats());
        }
    }

    public void searchFilm(String title) {
        boolean found = false;
        for (Film film : films) {
            if (film.getTitle().equals(title)) {
                System.out.println("Film Tersedia");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Film Tidak Tersedia");
        }
    }

    public void bookFilm(Film film, int numberOfTickets) {
        if (film.getAvailableSeats() >= numberOfTickets) {
            film.decreaseAvailableSeats(numberOfTickets);
            Booking booking = new Booking(film, numberOfTickets);
            bookings.add(booking);
            System.out.println("Pesanan berhasil dengan detail pesanan:");
            System.out.println("Film: " + film.getTitle());
            System.out.println("Jumlah Tiket: " + numberOfTickets);
            System.out.println("Booking ID:" + booking.getBookingId());
        } else {
            System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");
        }
    }

    public void searchBooking(int bookingId) {
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                System.out.println("Pesanan ditemukan dengan detail pesanan:");
                System.out.println("Film: " + booking.getFilm().getTitle());
                System.out.println("Jumlah Tiket: " + booking.getNumberOfTickets());
                System.out.println("Booking ID:" + booking.getBookingId());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Pesanan Tidak Ditemukan");
        }
    }
}