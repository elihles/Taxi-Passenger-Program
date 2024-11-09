public class Index {
    // Private fields
    private int passengerNumber;
    private int position;

    // Constructor
    public Index(int passengerNumber, int position) {
        this.passengerNumber = passengerNumber;
        this.position = position;
    }

    // Getter and Setter for Passenger Number
    public int getPassengerNumber() {
        return passengerNumber;
    }
    public void setPassengerNumber(int value) {
        this.passengerNumber = value;
    }

    // Getter and Setter for Position
    public int getPosition() {
        return position;
    }
    public void setPosition(int value) {
        this.position = value;
    }

    // Method to display index details
    public void displayIndexDetails() {
        System.out.println("Passenger Number: " + passengerNumber);
        System.out.println("Position in List : " + position);
    }
}
