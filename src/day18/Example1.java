package day18;

public class Example1 {
    public static void main(String[] args) {

        // (1) DB연동 확인
        UserDao userDao = UserDao.getInstance();

        // (2) 연동된 DB에 메소드 실행
        userDao.userInsert();

        // (3) 연동된 DB에 매개변수 메소드 실행
        userDao.userInsert2( "강호동" , 30 );
        userDao.userInsert2( "신동엽" , 25 );

        // (4) 연동된 DB에 select 메소드 실행
        userDao.userSelect();

    } // main e
} // class e
