package com.example.shop_solved.repository;

import com.example.shop_solved.model.Inventory;
import com.example.tema_01_final.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByProductId(Long productId);
}
