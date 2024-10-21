package examples.tema10.example01.domain_first;

import examples.tema10.example01.model.Customer;
import examples.tema10.example01.model.OrderItem;
import examples.tema10.example01.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InternationalOrder {
    private Long id;
    private LocalDate orderDate;
    private BigDecimal total;
    private BigDecimal internationalTax;
    private BigDecimal internationalShippingCost;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();

    private InternationalTaxService taxService;
    private InternationalShippingService shippingService;

    public InternationalOrder(Customer customer, InternationalTaxService taxService, InternationalShippingService shippingService) {
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
        this.internationalShippingCost = shippingService.calculateShipping(customer.getAddress());
        recalculateTotal();
    }

    public void calculateTax() {
        this.internationalTax = taxService.calculateTax(customer.getAddress(), total);
        recalculateTotal();
    }

    private void recalculateTotal() {
        total = items.stream()
                .map(OrderItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .add(internationalShippingCost)
                .add(internationalTax);
    }

    public BigDecimal getTotal() {
        return total;
    }
}

