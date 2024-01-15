package io.alone;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        // 파일 쓰기
        try (FileWriter fileWriter = new FileWriter("example.txt")) {
            String dataToWrite = "Hello, FileWriter!\nThis is a sample text.";
            fileWriter.write(dataToWrite);

            System.out.println("파일 쓰기 완료");

        } catch (IOException e) {
            System.out.println("파일 쓰기 예외: " + e.getMessage());
        }

        // 파일 읽기
        try (FileReader fileReader = new FileReader("example.txt")) {
            int data;
            while ((data = fileReader.read()) != -1) {
                // 파일에서 1바이트씩 읽어와서 처리
                System.out.print((char) data);
            }

        } catch (IOException e) {
            System.out.println("파일 읽기 예외: " + e.getMessage());
        }
    }
}

