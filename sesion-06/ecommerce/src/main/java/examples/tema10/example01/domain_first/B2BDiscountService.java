package examples.tema10.example01.domain_first;

import java.math.BigDecimal;

public class B2BDiscountService {
    public BigDecimal calculateDiscount(BigDecimal total, int numberOfItems) {
        if (numberOfItems > 100) {
            return total.multiply(BigDecimal.valueOf(0.15)); // Descuento del 15% por volumen
        }
        return BigDecimal.ZERO;
    }
}
