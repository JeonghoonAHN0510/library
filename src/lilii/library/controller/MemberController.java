package lilii.library.controller;

import lilii.library.model.dao.MemberDao;
import lilii.library.model.dto.MemberDto;

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

    // 로그인 회원코드, 회원이름 변수 선언
    private static int loginMCode;
    public static int returnMCode(){
        return loginMCode;
    }

    // 로그인 아이디를 받아서 회원코드으로 변환
    // 매개변수 : String mId
    // 리턴 : int
    public int getMcode( String mId ) {
        ArrayList<MemberDto> memberList = memberDao.returnMemberDB();
        for (int i = 0; i < memberList.size(); i++){
            if(memberList.get(i).getmId().equals(mId)){
                loginMCode = memberList.get(i).getmCode();
                break;
            }
        }
        return loginMCode;
    }
    // 로그인 아이디를 받아서 회원이름으로 변환
    // 매개변수 : String mId
    // 리턴 : String
    public String getMname (String mId ){
        String result = "";
        ArrayList<MemberDto> memberList = memberDao.returnMemberDB();
        for ( int i = 0; i < memberList.size(); i++ ){
            MemberDto member = memberList.get(i);
            if ( member.getmId().equals(mId)){
                result = member.getmName();
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

    // 로그인 메소드
    // 메소드명 : login()
    // 매개변수 : String mId, String mPwd
    // 반환값 : 0 : 회원가입 실패, 1 : 회원가입 성공(사용자), 2: 회원가입 성공(관리자) -> int
    public int login( String mId, String mPwd ){
        // view로부터 입력값을 받아 dao에게 전달 후, 반환값을 다시 view에게 전달
        int result = memberDao.login( mId , mPwd );
        return result;
    } // func end

    // 로그아웃 메소드
    // 기능설명 : 초기화면으로 이동
    // 메소드명 : logout()
    // 매개변수 : X
    // 반환값 : X


} // class end
