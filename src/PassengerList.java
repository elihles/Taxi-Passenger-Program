import java.io.*;
import java.util.ArrayList;

public class PassengerList {
    private ArrayList<Passenger> list;       // Holds original order of passengers
    private ArrayList<Integer> indexList;    // Holds indexes of passengers for sorting and searching
    private String filename;
    private boolean sorted = false;
    private int sortedState;

    public PassengerList(String file) {
        filename = file;
        list = new ArrayList<>();
        indexList = new ArrayList<>();
        readData();
        populateIndexList();
    }

    private void close() {
        writeData();
    }

    // Add a new passenger, appending to the end of the list and updating the index list
    public void add(Passenger newPassenger) {
        list.add(newPassenger);
        indexList.add(list.size() - 1);  // Add index of new passenger to indexList
        sortedState = 0;  // Not sorted
    }

    // Populate the indexList from the original list after reading from the file
    public void populateIndexList() {
        indexList.clear(); // Clear existing index list before repopulating
        for (int i = 0; i < list.size(); i++) {
            indexList.add(i);  // Store index positions of each passenger
        }
    }

    public int count() {
        return list.size();
    }

    // Get method to retrieve a Passenger by index
    public Passenger get(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index is out of range.");
        }
        return list.get(index);
    }

    // Display passengers using indexList to maintain original order
    public void display() {
        for (int index : indexList) {
            if (index >= 0 && index < list.size()) {
                Passenger currentPassenger = list.get(index);
                currentPassenger.displayPassengerDetails();
            } else {
                System.out.println("Invalid index: " + index);
            }
        }
    }

    public void displayPassengersByRoute(String wantedRoute) {
        boolean found = false;
        for (int index : indexList) {
            Passenger cur = list.get(index);

            if (cur.getRoute().equals(wantedRoute)) {
                cur.displayPassengerDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No passengers found for the route: " + wantedRoute);
        }
    }

    // Delete a Passenger by number
    public void deletePassenger(int passengerNumber) {
        for (int i = 0; i < list.size(); i++) {
            Passenger passenger = list.get(i);
            if (passenger.getPassengerNumber() == passengerNumber) {
                list.remove(i);
                populateIndexList(); // Update indexList after deletion
                System.out.println("Passenger " + passengerNumber + " deleted successfully.");
                return;
            }
        }
        System.out.println("Passenger not found.");
    }

    public int findPassenger(int wanted) {
        // Adjusted to search using int
        for (int i = 0; i < indexList.size(); i++) {
            Passenger currentPassenger = list.get(indexList.get(i));
            if (currentPassenger.getPassengerNumber() == wanted) {
                return i;
            }
        }
        return -1; // Not found
    }

    public void readData() {
        final String DELIM = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(DELIM);
                int passengerNum = Integer.parseInt(fields[0]);
                String surname = fields[1];
                String initials = fields[2];
                String route = fields[3];
                String date = fields[4];
                double ticketAmount = Double.parseDouble(fields[5]);
                String status = fields[6];

                Passenger newPassenger = new Passenger(passengerNum, surname, initials, route, date, ticketAmount, status);
                list.add(newPassenger);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void writeData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("OutputPassengerData.txt"))) {
            for (Passenger tempPassenger : list) {
                pw.print(tempPassenger.getPassengerNumber() + ",");
                pw.print(tempPassenger.getSurname() + ",");
                pw.print(tempPassenger.getInitials() + ",");
                pw.print(tempPassenger.getRoute() + ",");
                pw.print(tempPassenger.getDate() + ",");
                pw.print(tempPassenger.getTicketAmount() + ",");
                pw.println(tempPassenger.getStatus());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void saveToFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Passenger tempPassenger : list) {
                pw.print(tempPassenger.getPassengerNumber() + ",");
                pw.print(tempPassenger.getSurname() + ",");
                pw.print(tempPassenger.getInitials() + ",");
                pw.print(tempPassenger.getRoute() + ",");
                pw.print(tempPassenger.getDate() + ",");
                pw.print(tempPassenger.getTicketAmount() + ",");
                pw.println(tempPassenger.getStatus());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
