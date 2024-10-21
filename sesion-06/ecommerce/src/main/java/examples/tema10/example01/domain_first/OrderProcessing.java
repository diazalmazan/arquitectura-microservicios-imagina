package examples.tema10.example01.domain_first;

import examples.tema10.example01.model.Address;
import examples.tema10.example01.model.Customer;
import examples.tema10.example01.model.Product;

import java.math.BigDecimal;

public class OrderProcessing {
    public static void main(String[] args) {
        // Crear los servicios de impuestos y envío
        NationalTaxService nationalTaxService = new NationalTaxService();
        NationalShippingService nationalShippingService = new NationalShippingService();
        InternationalTaxService internationalTaxService = new InternationalTaxService();
        InternationalShippingService internationalShippingService = new InternationalShippingService();

        // Crear un cliente y productos
        Customer customer = new Customer("John Doe", new Address("123 Main St", "USA"));
        Product product1 = new Product("Laptop", BigDecimal.valueOf(1000));
        Product product2 = new Product("Mouse", BigDecimal.valueOf(50));

        // Crear una orden nacional
        NationalOrder nationalOrder = new NationalOrder(customer, nationalTaxService, nationalShippingService);
        nationalOrder.addItem(product1, 1);
        nationalOrder.addItem(product2, 2);
        nationalOrder.calculateShipping();
        nationalOrder.calculateTax();

        System.out.println("Total nacional: " + nationalOrder.getTotal());

        // Crear una orden internacional
        InternationalOrder internationalOrder = new InternationalOrder(customer, internationalTaxService, internationalShippingService);
        internationalOrder.addItem(product1, 1);
        internationalOrder.addItem(product2, 2);
        internationalOrder.calculateShipping();
        internationalOrder.calculateTax();

        System.out.println("Total internacional: " + internationalOrder.getTotal());
    }
}

