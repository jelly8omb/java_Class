package jdbc.day2;

import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomerVo;

public class CartApp {

    private List<BuyVo> tbl1 = new ArrayList<>();
    private List<CustomerVo> tbl2 = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("구매할 사용자 간편 로그인");
        System.out.print("아이디 입력 _ ");

        //상품 목록을 선택한 카테고리에 대해 보여주기 (구매할 상품 조회)
        //또는 상품명으로 검색(구매할 상품 조회)
        //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 최소 buy_idx 조회)

        System.out.println("[1] 구매하기    [2] 구매 취소   [3] 구매 수량 변경  [4] 구매 종료");
        int select = Integer.parseInt(System.console().readLine());
        boolean run = true;

        while (run) {
            switch (select) {
                case 1:
                    //insert();
                    break;
                case 2:
                    //update();
                    break;
                case 3:
                    //delete();
                    break;
                default:
                    break;
            }
        }
        
    }

}   // tbl_buy 테이블 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java
    //         테이블 컬럼과 1:1 대응되는 BuyVo.java
    //         테이블 PK 컬럼은 buy_idx -> update, delete 의 조건 컬럼입니다. 
