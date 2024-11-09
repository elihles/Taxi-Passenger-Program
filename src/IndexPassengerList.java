import java.util.ArrayList;

public class IndexPassengerList {
    private ArrayList<Index> indexList;  // ArrayList to store Index objects

    // Constructor to initialize the IndexList
    public IndexPassengerList() {
        indexList = new ArrayList<>();
    }

    // Add an Index object in the correct sorted position
    public void addIndex(Index newIndex) {
        // Insert the new index in the correct position (ascending order by passenger number)
        int i = 0;
        while (i < indexList.size() && indexList.get(i).getPassengerNumber() < newIndex.getPassengerNumber()) {
            i++;
        }
        indexList.add(i, newIndex);
    }

    public void removeIndex(int position) {
        if (position >= 0 && position < indexList.size()) {
            indexList.remove(position); // Remove the item at the specified index

            // Adjust the indices of all remaining elements in the list if necessary
            for (int i = position; i < indexList.size(); i++) {
                indexList.get(i).setPosition(i);  // Assuming Index objects store their position
            }
        } else {
            System.out.println("Cannot remove index: invalid position.");
        }
    }

    // Bubble Sort - Initial Sort by Passenger number
    public void bubbleSort() {
        int n = indexList.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                Index current = indexList.get(i);
                Index next = indexList.get(i + 1);

                // Compare passenger numbers
                if (current.getPassengerNumber() > next.getPassengerNumber()) {
                    // Swap the two elements
                    indexList.set(i, next);
                    indexList.set(i + 1, current);
                    swapped = true;
                }
            }
            n--;  // Reduce the range of comparison
        } while (swapped);
    }

    public int findPassenger(int passengerNumber) {
        for (int i = 0; i < indexList.size(); i++) {
            Index index = indexList.get(i);
            if (index.getPassengerNumber() == passengerNumber) {
                return i;  // Return the index position
            }
        }
        return -1;  // Passenger not found
    }

    // Binary search for a passenger number
    public Index binarySearch(int passengerNumber) {
        int left = 0;
        int right = indexList.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Index midIndex = indexList.get(mid);

            if (midIndex.getPassengerNumber() == passengerNumber) {
                return midIndex;  // Passenger found
            } else if (midIndex.getPassengerNumber() < passengerNumber) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1;  // Search in the left half
            }
        }

        return null;  // Passenger not found
    }

    // Method to display the entire IndexList
    public void displayIndexList() {
        System.out.println("Index List (Passenger Number and Position):");
        for (Index index : indexList) {
            index.displayIndexDetails();
        }
    }
}
