package object.day5;

public class B03ScoreMain {
    public static void main(String[] args) {
        
        // 학생 4명의 성적을 저장
        // 1학년 2명(모모, 다현) 3과목. 2학년 2명(나연, 쯔위) 4과목
        Score sc1 = new Score();
        Score sc2 = new Score();
        Score sc3 = new Score();
        Score sc4 = new Score();

        sc1.setName("모모");
        sc1.setGrade(1);
        int[] iArray1 = {12, 34, 31};
        sc1.setJumsues(iArray1);
        sc1.printJumsu();


        sc2.setName("다현");
        sc2.setGrade(1);
        int[] iArray2 = {4, 2, 7};
        sc2.setJumsues(iArray2);
        sc2.printJumsu();

        sc3.setName("나연");
        sc3.setGrade(2);
        int[] iArray3 = {41, 22, 74, 22};
        sc3.setJumsues(iArray3);
        sc3.printJumsu();

        sc4.setName("쯔위");
        sc4.setGrade(2);
        int[] iArray4 = {45, 24, 17, 11};
        sc4.setJumsues(iArray4);
        sc4.printJumsu();

        



    }
}
