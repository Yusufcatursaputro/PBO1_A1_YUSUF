class Film {
    private String title;
    private String genre;
    private int duration;
    private int availableSeats;

    public Film(String title, String genre, int duration, int availableSeats) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void decreaseAvailableSeats(int bookedSeats) {
        availableSeats -= bookedSeats;
    }
}