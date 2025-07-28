package day21;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example4 {
    public static void main(String[] args) {

        /*
        [ 스레드풀 ]
            1. 정의 : 미리 일정 개수의 스레드를 생성하고 필요에 따라 재사용하는 방식
            2. 목적 : 작업이 들어올때 마다 새로운 스레드가 아닌 기존 스레드 이용한다.
            3. 효과 : 스레드 재사용 , 자원 효율성 , 과부하 방지 등등
            4. 구조 : 작업의 요청을 '큐'라는 자료구조로 배치하여 순서대로 스레드풀에서 대기중인 스레드에게 작업을 배정
                * 큐? 란 : 자료의 데이터들을 요청 순서대로 처리 방법
                -----------------------------------
                input [요청3] [요청2] [요청1]  output
                -----------------------------------
            5. 생활속 예시 : 콜센터 , 유재석이 콜센터에 전화하면 대기중인 직원1(스레드)가 존재하면 처리한다. 아니면 대기
                                    스레드 풀
                                        직원1(스레드)
                콜 요청 ---------        직원2(스레드)
                                        직원3(스레드)
            6. 사용처 : 1)톰캣[자바웹클래스]   2)JDBC  3)업로드/다운로드  4)채팅
            7. 사용법

        */

        // [1] 작업스레드를 배정하기 , 스레드풀(여러개 스레드가 들어있는 곳)
        // ExecutorService executorService = Executors.newFixedThreadPool( 스레드풀에 저장할 스레드 수);
        ExecutorService executorService = Executors.newFixedThreadPool( 3 );

        // [2] 반복문을 이용하여 각각 3개 스레드를 생성하여 스레드풀에 넣어주기
        for( int i = 1; i<= 100; i++){
            // 스레드 풀에 저장할 스레드 개수 3개로 지정했으니깐 , i가 100개든 1000개든 3개씩 실행 => 직원 3명이니깐 콜 요청 몇개가 있든 3명씩 돌아감
            String name = "Thread" + i;
            // [3] 스레드 생성 , 익명 구현체
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try{Thread.sleep(2000);}
                    catch (Exception e ){}
                    System.out.println("Task Thread ? : " + name );
                } // run e
            }; // 익명구현체 e
            // [4] 생성된 스레드를 스레드풀에 넣어주기/등록한다 (배정)
            executorService.submit( runnable );
            // ----------------> 순서를 정할 수 없음. 대기 중인 스레드 먼저 운영체제가 알아서 배정해주는 느낌
            //  "스레드를 미리 만들어놓고, 필요할 때만 꺼내서 쓰는 방식"

        } // for e

        // [5] 스레드풀 전체 종료
        executorService.shutdown();

    } // main e
} // class e





































