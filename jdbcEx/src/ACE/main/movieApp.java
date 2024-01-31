package ACE.main;

import java.util.ArrayList;
import java.util.List;

import ACE.dao.TblMovieDao;
import ACE.vo.MovieVo;
import project.vo.BuyVo;

public class movieApp {
    private static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 영화 조회      [P] 영화 검색     [M]나의 예매내역");
        System.out.println("[B] 예매하기   [D] 예매 취소  [Q] 구매 수량 변경  [X] 예매 종료");
        System.out.println("::장바구니::[A] 담기  [L] 영화 목록  [R] 삭제   [Y] 모두 구매 ");
        System.out.println(".".repeat(50));
        
    }
    
    private static void shoWMyPage(String custom_id){
        TblMovieDao Moviedao = new TblMovieDao();
    }

    public static void main(String[] args) {
        List<MovieVo> list = new ArrayList<>();
        System.out.println("예매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String custom_id = System.console().readLine();
        System.out.println(custom_id + " 님 환영합니다.♡");
        boolean run = true;
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");    
           // int select = Integer.parseInt(System.console().readLine());
           String select = System.console().readLine();
            switch (select.toUpperCase()) {
                case "M":  
                    shoWMyPage(custom_id); 
                    break;
                case "C":
                    break;  
                case "P":
                    break;
                case "A":
                    break;
                case "L":
                    break;
                case "R":
                    break;    
                case "Y":
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
