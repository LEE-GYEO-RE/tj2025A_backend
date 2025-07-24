package ttoekttak.model.dto;

import java.util.List;

public class ProductDetailDto {

    // 멤버변수
    private MarketDto productInfo;
    private List<QuiryDto> quiryList;
    // MarketDto는 dto 타입 , QuiryDto는 List<> 타입
    // 이유는? 하나의 물품에 여러개의 문의글을 호출하기 위해서.
    // dto에서 가져올 때 하나의 물품의 정보를 가져오고 여러개의 문의글을 가져오는 것.

    // 기본 생성자
    public ProductDetailDto() {}

    // 전체 생성자
    public ProductDetailDto(MarketDto productInfo, List<QuiryDto> quiryList) {
        this.productInfo = productInfo;
        this.quiryList = quiryList;
    }

    // getter , setter 메소드
    public MarketDto getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(MarketDto productInfo) {
        this.productInfo = productInfo;
    }

    public List<QuiryDto> getQuiryList() {
        return quiryList;
    }

    public void setQuiryList(List<QuiryDto> quiryList) {
        this.quiryList = quiryList;
    }

    // toString 메소드
    @Override
    public String toString() {
        return "ProductDetailDto{" +
                "productInfo=" + productInfo +
                ", quiryList=" + quiryList +
                '}';
    }
}
