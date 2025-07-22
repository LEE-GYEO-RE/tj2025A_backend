package day17.DB연동예제.model.dto;

public class WaitingDto {

    // 멤버변수
    String phone;
    int count;

    // 기본 생성자
    public WaitingDto() {
    }

    // 전체 생성자
    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    // getter , setter , toString 메소드


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

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
} // class e
