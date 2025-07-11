package 종합.과제.종합과제5.model.dto;

public class WaitingDto {

    // 멤버변수
    private String phone;
    private int count;

    // 기본 생성자
    public WaitingDto(){}

    // 멤버변수 초기화 생성자
    public WaitingDto(String phone , int count){
        this.phone = phone;
        this.count = count;
    }
    // getter / setter 메소드

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // toString 메소드
    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

}
