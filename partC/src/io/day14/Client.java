package io.day14;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

//socket.png 그림참고 : 클라이언트와 서버 각각 실행하는 메소드가 다릅니다.
//                      서버와 클라이언트 연결 과정이 다르기때문
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream is = null;  OutputStream os = null;
        DataInputStream dis = null;     DataOutputStream dos = null;
        FileInputStream fis = null;     BufferedInputStream  bis = null;
        

        try {
            System.out.println("[클라이언트] 프로그램 입니다.");
            // 시간 중지 타임 설정
            Thread.sleep(3000); //3초간 중지(3000ms)
            socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.30.6", 5050));
            System.out.println("__연결 성공하였습니다.");

            //서버가 보낸 메세지 받기
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            String message = dis.readUTF();
            System.out.println(message);

            //서버에게 인사말 보내기
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            System.out.print("서버에게 보낼 메세지를 쓰세요. → ");
            message = System.console().readLine();
            dos.writeUTF("\tFrom 클라이언트 → " + message);

            //이미지 파일을 서버에 보내기(Upload)
            // String filePath = "C:\\Users\\Administrator\\Downloads\\쪠트킥.jpg";
            Map<String, String> map = FileSelectTest.showDialog();
            String filePath = map.get("folder") + map.get("filename");
            //파일명을 서버에게 보내서 서버도 원래 파일명으로 다운로드 받기
            dos.writeUTF(map.get("filename"));
            //파일입력을 받아 소켓으로 출력하기
            fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);
            int b;
            while ((b=bis.read()) != -1) {
                dos.write(b);
            }
            System.out.println("파일 업로드 완료!!!!!!");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally{
            try {
                socket.close(); is.close(); os.close(); dis.close(); dos.close(); bis.close(); fis.close();
            } catch (IOException e) {
                
            }
        }
    }

    



}
