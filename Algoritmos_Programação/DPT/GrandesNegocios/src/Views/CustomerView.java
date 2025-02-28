package Views;

import Controllers.CustumerController;
import Domain.Sale;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerView {

    CustumerController custumerController;

    public CustomerView() throws FileNotFoundException {
        this.custumerController = new CustumerController();
    }

    public void customerMenu() {

        Scanner input = new Scanner(System.in);
        int menuOption;

        do {
            System.out.println("\nHello! Nice to see you. \uD83D\uDED2");
            System.out.println("1. Available Products");
            System.out.println("2. Products by Category");
            System.out.println("3. Most Expensive/Cheapest Product");
            System.out.println("0. Exit \uD83C\uDFC3\uD83D\uDEAA");
            System.out.print("Choose: ");

            menuOption = input.nextInt();

            switch (menuOption) {
                case 1: // Available Products
                    break;

                case 2: // Products by Category
                    CategoriesList();
                    break;

                case 3: // Most Expensive/Cheapest Product
                    break;

                case 0: // Exit
                    break;

                default: // Invalid Option
                    System.out.println("\uD83D\uDEA8 Invalid Option \uD83D\uDEA8");
            }

        } while (menuOption != 0);
    }

    private void CategoriesList() {
        Scanner input = new Scanner(System.in);

        // Show a list of all categories
        ArrayList<String> categories = this.custumerController.getCategories();
        System.out.println("\n** Select one category ***");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(i + 1 + "- " + categories.get(i));
        }
        System.out.print("Choose: ");
        int index = input.nextInt();

        for (Sale currectSale : this.custumerController.getSalesList()) {
            if (currectSale.getCategory().equals(categories.get(index-1))) {
                System.out.println("- " + currectSale.getProduct());
            }
        }
    }
}
