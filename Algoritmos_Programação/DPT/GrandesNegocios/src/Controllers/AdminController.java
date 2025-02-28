package Controllers;

import Domain.Sale;
import Model.SalesRepository;

import java.io.FileNotFoundException;

public class AdminController {

    private SalesRepository salesRepository;

    public AdminController() throws FileNotFoundException {
        this.salesRepository = new SalesRepository();
    }

    public double getTotalSales() {
        double totalSales = 0;

        for (Sale currentSale : this.salesRepository.getSalesList()) {
            totalSales += currentSale.getUnitsSold() * currentSale.getUnitPrice();
        }

        return totalSales;
    }

    public Sale getBestSaleUnit(){
        Sale bestSale = null;
        double unit = 0;

        for (Sale currentSale : this.salesRepository.getSalesList()) {
            if (currentSale.getUnitsSold() > unit) {
                unit = currentSale.getUnitsSold();
                bestSale = currentSale;
            }
        }
        return bestSale;
    }
}
