package examples.tema10.example01.other;

import examples.tema10.example01.model.Address;

import java.math.BigDecimal;

public interface ShippingService {
    BigDecimal calculateShipping(Address address);
}