package examples.tema10.example01.domain_first;

import examples.tema10.example01.model.Customer;
import examples.tema10.example01.model.OrderItem;
import examples.tema10.example01.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NationalOrder {
    private Long id;
    private LocalDate orderDate;
    private BigDecimal total;
    private BigDecimal tax;
    private BigDecimal shippingCost;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();

    private NationalTaxService taxService;
    private NationalShippingService shippingService;

    public NationalOrder(Customer customer, NationalTaxService taxService, NationalShippingService shippingService) {
        this.customer = customer;
        this.taxService = taxService;
        this.shippingService = shippingService;
        this.orderDate = LocalDate.now();
    }

    public void addItem(Product product, int quantity) {
        OrderItem item = new OrderItem(product, quantity);
        items.add(item);
        recalculateTotal();
    }

    public void calculateShipping() {
        this.shippingCost = shippingService.calculateShipping(customer.getAddress());
        recalculateTotal();
    }

    public void calculateTax() {
        this.tax = taxService.calculateTax(customer.getAddress(), total);
        recalculateTotal();
    }

    private void recalculateTotal() {
        total = items.stream()
                .map(OrderItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .add(shippingCost)
                .add(tax);
    }

    public BigDecimal getTotal() {
        return total;
    }
}
