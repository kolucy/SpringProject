package kr.ac.gachon.shop.repository;

import kr.ac.gachon.shop.constant.ItemSellStatus;
import kr.ac.gachon.shop.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@SpringBootTest // 테스트 실행시 모든 Bean을 IoC 컨테이너에 등록 = 스프링부트 구동과 동일한 환경 조건
@TestPropertySource(locations="classpath:application-test.properties") // 테스트 실행시 우선되는 설정파일
class ItemRepositoryTest {
    @Autowired // 필드 Bean 주입
    ItemRepository itemRepository;

    @Test // Method 테스트 대상 지정
    @DisplayName("상품 저장 확인") // 테스트명
    public void createItemTest(){
        Item item = new Item();
        item.setItemNm("좋은 상품");
        item.setPrice(10000);
        item.setItemDetail("좋은 상품 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem = itemRepository.save(item);
        System.out.println(savedItem.toString());
    }

    public void createItemList(){
        for(int i=1; i<=10; i++){
            Item item = new Item();
            item.setItemNm("좋은 상품 " + i);
            item.setPrice(10000 + i);
            item.setItemDetail("좋은 상품 설명 " + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100); item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            itemRepository.save(item);
        }
    }

    @Test
    @DisplayName("상품명 조회 확인")
    public void findByItemNmTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNm("좋은 상품 7");
        for(Item item : itemList){
            LOGGER.info(item.toString());
        }
    }

    @Test
    @DisplayName("상품명 or 상품 설명 확인")
    public void findByItemNmOrItemDetailTest(){
        this.createItemList(); // 리스트 넣어준다
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("좋은 상품 1", "좋은 상품 설명 5"); // 추상메소드 itemRepository
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThan 확인")
    public void findByPriceLessThanTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByPriceLessThan(10005); // price 변수 값이 10005 미만인 상품만 검색
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 확인")
    public void findByPriceLessThanOrderByPriceDesc(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10006); // price 변수 가격이 10006 미만인 상품만 후 내림차순 정렬
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThanEqual 확인")
    public void findByPriceLessThanEqual(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByPriceLessThanEqual(10006);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("가격 IsBetween 확인")
    public void findByPriceIsBetween(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByPriceIsBetween(10002, 10005);
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 확인")
    public void findByItemDetailTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemDetail("좋은 상품");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 확인 NATIVE")
    public void findByItemDetailByNativeTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemDetailByNative("좋은 상품");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }
}