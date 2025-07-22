package 종합.과제.종합과제7.model.dto;

public class WaitingDto {
    // 멤버변수
    private String phone;
    private String count;

    // 기본 생성자
    public WaitingDto() {
    }

    // 전체 생성자

    public WaitingDto(String phone, String count) {
        this.phone = phone;
        this.count = count;
    }

    // getter setter toString 메소드

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
} // class e
