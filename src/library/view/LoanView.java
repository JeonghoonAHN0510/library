package library.view;

import library.controller.LoanController;

public class LoanView {
    // 1) 싱글톤
    private LoanView(){}
    private static final LoanView instance = new LoanView();
    public static LoanView getInstance(){
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private LoanController loanController = LoanController.getInstance();

    // 도서 반납 메소드
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookReturn ( int bCode ){
        boolean result = loanController.bookReturn( bCode );
        return result;
    } // func end
} // class end
