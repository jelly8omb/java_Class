package io.day13;

public class Score {
    private String name;
    private int kor;
    private int eng;
    private int math;


    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


    public String getName() {
        return name;
    }


    public int getKor() {
        return kor;
    }


    public int getEng() {
        return eng;
    }


    public int getMath() {
        return math;
    }

    public String datas(){
        return name + "," + kor + "," + eng + "," + math;
    }
    
    @Override
    public String toString() {
        return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
    }

    
}
