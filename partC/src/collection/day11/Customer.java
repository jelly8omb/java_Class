package collection.day11;

//고객 정보 클래스
public class Customer {
    private String name;
    private String phone;
    private int group;      //1:일반    2:Vip   3:블랙

    //커스텀 생성자
    public Customer(String name, String phone, int group){
        this.name = name;
        this.group = group;
        this.phone = phone;
    }

    //getter
    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    //setter 수정할때 쓰려고 만듦
    public void setGroup(int group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //정보 변경 메소드
    public void modify_phone(String phone, int group){
        this.group=group;
        this.phone=phone;
    }

    //toString(Test)
    @Override
    public String toString(){
        return this.name + "," + this.phone + "," + this.group;
    }
}
