package lilii.library.model.dto;

public class LoanDto {
    // 1. 멤버변수
    private int lCode;
    private int bCode;
    private int mCode;
    private String loanDate;
    private String returnDate;
    // 2. 생성자
    public LoanDto() {
    }

    public LoanDto(int lCode, int bCode, int mCode, String loanDate, String returnDate) {
        this.lCode = lCode;
        this.bCode = bCode;
        this.mCode = mCode;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
    // 3. 메소드
    public int getlCode() {
        return lCode;
    }

    public void setlCode(int lCode) {
        this.lCode = lCode;
    }

    public int getbCode() {
        return bCode;
    }

    public void setbCode(int bCode) {
        this.bCode = bCode;
    }

    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "LoanDto{" +
                "lCode=" + lCode +
                ", bCode=" + bCode +
                ", mCode=" + mCode +
                ", loanDate='" + loanDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
