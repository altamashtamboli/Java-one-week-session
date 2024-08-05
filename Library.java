package anudip.com;
import java.util.Scanner;

public class Library 
{
    private String[] bookTitles;
    private int size;
    
    public Library(int initialCapacity) 
    {
        this.bookTitles = new String[initialCapacity];
        this.size = 0;
    }

    public void addBookTitle(String title) 
    {
        if (size < bookTitles.length) 
        {
            bookTitles[size] = title;
            size++;
            System.out.println("Added '" + title + "' to the list.");
        } 
        else 
        {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void removeBookTitle(String title) 
    {
        int index = findBookTitle(title);
        if (index != -1) 
        {
            for (int i = index; i < size - 1; i++) 
            {
                bookTitles[i] = bookTitles[i + 1];
            }
            size--;
            System.out.println("Removed '" + title + "' from the list.");
        }
        else 
        {
            System.out.println("'" + title + "' not found in the list.");
        }
    }

    public int searchBookTitle(String title) 
    {
        return findBookTitle(title);
    }

    private int findBookTitle(String title) 
    {
        for (int i = 0; i < size; i++) 
        {
            if (bookTitles[i].equals(title)) 
            {
                return i;
            }
        }
        return -1;
    }

    public void listAllBookTitles() 
    {
        System.out.println("Book Titles:");
        for (int i = 0; i < size; i++) 
        {
            System.out.println((i + 1) + ". " + bookTitles[i]);
        }
    }

    public void sortBookTitles() 
    {
        
        for (int i = 0; i < size - 1; i++) 
        {
            for (int j = 0; j < size - i - 1; j++) 
            {
                if (bookTitles[j].compareTo(bookTitles[j + 1]) > 0) 
                {
                    
                    String temp = bookTitles[j];
                    bookTitles[j] = bookTitles[j + 1];
                    bookTitles[j + 1] = temp;
                }
            }
        }
        System.out.println("Book titles sorted alphabetically.");
    }

    public static void main(String[] args) 
    {
        Library library = new Library(10);
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            
            System.out.println("1. Add Book Title");
            System.out.println("2. Remove Book Title");
            System.out.println("3. Search for Book Title");
            System.out.println("4. List All Book Titles");
            System.out.println("5. Sort Book Titles");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String title = scanner.nextLine();
                    library.addBookTitle(title);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    title = scanner.nextLine();
                    library.removeBookTitle(title);
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    int index = library.searchBookTitle(title);
                    if (index != -1) 
                    {
                        System.out.println("'" + title + "' found at index " + index + ".");
                    } 
                    else 
                    {
                        System.out.println("'" + title + "' not found.");
                    }
                    break;
                case 4:
                    library.listAllBookTitles();
                    break;
                case 5:
                    library.sortBookTitles();
                    break;
                case 6:
                    System.out.println("Exiting the library system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}