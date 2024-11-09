import java.util.Scanner;
public class Program {
    static PassengerList passengerList = new PassengerList("UpdatedPassengerData.txt");
    static IndexList indexList = new IndexList();

    public static void main(String[] args) {
        populateIndexList();

        int choice;
        do {
            choice = displayOptions();

            switch (choice) {
                case 1:
                    addPassenger();
                    break;
                case 2:
                    deletePassenger();
                    break;
                case 3:
                    displayPassengerByNumber();
                    break;
                case 4:
                    displayPassengersByRoute();
                    break;
                case 5:
                    updateBooking();
                    break;
                case 6:
                    passengerList.display();
                    break;
                case 7:
                    indexList.displayIndexList();
                    break;
                case 8:
                    passengerList.writeData();
                    System.out.println("Passenger data saved to file.");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

        } while (choice != 9);
    }

    private static int displayOptions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1. Add a new Passenger");
        System.out.println("2. Delete a Passenger");
        System.out.println("3. Display Passenger by Number");
        System.out.println("4. Display Passengers by Route");
        System.out.println("5. Update a Passenger Booking");
        System.out.println("6. Display All Passengers");
        System.out.println("7. Display Index List");
        System.out.println("8. Save Passenger Data to File");
        System.out.println("9. Exit");

        System.out.print("Select an option: ");
        return scanner.nextInt();
    }

    private static void populateIndexList() {
        for (int i = 0; i < passengerList.count(); i++) {
            Passenger p = passengerList.get(i); // Adjusted for Java syntax
            if (p != null) {
                indexList.addIndex(new Index(p.getPassengerNumber(), i));
            }
        }
    }

    private static void addPassenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger number: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter initials: ");
        String initials = scanner.nextLine();
        System.out.print("Enter route: ");
        String route = scanner.nextLine();
        System.out.print("Enter date: ");
        String date = scanner.nextLine();
        System.out.print("Enter ticket amount: ");
        double ticketAmount = scanner.nextDouble();
        scanner.nextLine(); // Clear newline
        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        Passenger newPassenger = new Passenger(number, surname, initials, route, date, ticketAmount, status);
        passengerList.add(newPassenger);
        indexList.addIndex(new Index(number, passengerList.count() - 1));

        System.out.println("Passenger added successfully.");
    }

    private static void deletePassenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger number to delete: ");
        int number = scanner.nextInt();

        int indexPos = indexList.findPassenger(number);
        if (indexPos >= 0) {
            indexList.removeIndex(indexPos);
            passengerList.deletePassenger(number);
            System.out.println("Passenger deleted successfully.");
        } else {
            System.out.println("Passenger not found.");
        }
    }

    private static void displayPassengerByNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger number: ");
        int number = scanner.nextInt();

        int indexPos = indexList.findPassenger(number);
        if (indexPos >= 0) {
            Passenger passenger = passengerList.get(indexPos);
            if (passenger != null) {
                System.out.println("Passenger found:");
                passenger.displayPassengerDetails();
                System.out.println("Position in list: " + indexPos);
            }
        } else {
            System.out.println("Passenger not found.");
        }
    }

    private static void displayPassengersByRoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter route: ");
        String route = scanner.nextLine();
        passengerList.displayPassengersByRoute(route);
    }

    private static void updateBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        int indexPos = indexList.findPassenger(number);
        if (indexPos >= 0) {
            Passenger passenger = passengerList.get(indexPos);

            System.out.print("Enter new route: ");
            String newRoute = scanner.nextLine();
            System.out.print("Enter new date: ");
            String newDate = scanner.nextLine();
            System.out.print("Enter new ticket amount: ");
            double newTicketAmount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter new status: ");
            String newStatus = scanner.nextLine();

            passenger.updateBooking(newRoute, newDate, newTicketAmount, newStatus);
            System.out.println("Passenger booking updated successfully.");
        } else {
            System.out.println("Passenger not found.");
        }
    }
}
