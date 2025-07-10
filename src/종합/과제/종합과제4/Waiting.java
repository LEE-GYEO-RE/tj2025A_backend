package 종합.과제.종합과제4;

public class Waiting {
    private String phone;
    private int count;

    public Waiting(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
