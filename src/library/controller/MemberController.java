package library.controller;

import library.model.dao.MemberDao;
import library.model.dto.MemberDto;

import java.util.ArrayList;

public class MemberController {
    // 1) 싱글톤
    private MemberController(){}
    private static final MemberController instance = new MemberController();
    public static MemberController getInstance(){
        return instance;
    }

    // 2) dao 싱글톤 가져오기
    private MemberDao memberDao = MemberDao.getInstance();

    public int getMcode( String mId ) {// 로그인정보를 받아서 아이디를 회원코드로 반환  // 매개변수 아이디 // 리턴 int
        int result = 0;
        ArrayList<MemberDto> memberList = memberDao.returnMemberDB();
        for (int i = 0; i < memberList.size(); i++){
            if(memberList.get(i).getmId().equals(mId)){
                result = memberList.get(i).getmCode();
                break;
            }
        }
        return result;
    }
}
