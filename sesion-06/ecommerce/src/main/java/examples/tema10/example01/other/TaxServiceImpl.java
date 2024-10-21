package examples.tema10.example01.other;

import examples.tema10.example01.model.Address;

import java.math.BigDecimal;

public class TaxServiceImpl implements TaxService {

    @Override
    public BigDecimal calculateNationalTax(Address address, BigDecimal total) {
        // Ejemplo de cálculo de impuestos nacionales (IVA)
        return total.multiply(BigDecimal.valueOf(0.20)); // 20% de impuestos nacionales
    }

    @Override
    public BigDecimal calculateInternationalTax(Address address, BigDecimal total) {
        // Ejemplo de cálculo de impuestos internacionales
        return total.multiply(BigDecimal.valueOf(0.10)); // 10% de impuestos internacionales
    }
}