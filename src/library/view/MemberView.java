package library.view;

import library.controller.MemberController;

import java.util.Scanner;

public class MemberView {
    // 1) 싱글톤
    private MemberView(){}
    private static final MemberView instance = new MemberView();
    public static MemberView getInstance(){
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private MemberController memberController = MemberController.getInstance();

    private Scanner scan = new Scanner(System.in);

    // 프로그램 최초 하면
    public void index(){
        for( ; ; ){
            System.out.println("=========== 도서관리 시스템  ===========");
            System.out.println("        1.회원가입 | 2.로그인");
            System.out.println("==========================================");
            System.out.print("선택 > ");        int option = scan.nextInt();
            if ( option == 1 ){         // 회원가입을 선택하면
                // 기본적인 출력
                System.out.println("--------- 회원 가입 ---------");
                System.out.print("아이디 : ");     String mId = scan.next();
                System.out.print("비밀번호 : ");    String mPwd = scan.next();
                System.out.print("이름 : ");       String mName = scan.next();
                System.out.print("연락처 : ");     String mPhone = scan.next();
                int result = signup( mId, mPwd, mName, mPhone );
                if ( result == 0 ){
                    System.out.println("[경고] 회원가입에 실패하였습니다.");
                }else if ( result == 1 ){
                    System.out.println("[안내] 회원가입이 완료되었습니다.");
                }else if ( result == 2 ){
                    System.out.println("[안내] 관리자 계정이 등록되었습니다.");
                } // if end
            } else if ( option == 2 ){  // 로그인을 선택하면
                System.out.println("--------- 로그인 ---------");
                System.out.print("아이디 : ");     String mId = scan.next();
                System.out.print("비밀번호 : ");    String mPwd = scan.next();
                int mCode = memberController.getMcode(mId);             // 아이디로부터 회원코드얻기
                int result = login( mId, mPwd );
                if ( result == 0 ){         // 로그인에 실패했다면
                    System.out.println("[경고] 로그인에 실패하였습니다.");
                }else if ( result == 1 ){   // 사용자 로그인이라면

                }else if ( result == 2 ){   // 관리자 로그인이라면
                    System.out.println("[안내] 관리자님, 환영합니다.");
                }
            }
        } // 무한루프 end
    } // func end

    // 회원가입 메소드
    // 매개변수 : String mId, String mPwd, String mName, String mPhone
    // 반환값 : 0 : 회원가입 실패, 1 : 회원가입 성공(사용자), 2: 회원가입 성공(관리자)
    public int signup( String mId, String mPwd, String mName, String mPhone ){
        // view로부터 값을 받아 dao에게 전달 후, 그 반환값을 다시 view에게 전달
        int result = memberController.signup( mId, mPwd, mName, mPhone );

        return result;
    } // func end

    // 로그인 메소드
    // 메소드명 : login()
    // 매개변수 : String mId, String mPwd
    // 반환값 : 0 : 회원가입 실패, 1 : 회원가입 성공(사용자), 2: 회원가입 성공(관리자) -> int
    public int login( String mId, String mPwd ){
        int result = memberController.login( mId, mPwd );
        return result;
    } // func end
} // class end
