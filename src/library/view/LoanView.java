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
}
