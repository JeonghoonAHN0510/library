package lilii.library.view;

import lilii.library.controller.LoanController;
import lilii.library.model.dto.LoanDto;

import java.util.ArrayList;

public class LoanView {
    // 1) 싱글톤
    private LoanView(){}
    private static final LoanView instance = new LoanView();
    public static LoanView getInstance(){
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private LoanController loanController = LoanController.getInstance();

    // 도서반납 메소드
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookReturn ( int bCode ){
        return loanController.bookReturn( bCode );
    } // func end

    // 도서대출 메소드
    // 메소드명 : bookLoan()
    // 매개변수 : int bCode
    // 반환값 : true(성공)/false(실패) -> boolean
    public boolean bookLoan( int bCode ){
        boolean result = loanController.bookLoan( bCode );
        return result;
    } // func end

    public ArrayList<LoanDto> loanPrint(String mId ){
        return loanController.loanPrint( mId );
    }

} // class end
