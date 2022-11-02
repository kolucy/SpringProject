package kr.ac.gachon.shop.repository;

import kr.ac.gachon.shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
