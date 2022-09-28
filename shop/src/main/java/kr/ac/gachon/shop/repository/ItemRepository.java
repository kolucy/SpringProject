package kr.ac.gachon.shop.repository;

import kr.ac.gachon.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
