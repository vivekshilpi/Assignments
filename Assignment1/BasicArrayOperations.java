import java.util.Scanner;

public class BasicArrayOperations {

    static int n;
    static int arr[] = new int[100];

    // Insert element
    static void insert(Scanner sc) {
        if (n >= arr.length) {
            System.out.println("Array is full");
            return;
        }

        System.out.print("Enter position: ");
        int pos = sc.nextInt();

        System.out.print("Enter value: ");
        int val = sc.nextInt();

        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }

        arr[pos] = val;
        n++;
    }

    // Delete element
    static void delete(Scanner sc) {
        System.out.print("Enter position to delete: ");
        int pos = sc.nextInt();

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        n--;
    }

    // Linear search
    static void linearSearch(Scanner sc) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at position " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    // Binary search (array must be sorted)
    static void binarySearch(Scanner sc) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                System.out.println("Element found at position " + mid);
                return;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Element not found");
    }

    // Find maximum value
    static void findMax() {
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        System.out.println("Maximum value is: " + max);
    }

    // Count even and odd
    static void countEvenOdd() {
        int even = 0, odd = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even numbers: " + even);
        System.out.println("Odd numbers: " + odd);
    }

    // Insertion sort
    static void insertionSort() {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Array sorted using Insertion Sort");
    }

    // Display array
    static void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even and Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insert(sc); break;
                case 2: delete(sc); break;
                case 3: linearSearch(sc); break;
                case 4: binarySearch(sc); break;
                case 5: findMax(); break;
                case 6: countEvenOdd(); break;
                case 7: insertionSort(); break;
                case 8: display(); break;
                case 9: System.out.println("Program Ended"); break;
                default: System.out.println("Invalid choice");
            }

        } while (choice != 9);

        sc.close();
    }
}
