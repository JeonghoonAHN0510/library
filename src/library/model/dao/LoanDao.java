package library.model.dao;

import library.model.dto.LoanDto;

import java.util.ArrayList;

public class LoanDao {
    // 1) 싱글톤
    private LoanDao(){}
    private static final LoanDao instance = new LoanDao();
    public static LoanDao getInstance(){
        return instance;
    }
    // 2) 여러개 게시물(DTO)들을 저장할 리스트 선언
    private ArrayList<LoanDto> loanDB = new ArrayList<>();
}
