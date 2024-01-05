package object.day6;

public class AddQuiz {
    private int data1;
    private int data2;
    private int userAnswer;
    private boolean isRight;

    public int getData1() {
        return data1;
    }

    public int getData2() {
        return data2;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }
}
