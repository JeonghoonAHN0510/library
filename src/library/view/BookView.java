package library.view;

import library.controller.BookController;

public class BookView {
    // 1) 싱글톤
    private BookView(){}
    private static final BookView instance = new BookView();
    public static BookView getInstance(){
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private BookController bookController = BookController.getInstance();
}
