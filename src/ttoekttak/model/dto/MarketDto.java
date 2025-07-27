package ttoekttak.model.dto;

public class MarketDto {

    // 멤버변수
    private int pno;            // 물품 번호
    private String pname;       // 물품명
    private String ptext;       // 물품 설명
    private int pprice;         // 물품 가격
    private String sellId;      // 판매자 닉네임
    private String sellpwd;     // 판매자 비밀번호
    private String pstate;      // 판매여부
    private String add_date;    // 등록 일시
    private int pcount;      // 등록수

    // 기본 생성자
    public MarketDto() { }

    // 전체 생성자

    public MarketDto(int pno, String pname, String ptext, int pprice, String sellId, String sellpwd, String pstate, String add_date) {
        this.pno = pno;
        this.pname = pname;
        this.ptext = ptext;
        this.pprice = pprice;
        this.sellId = sellId;
        this.sellpwd = sellpwd;
        this.pstate = pstate;
        this.add_date = add_date;
    }

    // getter , setter  메소드

    public int getPcount() {
        return pcount;
    }

    public void setPcount(int pcount) {
        this.pcount = pcount;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtext() {
        return ptext;
    }

    public void setPtext(String ptext) {
        this.ptext = ptext;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getSellpwd() {
        return sellpwd;
    }

    public void setSellpwd(String sellpwd) {
        this.sellpwd = sellpwd;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    // toString 메소드
    @Override
    public String toString() {
        return "MarketDto{" +
                "pno=" + pno +
                ", pname='" + pname + '\'' +
                ", ptext='" + ptext + '\'' +
                ", pprice=" + pprice +
                ", sellId='" + sellId + '\'' +
                ", sellpwd='" + sellpwd + '\'' +
                ", pstate='" + pstate + '\'' +
                ", add_date='" + add_date + '\'' +
                '}';
    }
} // class e
