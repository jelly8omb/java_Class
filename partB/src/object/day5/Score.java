package object.day5;

import java.util.Arrays;

// 학생들의 성적을 객체로 만들어 줄 클래스
public class Score {
    

    
    private String name;    // 학생 이름
    private int grade;      // 학년
    private int[] jumsues;  // 점수들이 저장될 배열
                            // 배열의 크기는 학년마다 다를 수 있음.
    public int sum(){
        int sum=0;
        for(int i=0;i<jumsues.length;i++){
            sum += jumsues[i];
        }
        return sum;
    }

    public double avg(){
        double avg =0;
        for(int i=0;i<jumsues.length;i++){
            avg = sum() / jumsues.length;
        }
        return avg;
    }

    //getter
    public String getName(){
        return name;
    }

    public int getGrade(){
        return grade;
    }

    public int[] getJumsues(){
        return jumsues;
    }

    //setter
    public void setName(String n1){
        name = n1;
    }

    public void setGrade(int g1){
        grade = g1;
    }

    public void setJumsues(int[] j1){
        jumsues = j1;
    }

    public void printJumsu(){
        System.out.println("이름 = " + name + ", 학년 = " + grade + ", 점수 = " + Arrays.toString(jumsues)+ ", 총점 = " + sum() + ", 평균 = " + avg());
    }

    // 점수의 합계를 리턴하는 sum() 메서드

    // 점수의 평균 double 리턴하는 average() 메서드

    // 모든 인스턴스 필드값을 확인 출력하는 printScore() 메서드
}                           
