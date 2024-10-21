package examples.tema10.example01.other;

import examples.tema10.example01.model.Address;

import java.math.BigDecimal;

public class ShippingServiceImpl implements ShippingService {

    @Override
    public BigDecimal calculateShipping(Address address) {
        // Ejemplo de cálculo de costo de envío
        if ("USA".equals(address.getCountry())) {
            return BigDecimal.valueOf(15.00); // Envío nacional a Estados Unidos
        } else {
            return BigDecimal.valueOf(30.00); // Envío internacional
        }
    }
}