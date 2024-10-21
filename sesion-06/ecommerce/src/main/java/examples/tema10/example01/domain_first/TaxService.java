package examples.tema10.example01.domain_first;

import examples.tema10.example01.model.Address;

import java.math.BigDecimal;

public interface TaxService {
    BigDecimal calculateTax(Address address, BigDecimal total);
}
