package Controllers;

import Domain.Sale;
import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CustumerController {

    private SalesRepository salesRepository;

    public CustumerController() throws FileNotFoundException {
        this.salesRepository = new SalesRepository();
    }

    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();
        for (Sale currentSale : this.salesRepository.getSalesList()) {
            if (!categories.contains(currentSale.getCategory())) {
                categories.add(currentSale.getCategory());
            }
        }
        return categories;
    }

    public ArrayList<Sale> getSalesList() {
        ArrayList<Sale> products = new ArrayList<>();
        ArrayList<String> productsDuplate = new ArrayList<>();
        for (Sale currentSale : this.salesRepository.getSalesList()) {
            if (!productsDuplate.contains(currentSale.getProduct())) {
                productsDuplate.add(currentSale.getProduct());
                products.add(currentSale);
            }
        }

        return products;
    }


}
