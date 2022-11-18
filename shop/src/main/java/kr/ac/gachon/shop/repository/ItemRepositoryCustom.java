package kr.ac.gachon.shop.repository;

import kr.ac.gachon.shop.dto.ItemSearchDto;
import kr.ac.gachon.shop.dto.MainItemDto;
import kr.ac.gachon.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
