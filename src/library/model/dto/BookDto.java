package library.model.dto;

public class BookDto {
    // 1. 멤버변수
    private int bCode;
    private String bName;
    private String bAuthor;
    // 2. 생성자
    public BookDto() {
    }

    public BookDto(int bCode, String bName, String bAuthor) {
        this.bCode = bCode;
        this.bName = bName;
        this.bAuthor = bAuthor;
    }
    // 3. 메소드
    public int getbCode() {
        return bCode;
    }

    public void setbCode(int bCode) {
        this.bCode = bCode;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bCode=" + bCode +
                ", bName='" + bName + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                '}';
    }
}
