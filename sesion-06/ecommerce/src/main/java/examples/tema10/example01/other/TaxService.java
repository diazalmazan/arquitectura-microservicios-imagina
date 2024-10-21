package examples.tema10.example01.other;

import examples.tema10.example01.model.Address;

import java.math.BigDecimal;

public interface TaxService {
    BigDecimal calculateNationalTax(Address address, BigDecimal total);
    BigDecimal calculateInternationalTax(Address address, BigDecimal total);
}
