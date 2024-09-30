package com.example.shop;

import com.example.shop.model.Payment;
import com.example.shop.model.Order;
import com.example.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Gestión de Productos
    public List<Product> getProducts() {
        String sql = "SELECT * FROM PRODUCTO";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("nombre"));
            product.setPrice(rs.getDouble("precio"));
            return product;
        });
    }

    public Product getProduct(Long id) {
        String sql = "SELECT * FROM PRODUCTO WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("nombre"));
            product.setPrice(rs.getDouble("precio"));
            return product;
        });
    }

    public Product addProduct(Product product) {
        String sql = "INSERT INTO PRODUCTO (nombre, precio) VALUES (?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
        return product;
    }

    public void deleteProduct(Long id) {
        String sql = "DELETE FROM PRODUCTO WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Gestión de Órdenes
    public List<Order> getOrders() {
        String sql = "SELECT * FROM ORDEN where id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setQuantity(rs.getInt("cantidad"));
            return order;
        });
    }


    public Order getOrder(Long id) {
        String sql = "SELECT * FROM ORDEN WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            var producto = getProduct(rs.getLong("producto_id"));
            order.setProduct(producto);
            order.setQuantity(rs.getInt("cantidad"));
            return order;
        });
    }

    public Order addOrder(Order order) throws Exception {
        int productInventory = getProductStock(order.getProduct().getId());
        if(order.getQuantity() > productInventory) {
            throw new Exception("No hay suficientes productos para establecer la orden");
        }
        String sql = "INSERT INTO ORDEN (producto_id, cantidad) VALUES (?, ?)";
        jdbcTemplate.update(sql, order.getProduct().getId(), order.getQuantity());
        return order;
    }

    public void deleteOrder(Long id) {
        String sql = "DELETE FROM ORDEN WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void addProductToInventory(Long productId, int quantity) {
        String sql = "UPDATE INVENTARIO SET cantidad = cantidad + ? WHERE producto_id = ?";
        jdbcTemplate.update(sql, quantity, productId);
    }

    public void reduceProductStock(Long productId, int quantity) {
        String sql = "UPDATE INVENTARIO SET cantidad = cantidad - ? WHERE producto_id = ?";
        jdbcTemplate.update(sql, quantity, productId);
    }

    public int getProductStock(Long productId) {
        String sql = "SELECT cantidad FROM INVENTARIO WHERE producto_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, Integer.class);
    }

    // Gestión de Pagos
    public List<Payment> getPayments() {
        String sql = "SELECT * FROM PAGO";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Payment payment = new Payment();
            payment.setId(rs.getLong("id"));
            var order = getOrder(rs.getLong("orden_id"));
            payment.setOrder(order);
            payment.setAmount(rs.getDouble("monto"));
            payment.setDiscount(rs.getString("descuento"));
            return payment;
        });
    }

    public Payment addPayment(Payment payment) {
        String sql = "INSERT INTO PAGO (orden_id, monto, descuento) VALUES (?, ?, ?)";
        var amount = priceWithDiscount(payment.getAmount(), payment.getDiscount());
        jdbcTemplate.update(sql, payment.getOrder().getId(), amount, payment.getDiscount());
        return payment;
    }

    public void deletePayment(Long id) {
        String sql = "DELETE FROM PAGO WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private double priceWithDiscount(double amount, String discount) {
        if(discount.equals("BLACK_FRIDAY")) {
            return amount * 0.9;
        } else if(discount.equals("CHRISTMAS")) {
            return amount * 0.7;
        } else {
            return amount;
        }
    }
}
