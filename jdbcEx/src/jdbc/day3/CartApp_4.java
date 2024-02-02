package jdbc.day3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtil;
import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;
import project.vo.ProductVo;

// CartApp_4 는 다른 클래스의 상위 클래스로 상속 관계를 만들 수 있다.
//              ㄴ 단,  main 메소드도 제거하고 
//                      인스턴스 메소드는 pivate 이외 다른  접근 한정자로 해야합니다.     
public class CartApp_4 {
    //이 클래스의 전역변수 선언 - 모든 메소드에서 사용가능. 인스턴스 필드와 같습니다.
    private TblBuyDao buyDao = new TblBuyDao();
    private TblProductDao productDao = new TblProductDao();
    private List<BuyVo> cart = new ArrayList<>();       //장바구니
    private Map<String, Integer> priceMap = null;

    public void CartApp_41(){
        //getPriceTable 메소드 구현
        this.priceMap = productDao.getPriceTable();
        System.out.println("테스트 가격표 출력");
        System.out.println(priceMap);
    }

    private void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("[C] 카테고리별 상품 조회      [P] 상품명 검색");
        System.out.println("[M]나의 구매내역    [T]날짜별 결제 금액 조회");
        System.out.println("[B] 구매하기   [D] 구매 취소  [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println("::장바구니::[A] 담기  [L] 목록  [R] 삭제   [Y] 모두 구매 ");
        System.out.println(".".repeat(70));
    }

    private void showMyPay(String customerid){
        System.out.println("날짜를 입력하면 총 구매금액을 조회합니다.");
        System.out.print("구매 날짜 입력_");
        String buydate = System.console().readLine(); //입력형식 yyyy-mm-dd

        System.out.println(String.format("%s - %s - %s", customerid, buydate));
    }

    private void showMyPage(String customerid) {
        List<CustomerBuyVo> result = buyDao.selectCustomerBuyList(customerid);
                    for(CustomerBuyVo vo : result)  
                            System.out.println(vo);
    }

    private void showProductListByCategory() {
        System.out.println("카테고리 : A1-과일 A2-수입과일  B1-인스턴스  B2-선물세트 C1-과자류");
        System.out.print("카테고리 입력__");
        String category = System.console().readLine();
                    List<ProductVo> productlist = productDao.getProductVo(category);
                    for(ProductVo vo : productlist)
                        System.out.println(vo);
    }

    public void searchProductListByPname() {
        System.out.print("상품명 검색어 입력__");
        String pname = System.console().readLine();
                    List<ProductVo> productlist = productDao.selectByPname(pname);
                    for(ProductVo vo : productlist)
                        System.out.println(vo);
    }                    

    //장바구니 : 테이블에 직접 추가/삭제 하지않고 List 변수 cart 사용
    private void addCartItem(String customerid) {
        System.out.println(".................. 장바구니 :: 물품 담기 ...................");
        System.out.print("구매할 상품코드 입력하세요.__");
        String pcode = System.console().readLine();
        System.out.print("구매할 수량 입력하세요.__");
        int quantity = Integer.parseInt(System.console().readLine());
        cart.add(new BuyVo(0, customerid, pcode, quantity, null));
     }

    private void showCartList() {
        long totalMoney = 0;
        System.out.println(".................. 장바구니 :: 목록 보기...................");
        for(int i=0;i<cart.size();i++){
            System.out.println("번호 : " + i + " 물품 : " + cart.get(i));       //리스트에서 인덱스i 가져오기
            //물품 수량 * 가격
            totalMoney += cart.get(i).getQUANTITY() * priceMap.get(cart.get(i).getPCODE());
        }
        System.out.println("총 결제 금액 : " + totalMoney);
    }
    
    

    private void removeCartItem() {
        System.out.println(".................. 장바구니 :: 물품 삭제 ...................");
        System.out.print( "삭제할 번호 입력__");
        int index = Integer.parseInt(System.console().readLine());
        if(index < 0 || index >= cart.size()){
            System.out.println("잘못된 장바구니 상품 번호 입니다.");
            return; //메소드 종료
        }
        cart.remove(index);
        System.out.println("물품을 장바구니에서 삭제했습니다.");
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void buyCartItems() {
        if (cart.size()==0) {
            System.out.println("장바구니가 비었습니다. 물품을 담으세요. ~~");
            return;
        }
        System.out.println(".................. 장바구니 :: 물품 모두 구매 ...................");
        int result = buyDao.insertMany(cart);
        if (result > 0) {
            System.out.println("장바구니 물품 구매가 정상적으로 완료되었습니다.");
        }else{
            System.out.println("장바구니 물품 구매 실패했습니다.");
        }
    }

    

       //상품 목록을 선택한 카테고리에 대해 보여주기  (구매할 상품 조회)
       //또는 상품명으로 검색 (구매할 상품 조회)
       //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
    public static void main(String[] args) {
        CartApp_4 app = new CartApp_4();
        app.start();
    }
    
    public void start() {
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerid = System.console().readLine();
        System.out.println(customerid + " 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");    
           // int select = Integer.parseInt(System.console().readLine());
           String select = System.console().readLine();
            switch (select.toUpperCase()) {
                case "M":   // 나의 구매내역
                    showMyPage(customerid);
                    CartApp_41();
                    break;
                case "C":
                    showProductListByCategory();
                    break;  
                case "P":
                    searchProductListByPname();    
                    break;
                case "A":
                    addCartItem(customerid);
                    break;
                case "L":
                    showCartList();
                    break;
                case "R":
                    removeCartItem();
                    break;    
                case "Y":
                    buyCartItems();
                    break;
                case "T":
                    // showMyPay();
                    break;
                case "X":
                    run=false;
                    break;                
                default:
                    break;
            }
        }

    }






}   