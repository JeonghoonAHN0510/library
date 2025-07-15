package library.controller;

import library.model.dao.LoanDao;

public class LoanController {
    // 1) 싱글톤
    private LoanController(){}
    private static final LoanController instance = new LoanController();
    public static LoanController getInstance(){
        return instance;
    }

    // 2) dao 싱글톤 가져오기
    private LoanDao loanDao = LoanDao.getInstance();

    // 도서 반납 메소드
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookReturn ( int bCode ){
        // view로부터 도서코드 입력받아 dao에게 전달 후, 반환값 view로 반환하기
        boolean result = loanDao.bookReturn( bCode );
        return result;
    } // func end
} // class end
