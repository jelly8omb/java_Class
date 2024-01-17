package io.day14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadTest {
     public static void main(String[] args) {
        

        //실행 시간이 오래 걸릴 경우 실행 중이라는 표시를 사용자에게 보여줍니다.
        //          ㄴ 1초마다 . 출력하기 => 쓰레드로 만듭니다.
        Runnable runnable = new Runnable() {
            
            @Override
            public void run(){  //쓰레드가 할일을 여기에 코딩
                boolean run = true;
                while (run) {
                    System.out.print(".");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        run = false;
                    }
                    //Interrupt : 방해하다, 간섭하다, 끼어들다
                }
            }
        };
        //쓰레드 생성하기. 할 일은 생성자 인자로 전달.
        Thread thread = new Thread(runnable);
        //쓰레드 실행하기.
        thread.start();

        //System에서 시간을 측정할수 있는 메소드 : 나노세컨드 10억분의 1, ms 1000분의 1
        long start = System.nanoTime();
        //처리할 메소드
        copyByByte();
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));

        //4. 쓰레드 종료를 위해 인터럽트 발생하기
        //thread.stop(); 추천하지않음. 소멸된 메소드
        thread.interrupt();
    }
    
    public static void copyByByte() {
        int b; int count=0;
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg")) {
            FileOutputStream fos = new FileOutputStream("계곡복사.jpg");
            try{
                while((b=fis.read()) != -1){      //1바이트 씩 복사하기(파일fis에서 파일fos 로)
                    fos.write(b);
                    count++;
                }
            }catch(IOException e) {
                System.out.println("파일 입출력 예외 : " + e.getMessage());
            }finally {
                try{ fis.close(); fos.close();}
                catch(IOException e) {}
            }
        } catch (IOException e) {
            System.out.println("\n파일 입출력 제외 : " + e.getMessage());
        }
        System.out.println(String.format("\n복사한 파일 크기 : %,d 바이트",count));
    }
    // count : 1325184
    // 소요시간 : 30,395,863,100 ns

    public static void copyByByteArray() {
        int b; int count=0;
        byte[] buffer = new byte[1024];     //바이트 배열을 이용해서 1024바이트 씩 입출력
        //try with resource - try() 안에 close 해야할 자원(리소스, 파일입출력스트림)을 선언하면
        //                  - finally 없이 close 자동으로 합니다. 이 때 자원은 Closeable 인터페이스 구현체이어야 합니다.
        try
        (FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Administrator\\\\Downloads\\\\계곡.jpg");
        FileOutputStream fos = new FileOutputStream("계곡복사2.jpg")){
            while((b=fis.read(buffer,0,buffer.length)) != -1){      
                //read(배열이름, 시작위치, 길이) 리턴값 b는 실제 읽어온 바이트 수
                //길이 1024바이트가 안될수도 있으므로 실제 읽어온 바이트 수를 알아야 처리할수 있음.
                fos.write(buffer,0,b);      //write(배열이름, 시작인덱스, 출력길이)
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
        //     복사한 파일 크기 : 1,325,184 바이트
        // 소요시간 : 63,614,900 ns

    public static void copyByBuffer(){
        int b; int count=0;
        byte[] buffer = new byte[1024];         //바이트 배열을 이용해서 1024바이트씩 입출력
                                                //          -> 버퍼에서 사용. 버퍼입출력스트림     
        try
        (FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Administrator\\\\Downloads\\\\계곡.jpg");
        FileOutputStream fos = new FileOutputStream("계곡복사2.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);     //보조 버퍼입력스트림
        BufferedOutputStream bos = new BufferedOutputStream(fos)){  //보조 버퍼출력스트림
            while((b=bis.read(buffer,0,buffer.length)) != -1){      
                bos.write(buffer,0,b);      
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
}
