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
            System.out.println("  1.회원가입 | 2.로그인");
            System.out.println("==========================================");
            System.out.println("선택 > ");

        }
    }
}
