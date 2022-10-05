package kr.ac.gachon.shop.repository;

import kr.ac.gachon.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemNm(String itemNm); // find+(Entity명)+By+(변수명)으로 메소드 생성. Entity명 제거할 수 있음
    // List<Item> findItemByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price); // 입력된 price 미만 값 확인

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price); // 입력된 price 미만 값 확인 및 price 값 기준 정렬

    List<Item> findByPriceLessThanEqual(Integer price); // 입력된 price 이하 값 확인

    List<Item> findByPriceIsBetween(Integer priceMin, Integer priceMax); // 입력된 price 사이 값 확인

    @Query("select i from Item i where i.itemDetail like " +
            "%:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail); // 직접 Query를 입력하여 값 확인 JPQL

    @Query(value="select * from item i where i.item_detail like " +
            "%:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail); // 직접 Query를 입력하여 값 확인 MySQL
}
