package io.day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//파일 입력스트림으로 이미지 파일 읽어옵니다.
// ==> 파일 출력 스트림으로 파일 내용을 출력(write)합니다.
public class D06FileCopyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\쪠트킥.jpg");
            fos = new FileOutputStream("쪠트킥.jpg");
            int b;
            int count=0;
            while ((b=fis.read()) != -1) {  //1바이트씩 복사하기(파일 fis에서 파일 fos로)
                fos.write(b);
                count++;
            }
            System.out.println("count : " + count);
        } catch (IOException e) {
            System.out.println("파일 입출력 제외 : " + e.getMessage());
        }finally{
            try {
                fis.close(); fos.close();
            } catch (IOException e) {

            }
        }
    }
}
