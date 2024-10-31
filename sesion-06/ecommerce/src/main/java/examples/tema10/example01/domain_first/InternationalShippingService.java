package examples.tema10.example01.domain_first;

import examples.tema10.example01.model.Address;

import java.math.BigDecimal;

public class InternationalShippingService implements ShippingService {
    @Override
    public BigDecimal calculateShipping(Address address) {
        return BigDecimal.valueOf(30.00); // Envío internacional
    }
}
