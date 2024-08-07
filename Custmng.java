package anudip.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Customer {
    String customerID;
    String name;
    String email;

    public Customer(String customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + customerID + ", Name: " + name + ", Email: " + email;
    }
}

public class Custmng {
    List<Customer> customers;

    public Custmng() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(String customerID, String name, String email) {
        Customer newCustomer = new Customer(customerID, name, email);
        customers.add(newCustomer);
    }

    public void removeCustomer(String customerID) {
        customers.removeIf(customer -> customer.customerID.equals(customerID));
    }

    public Customer searchCustomer(String customerID) {
        for (Customer customer : customers) {
            if (customer.customerID.equals(customerID)) {
                return customer;
            }
        }
        return null;
    }

    public void listAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void sortCustomersByName() {
        Collections.sort(customers, Comparator.comparing(customer -> customer.name));
    }

    public void sortCustomersByID() {
        Collections.sort(customers, Comparator.comparing(customer -> customer.customerID));
    }

    public static void main(String[] args) {
        Custmng cms = new Custmng();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    String customerID = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = scanner.nextLine();
                    cms.addCustomer(customerID, name, email);
                    break;
                case 2:
                    System.out.print("Enter customer ID to remove: ");
                    customerID = scanner.nextLine();
                    cms.removeCustomer(customerID);
                    break;
                case 3:
                    System.out.print("Enter customer ID to search: ");
                    customerID = scanner.nextLine();
                    Customer customer = cms.searchCustomer(customerID);
                    if (customer != null) {
                        System.out.println(customer);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;
                case 4:
                    cms.listAllCustomers();
                    break;
                case 5:
                    cms.sortCustomersByName();
                    System.out.println("To check list is sorted");
                    cms.listAllCustomers();
                    break;
                case 6:
                    cms.sortCustomersByID();
                    System.out.println("To check list is sorted");
                    cms.listAllCustomers();
                    break;
               
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}