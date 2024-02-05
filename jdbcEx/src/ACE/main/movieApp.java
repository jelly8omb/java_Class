package ACE.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ACE.dao.TblMovieDao;
import ACE.dao.TblReserveDao;
import ACE.dao.TblViewerDao;
import ACE.vo.MovieVo;
import ACE.vo.ReserveVo;
import ACE.vo.RevVwVo;

public class movieApp {
    private TblMovieDao movieDao = new TblMovieDao();
    private TblReserveDao resDao = new TblReserveDao();
    private TblViewerDao vwDao = new TblViewerDao();
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

    
    
    private void cancelRes(String custom_id) {
        System.out.print("[취소할 예매 번호 입력] : ");
        int res_idx = Integer.parseInt(System.console().readLine());
        if (resDao.checkRes(custom_id, res_idx)) {
            if (resDao.regDelete(custom_id, res_idx) == 1) {
                System.out.println("취소완료");
            } else {
                System.out.println("FAIL");
            }
        } else {
            System.out.println("예매 취소 권한이 없습니다.");
        }

    }
    
    private void resCartMovies(String custom_id){
        System.out.print("[예매할 영화 제목 입력] : ");
        String title = System.console().readLine();
        if (vwDao.checkAgeLimit(custom_id, title)) {
            System.out.println("얼라는 가라..");
        }else{
            ReserveVo rvo = new ReserveVo(0, custom_id, title, null);
        if (resDao.resInsert(rvo)==1) {
            System.out.println(String.format("[%s] 예매완료.", title));
        }else{
            System.out.println("예매를 실패하였습니다.");
        }
        }

    }

    

    private void movieChan(String custom_id){
        System.out.println("변경할 영화 예매 번호 입력__");
        int res_idx = Integer.parseInt(System.console().readLine());

        System.out.println("새로 예매할 영화의 제목 입력__");
        String customid = System.console().readLine();
        
        ReserveVo rvo = new ReserveVo(res_idx, null, customid, null);
        if (resDao.checkRes(custom_id, res_idx)) {
            if (resDao.resUpdate(custom_id, rvo)==1) {
                System.out.println("변경완료");
            }else{
                System.out.println("변경실패");
            }
        }else{
            System.out.println("예매할 영화정보가 없습니다.");
        }
    }
    
    

    private void shoWMyPage(String custom_id){
        List<RevVwVo> cart = resDao.myPage(custom_id);
            for(RevVwVo vo : cart)
                System.out.println(vo);
    }

    private void searchMv(){
        System.out.print("[영화 제목 입력] : ");
        List<MovieVo> movielist = movieDao.getMovieVO(System.console().readLine());
            for(MovieVo vo : movielist)
                System.out.println(vo);
    }

    private boolean login(String viewerid){
        return vwDao.checkId(viewerid);

    }

    private void selCategory(){
        System.out.println("CATEGORY : [코미디] [공포] [로맨스] [드라마] [기타] [액션]");
        System.out.print("[Choose CATEGORY] : ");
        String category = System.console().readLine();
            List<MovieVo> movielist = movieDao.selectByPcode(category);
            for(MovieVo vo : movielist)
                System.out.println(vo);
    }
    public static void main(String[] args) {
        movieApp app = new movieApp();
        app.start();
    }

    

    public void start(){
        System.out.println("★ A CEnema ★");
        System.out.println("로그인이 필요합니다.");
        System.out.print("[ID를 입력해주세요] : ");
        String custom_id = System.console().readLine();
        boolean run = true;
        while (run) {
            boolean chid = login(custom_id);
            while (true) {
                if (chid==true) {
                    System.out.println(String.format("[%s] 님 환영합니다", custom_id));
                    break;
                }else{
                    System.out.println("없는 사용자입니다.");
                    System.out.print("아이디 입력 __");
                    custom_id = System.console().readLine();
                    chid = login(custom_id);
                    continue;
                }
            }
            showMenu();
            System.out.print("[메뉴 선택] : ");    
           // int select = Integer.parseInt(System.console().readLine());
           String select = System.console().readLine();
            switch (select.toUpperCase()) {
                case "M","ㅡ":  
                    shoWMyPage(custom_id); 
                    break;
                case "C","ㅊ":
                    selCategory();
                    break;  
                case "P","ㅔ":
                    searchMv();
                    break;
                case "D","ㅇ":
                    cancelRes(custom_id);
                    break;
                case "B","ㅠ":
                    resCartMovies(custom_id);
                    break;
                case "Q","ㅂ":
                    movieChan(custom_id);
                    break;
                case "X","ㅌ":
                    run=false;
                    break;                
                default:
                    break;
            }
        }
    }
    
}
