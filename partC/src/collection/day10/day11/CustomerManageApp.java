package collection.day10.day11;

import java.util.ArrayList;
import java.util.List;

//~1.14. 21:00
public class CustomerManageApp {
    private List<Customer> Customers = new ArrayList<>();

    private void initialize(){
        Customers.add(new Customer("웅장한", "000-1111-8888", 2));
        Customers.add(new Customer("굉장한", "000-2222-7777", 3));
        Customers.add(new Customer("자아두", "000-3333-6666", 1));
        Customers.add(new Customer("반하나", "000-4444-5555", 1));
        Customers.add(new Customer("수우박", "000-5555-4444", 2));
        Customers.add(new Customer("배애리", "000-6666-3333", 1));
        Customers.add(new Customer("이메론", "000-7777-2222", 3));
        Customers.add(new Customer("김사과", "000-8888-1111", 3));
    }

    private void start(){
        initialize();
        //메뉴 선택 : 등록, 검색(이름/그룹), 삭제, 수정, 전체 출력
        System.out.println("~".repeat(10) + "고객 관리 프로그램" + "~".repeat(10));
        while (true) {
            System.out.println("\t 1. 등록");
            System.out.println("\t 2. 목록");
            System.out.println("\t 3. 검색");
            System.out.println("\t 4. 수정");
            System.out.println("\t 5. 삭제");
            System.out.println("\t 6. 종료");
            System.out.print("선택 - ");
            int select = Integer.parseInt(System.console().readLine());
            switch (select) {
                case 1:
                    addCus();
                    break;
                case 2:
                    listCus();
                    break;
                case 3:
                    searchCus();
                    break;
                case 4:
                    updateCus();
                    break;
                case 5:
                    removeCus();
                    break;
                case 6:
                    System.out.println("종료합니다.");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("잘못된 선택");
                    
            }
        }
    }

    private void addCus(){
        System.out.print("고객 등록 : ");
        String name = System.console().readLine();
        System.out.print("번호 : ");
        String phone = System.console().readLine();
        System.out.print("그룹별 1.일반 2.Vip 3.블랙 : ");
        int group = Integer.parseInt(System.console().readLine());

        
        Customers.add(new Customer(name, phone, group));
    }

    private void printListCus(List<Customer> list){
        for(Customer word : list){
            System.out.println(String.format("%-20s %-30s %-20s", word.getName(),word.getPhone(),word.getGroup()));
        }
    }

    private void listCus(){
        System.out.println("목록 출력");
        System.out.println(String.format("%-20s %-30s %-20s", "name","phone","group"));

        printListCus(Customers);
    }

    private List<Customer> searchNameCus(String name){
        List<Customer> aCustomers = new ArrayList<>();
        for(Customer word : Customers){
            if(word.getName().equals(name)){
                aCustomers.add(word);
            }
        }
        return aCustomers;
    }

    private List<Customer> searchGroupCus(int group){
        List<Customer> aCustomers = new ArrayList<>();
        for(Customer word : Customers){
            if(word.getGroup()==group){
                aCustomers.add(word);
            }
        }
        return aCustomers;
    }

    private void searchCus(){
        System.out.println("이름으로 검색 : 1, 등급으로 검색 : 2");
        String nameFind = null;
        List<Customer> Customers = null;
        switch (System.console().readLine()) {
            case "1":
                System.out.print("이름으로 검색 : ");
                nameFind = System.console().readLine();   
                Customers = searchNameCus(nameFind); 
                break;
            case "2":
                System.out.print("등급으로 검색 : ");
                int level = Integer.parseInt(System.console().readLine());
                Customers = searchGroupCus(level);
                break;
            default:
                System.out.println("잘못된 입력값");
                break;
        }
        if(Customers.size()==0){
            System.out.println("등록이 안되어있는 고객.");
        }
        printListCus(Customers);
    }

    private void updateCus(){
        System.out.print("수정할 고객을 입력 : ");
        String nameFind = System.console().readLine();
        boolean updateCus = false;
        for(int i=0;i<Customers.size();i++){
            Customer word = Customers.get(i);
            if(word.getName().equals(nameFind)){
                System.out.println(word.getName() + ", " + word.getPhone() + ", " + word.getGroup());
                System.out.print("고객 이름 수정 : ");
                String newName = System.console().readLine();
                System.out.print("고객 번호 수정 : ");
                String newNum = System.console().readLine();
                System.out.print("등급 수정 : ");
                int newGp = Integer.parseInt(System.console().readLine());

                word.setName(newName);
                word.setPhone(newNum);
                word.setGroup(newGp);
                updateCus = true;

                System.out.println(word.getName() + ", " + word.getPhone() + ", " + word.getGroup());
            }
        }
    }

    private void removeCus(){
        System.out.print("삭제할 고객 이름 입력 : ");
        String nameFind = System.console().readLine();
        Customer cusRemove = null;
        for(Customer Customer : Customers){
            if(Customer.getName().equals(nameFind)){
                cusRemove = Customer;
                break;
            }
        }
        if (cusRemove != null) {
            Customers.remove(cusRemove);
            System.out.println("삭 제 완 료");
        }else{
            System.out.println("없는 고객");
        }
        
        // boolean isFind = false;
        // for(int i=0;i<Customers.size();i++){
        //     if(Customers.get(i).getName().equals(nameFind)){
        //         isFind=true;

        //         Customers.remove(i);
        //         System.out.println("삭 제 완 료");
        //     }
        // }
    }
    
    //JavaWordApp_V2 형식
    public static void main(String[] args) {
        CustomerManageApp app = new CustomerManageApp();
        app.start();
    }

    
}
