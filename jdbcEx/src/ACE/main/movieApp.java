package ACE.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ACE.dao.TblMovieDao;
import ACE.dao.TblReserveDao;
import ACE.vo.MovieVo;
import ACE.vo.ReserveVo;
import ACE.vo.RevVwVo;

public class movieApp {
    private TblMovieDao movieDao = new TblMovieDao();
    private TblReserveDao resDao = new TblReserveDao();
    private List<MovieVo> cart = new ArrayList<>();
    private Map<String, Integer> priceMap = null;

    public void movieApp(){
        this.priceMap = movieDao.getPrice();
        System.out.println("가격표 출력");
        System.out.println(priceMap);
    }

    private static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 영화 조회      [P] 영화 검색     [M]나의 예매내역");
        System.out.println("[B] 예매하기   [D] 예매 취소  [Q] 영화 종류 변경  [X] 예매 종료");
        System.out.println(".".repeat(50));
        
    }
    
    private void cancelRes() {
        System.out.print("취소할 예매 번호 입력__");
        try {
            int idx = Integer.parseInt(System.console().readLine());
            //Box box = cart.get(index);
            
        } catch (Exception e) {

        }

    }
    
    private void resCartMovies(String viewerid){
        System.out.print("__");
        try {
            String title = System.console().readLine();
            List<MovieVo> list = cart.get(title);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    

    private void shoWMyPage(String custom_id){
        List<RevVwVo> cart = resDao.myPage(custom_id);
            for(RevVwVo vo : cart)
                System.out.println(vo);
    }

    private void searchMv(){
        System.out.print("Movie Name input__");
        String mname = System.console().readLine();
            List<MovieVo> movielist = movieDao.getMovieVO(mname);
            for(MovieVo vo : movielist)
                System.out.println(vo);
    }

    private void selCategory(){
        System.out.println("CATEGORY : 코미디, 공포, 로맨스, 드라마, 기타, 액션");
        System.out.print("CATEGORY INPUT__");
        String category = System.console().readLine();
            List<MovieVo> movielist = movieDao.selectByPcode(category);
            for(MovieVo vo : movielist)
                System.out.println(vo);
    }
//조짐...
    public static void main(String[] args) {
        movieApp app = new movieApp();
        app.start();
    }

    public void start(){
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
                    selCategory();
                    break;  
                case "P":
                    searchMv();
                    break;
                case "D":
                    cancelRes();
                    break;
                case "B":
                    //resCartMovies();
                    break;
                case "Q":
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
