package examples.tema10.example01.other;

import examples.tema10.example01.model.Customer;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderType; // 'NATIONAL', 'INTERNATIONAL', 'B2B', 'B2C'
    private BigDecimal total;
    private BigDecimal tax;
    private BigDecimal shippingCost;
    private String customerType; // 'CONSUMER', 'BUSINESS'

    @Transient
    private TaxService taxService;

    @Transient
    private ShippingService shippingService;

    public Order(String orderType, String customerType, TaxService taxService, ShippingService shippingService) {
        this.orderType = orderType;
        this.customerType = customerType;
        this.taxService = taxService;
        this.shippingService = shippingService;
    }

    public void calculateTotals(BigDecimal subtotal, Customer customer) {
        this.shippingCost = shippingService.calculateShipping(customer.getAddress());

        if ("NATIONAL".equals(orderType)) {
            this.tax = taxService.calculateNationalTax(customer.getAddress(), subtotal);
        } else if ("INTERNATIONAL".equals(orderType)) {
            this.tax = taxService.calculateInternationalTax(customer.getAddress(), subtotal);
        }

        recalculateTotal(subtotal);
    }

    private void recalculateTotal(BigDecimal subtotal) {
        this.total = subtotal.add(shippingCost).add(tax);
    }

    public void applyDiscounts(int numberOfItems) {
        if ("B2B".equals(orderType) && numberOfItems > 100) {
            // Aplicar descuento por volumen en B2B
            this.total = this.total.multiply(BigDecimal.valueOf(0.85)); // 15% de descuento
        }
    }

    // Método getTotal para acceder al total
    public BigDecimal getTotal() {
        return total;
    }
}
