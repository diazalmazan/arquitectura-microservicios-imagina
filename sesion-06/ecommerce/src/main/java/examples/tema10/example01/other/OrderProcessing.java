package examples.tema10.example01.other;

import examples.tema10.example01.model.Address;
import examples.tema10.example01.model.Customer;
import examples.tema10.example01.model.Product;

import java.math.BigDecimal;

public class OrderProcessing {
    public static void main(String[] args) {
        // Instanciar servicios de impuestos y envío
        TaxService taxService = new TaxServiceImpl();
        ShippingService shippingService = new ShippingServiceImpl();

        // Crear cliente y productos
        Customer customer = new Customer("John Doe", new Address("123 Main St", "USA"));
        Product product1 = new Product("Laptop", BigDecimal.valueOf(1000));
        Product product2 = new Product("Mouse", BigDecimal.valueOf(50));

        // Crear orden nacional B2B
        Order order = new Order("NATIONAL", "BUSINESS", taxService, shippingService);

        // Añadir productos a la orden
        order.calculateTotals(BigDecimal.valueOf(1050), customer);
        order.applyDiscounts(150); // Descuento por volumen aplicado

        System.out.println("Total con impuestos y envío: " + order.getTotal());
    }
}