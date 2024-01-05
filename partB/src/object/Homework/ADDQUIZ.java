package object.Homework;

public class ADDQUIZ {
    private int data1;
    private int data2;
    private int userAnswer;

    public int getData1() {
        return data1;
    }

    public int getData2() {
        return data2;
    }
    public int getUserAnswer() {
        return userAnswer;
    }

    public void setData1() {
        this.data1 = (int)(Math.random() * 45) +1;
    }

    public void setData2() {
        this.data2 = (int)(Math.random() * 45) +1;;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int CAlCULATE(){
        return data1 + data2;
    }

    public boolean CorrectAnswer(int userAnswer){
        this.userAnswer = userAnswer;
        return CAlCULATE() == userAnswer;
    }
}
