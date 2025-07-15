package library.model.dao;

import library.model.dto.MemberDto;

import java.util.ArrayList;

public class MemberDao {
    // 1) 싱글톤
    private MemberDao(){}
    private static final MemberDao instance = new MemberDao();
    public static MemberDao getInstance(){
        return instance;
    }
    // 2) 여러개 게시물(DTO)들을 저장할 리스트 선언
    private ArrayList<MemberDto> memberDB = new ArrayList<>();
    public ArrayList<MemberDto> returnMemberDB(){
        return memberDB;
    }
}
