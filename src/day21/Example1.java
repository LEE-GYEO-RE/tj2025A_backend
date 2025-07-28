package day21;

import javax.tools.Tool;
import java.awt.*;

class 작업스레드2 extends Thread{
    // extends : 클래스 타입을 물려받는 키워드
    // Thread : 멀티스레드 클래스


    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i = 1; i <=5; i++){
            toolkit.beep();
            try{
                Thread.sleep(1000);
            }catch (Exception e ){ }
        }
    }
}// class e

class 작업스레드1 implements Runnable{
    // implements : 인터페이스 타입 구현 키워드
    // Runnable : 멀티스레드 인터페이스

    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i =1; i<=5; i++){
            toolkit.beep();
            try {Thread.sleep( 1000 );}
            catch (Exception e ){}
        }
    }
} // class e

public class Example1 {
    public static void main(String[] args) {

        /*
        - 프로그램 : 코드(명령어)들의 집합
        - 프로세스 : 실행중인 프로그램
        - 멀티 태스킹 : **두가지 이상의 작업을 동시** 처리
        - 멀티 프로세스 : 운영체제가 동시에 여러개 프로세스 동시 처리
            -> 프로그램 단위의 *멀티 태스킹*
        - 멀티 스레드 : 프로세스 내에서 실행되는 작업 처리
            -> 하나의 프로그램 내 *멀티 태스킹*

        [ 스레드 Thread ]
            1. 정의 : 하나의 프로세스 내에서 실행되는 작업 단위 , 실행 흐름의 단위
            2. 목적 : 코드(명렁어)를 읽어들이고 CPU가 명령어를 처리한다.
            3. 자바 에서의 스레드
                1) main 메소드 : public static void main ( String[] args ){} 에는 main 스레드가 내장됨.
            4. 사용법
                1) 자바 프로그램은 항상 main메소드(Thread)로 부터 실행 흐름이 시작된다.
                - public static void main ( String[] args ){}

        [ 멀티스레드 Multi-Thread ]
            1. 정의 : main스레드 외 새로운 *작업스레드*를 생성하여 동시 작업
            2. 목적 : *병렬 처리* , 동시에 여러 작업을 수행
            3. 사용처 : 웹/앱 , 채팅/첨부파일/JDBC , 동기화/비동기화 처리
            4. 사용법
            - 단일(싱글) : 1차선 도로 --> CRUD
            - 병렬(멀티) : 다차선 도로 --> CRUD 외적인 것들
                (1) 익명 구현체
                    Thread thread = new Thread(
                        new Runnable(){ @Override public void run(){
                                // 작업스레드가 처리할 코드
                                // 동시처리 하고 싶은 아무거나 쓰면 됨.
                            }
                        });
                        thread.start();

                (2) 구현체
                    class 작업클래스 implements Runnable(){
                        @Override public void run(){
                                // 작업스레드가 처리할 코드
                        }
                    };
                    -----
                    Thread thread = new Thread( new 작업클래스() );
                    thread.start();

                (3) 상속 , 상속은 클래스당 1번 , *구현은 클래스당 여러번*
                    class 작업클래스 extends Thread{
                        @Override public void run(){
                            // 작업스레드가 처리할 코드
                        }
                    }
                    -------
                    작업클래스 thread = new Thread();
                    thread.start();

            5. 주요 클래스/인터페이스
                (1) Thread 클래스
                    1) start 메소드 : 구현된 run메소드를 실행 메소드
                (2) Runnable 인터페이스
                    1) run 추상메소드 : 작업스레드가 실행하는 최초 시작점 처리 메소드


        */

        Toolkit toolkit = Toolkit.getDefaultToolkit();  // java ui 제공하는 패키지 ( java.awt )

        // [1] 단일(싱글) 스레스 예시 : 위에서 아래 순으로 실행 : 소리 따로 , 출력 따로

        // 1) 출력 5번
        System.out.println("[1] MAIN 스레드가 읽어들이는 코드");   // main메소드가 처리하는 코드
        for( int i = 1; i<=5 ; i++){
            System.out.println("[1] MAIN 스레드가 읽어들이는 코드"+i);
        } // for e

        // 2) 소리 5번
        for( int i = 1; i<=5; i++){
            System.out.println("[1] 띵 소리");
            toolkit.beep(); // '띵' 소리 제공하는 메소드 ( 띵 하는 도중에 반복문 종료된다.)
            try { Thread.sleep(1000);}   // Thread.sleep( 밀리초 ) : 현재 스레드를 밀리초 만큼 일시정지 *예외처리 해야함
            catch (Exception e ){ }
        } // for e

        // [2] 멀티 스레드 예시 : 출력과 소리를 동시에 처리
        // 익명 구현체 : 인터페이스 타입을 클래스 없이 직접 구현

        // 1) 출력 5번
        System.out.println("[1] MAIN 스레드가 읽어들이는 코드");   // main메소드가 처리하는 코드
        for( int i = 1; i<=5 ; i++){
            System.out.println("[1] MAIN 스레드가 읽어들이는 코드"+i);
            try{Thread.sleep(1000);}
            catch (Exception e ){ }
        } // for e

        // 2) 소리 5번 : 익명 구현체 , new 인터페이스타입(){ 추상메소드 구현; };
        Runnable runnable1 = new Runnable( ){
            // run 추상메소드 구현 // 오버라이딩 // 재정의

            @Override
            public void run() {
                for( int i = 1; i<= 5; i++){
                    toolkit.beep();
                    try{ Thread.sleep( 1000 );}
                    catch (Exception e ){}
                }
            }
        };
        Thread thread1 = new Thread( runnable1 );   // run 구현한 runnable 타입을 Thread 생성자에 대입
        thread1.start();    // run 구현된 runnable 타입을 갖는 thread 객체가 작업 스레드 .start() 실행


        // [3] 멀티 스레드 예시2 : 구현체
        // 1) 소리 5번
        작업스레드1 작업스레드1 = new 작업스레드1();   // 구현체 생성
        Thread thread2 = new Thread(작업스레드1);  // 구현체를 Thread 객체에 대입
        thread2.start();    // 구현체를 갖는 Thread 객체가 start


        // 2) 출력 5번
        System.out.println("[1] MAIN 스레드가 읽어들이는 코드");   // main메소드가 처리하는 코드
        for( int i = 1; i<=5 ; i++){
            System.out.println("[1] MAIN 스레드가 읽어들이는 코드"+i);
            try{Thread.sleep(1000);}
            catch (Exception e ){ }
        } // for e

        // [4] 멀티 스레드 예시3 : 상속

        // 1) 소리 5번
        작업스레드2 thread3 = new 작업스레드2();
        thread3.start();

        // 2) 출력 5번
        System.out.println("[1] MAIN 스레드가 읽어들이는 코드");   // main메소드가 처리하는 코드
        for( int i = 1; i<=5 ; i++){
            System.out.println("[1] MAIN 스레드가 읽어들이는 코드"+i);
            try{Thread.sleep(1000);}
            catch (Exception e ){ }
        } // for e


    } // main e
} // class e
































































