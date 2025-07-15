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
    // memberDB 리턴하는 메소드
    public ArrayList<MemberDto> returnMemberDB(){
        return memberDB;
    }

    // 회원가입 메소드
    // 매개변수 : String mId, String mPwd, String mName, String mPhone
    // 반환값 : 0 : 회원가입 실패, 1 : 회원가입 성공(사용자), 2: 회원가입 성공(관리자)
    public int signup( String mId, String mPwd, String mName, String mPhone ){
        int result = 0;
        // mCode 자동화
        int mCode = memberDB.size()+1;
        // 회원정보 넣을 객체 선언
        MemberDto memberDto = new MemberDto( mCode, mId, mPwd, mName, mPhone );
        // 생성한 객체 ArrayList에 추가
        memberDB.add( memberDto );
        // 유효성 검사
        if ( mId != null && mPwd != null && mName != null && mPhone != null ){  // null값이 없으면
            // 관리자 회원가입 찾기
            if ( mId.equals("admin")){  // 아이디가 admin이면
                result = 2;             // 반환값 2로 수정
            } else {                    // admin이 아니면
                result = 1;             // 반환값 1로 수정
            } // if end
        } else {    // null값이 하나라도 있으면
            result = 0;
        } // if end
        return result;
    } // func end

    // 로그인 메소드
    // 메소드명 : login()
    // 매개변수 : String mId, String mPwd
    // 반환값 : 0 : 회원가입 실패, 1 : 회원가입 성공(사용자), 2: 회원가입 성공(관리자) -> int
    public int login( String mId, String mPwd ){
        int result = 0;         // 초기 반환값 설정
        // 매개변수로 아이디와 비밀번호를 입력받고
        // 회원 DB에 일치하는 회원이 있다면
        for ( int i = 0; i < memberDB.size(); i++ ){
            MemberDto member = memberDB.get(i);         // i번째 회원 변수에 저장
            if ( member.getmId().equals(mId) && member.getmPwd().equals(mPwd) ){    // i번째 회원의 정보와 입력받은 정보가 같다면
                if ( mId.equals("admin")){  // 같은데 아이디가 "admin"이면
                    result = 2;
                    break;
                } else {                    // "admin"이 아니라면 -> 일반 사용자라면
                    result = 1;
                    break;
                } // if end
            } // if end
        } // for end
        // 로그인 성공
        // 일치하는 회원이 없다면
        // 로그인 실패
        return result;
    } // func end
} // class end
