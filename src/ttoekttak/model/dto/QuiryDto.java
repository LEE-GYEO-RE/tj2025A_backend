package ttoekttak.model.dto;

public class QuiryDto {

    // 멤버변수
    private int qno;        // 문의글 번호
    private int pno;        // 물품 번호
    private String qtext;   // 문의글
    private String qid;     // 문의자 닉네임
    private String qpwd;    // 문의자 비밀번호
    private String q_date;  // 문의글 등록 일시

    // 기본 생성자
    public QuiryDto() {}

    // 전체 생성자
    public QuiryDto(int qno, int pno, String qtext, String qid, String qpwd, String q_date) {
        this.qno = qno;
        this.pno = pno;
        this.qtext = qtext;
        this.qid = qid;
        this.qpwd = qpwd;
        this.q_date = q_date;
    }

    // getter , setter 메소드

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getQtext() {
        return qtext;
    }

    public void setQtext(String qtext) {
        this.qtext = qtext;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getQpwd() {
        return qpwd;
    }

    public void setQpwd(String qpwd) {
        this.qpwd = qpwd;
    }

    public String getQ_date() {
        return q_date;
    }

    public void setQ_date(String q_date) {
        this.q_date = q_date;
    }

    // toString 메소드

    @Override
    public String toString() {
        return "QuiryDto{" +
                "qno=" + qno +
                ", pno=" + pno +
                ", qtext='" + qtext + '\'' +
                ", qid='" + qid + '\'' +
                ", qpwd='" + qpwd + '\'' +
                ", q_date='" + q_date + '\'' +
                '}';
    }
} // class e
