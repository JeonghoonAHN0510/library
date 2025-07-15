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

    // 로그인정보를 받아서 아이디를 회원코드로 반환  // 매개변수 아이디 // 리턴 int
    public int getMcode( String mId ) {
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

    // 회원가입 메소드
    // 매개변수 : String mId, String mPwd, String mName, String mPhone
    // 반환값 : 0 : 회원가입 실패, 1 : 회원가입 성공(사용자), 2: 회원가입 성공(관리자)
    public int signup( String mId, String mPwd, String mName, String mPhone ){
        // view로부터 값을 받아 dao에게 전달 후, 그 반환값을 다시 view에게 전달
        int result = memberDao.signup( mId, mPwd, mName, mPhone );

        return result;
    } // func end
} // class end
