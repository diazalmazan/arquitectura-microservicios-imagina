package examples.tema10.example01.domain_first;

import examples.tema10.example01.model.Address;

import java.math.BigDecimal;

public class NationalTaxService implements TaxService {
    @Override
    public BigDecimal calculateTax(Address address, BigDecimal total) {
        return total.multiply(BigDecimal.valueOf(0.20)); // 20% de impuestos nacionales
    }
}
