public class Passenger {
    private int passengerNumber;
    private String surname;
    private String initials;
    private String route;
    private String date;
    private double ticketAmount;
    private String status;

    public Passenger(int passengerNumber, String surname, String initials, String route, String date, double ticketAmount, String status) {
        this.passengerNumber = passengerNumber;
        this.surname = surname;
        this.initials = initials;
        this.route = route;
        this.date = date;
        this.ticketAmount = ticketAmount;
        this.status = status;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int value) {
        passengerNumber = value;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String value) {
        surname = value;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String value) {
        initials = value;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String value) {
        route = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        date = value;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(double value) {
        ticketAmount = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        status = value;
    }

    // New method to update booking details
    public void updateBooking(String newRoute, String newDate, double newTicketAmount, String newStatus) {
        setRoute(newRoute);
        setDate(newDate);
        setTicketAmount(newTicketAmount);
        setStatus(newStatus);
    }

    public void displayPassengerDetails() {
        System.out.println("Passenger number :" + passengerNumber);
        System.out.println("Surname: " + surname);
        System.out.println("Initials: " + initials);
        System.out.println("Route: " + route);
        System.out.println("Date: " + date);
        System.out.printf("Ticket Amount: %.2f\n", ticketAmount);
        System.out.println("Status: " + status);
        System.out.println();
    }
}
