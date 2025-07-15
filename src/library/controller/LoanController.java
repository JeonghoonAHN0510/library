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
}
