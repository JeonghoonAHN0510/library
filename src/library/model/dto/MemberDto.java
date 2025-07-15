package library.model.dto;

public class MemberDto {
    // 1. 멤버변수
    private int mCode;
    private String mId;
    private String mPwd;
    private String mName;
    private String mPhone;
    // 2. 생성자
    public MemberDto() {
    }

    public MemberDto(int mCode, String mId, String mPwd, String mName, String mPhone) {
        this.mCode = mCode;
        this.mId = mId;
        this.mPwd = mPwd;
        this.mName = mName;
        this.mPhone = mPhone;
    }
    // 3. 메소드
    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmPwd() {
        return mPwd;
    }

    public void setmPwd(String mPwd) {
        this.mPwd = mPwd;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "mCode=" + mCode +
                ", mId='" + mId + '\'' +
                ", mPwd='" + mPwd + '\'' +
                ", mName='" + mName + '\'' +
                ", mPhone='" + mPhone + '\'' +
                '}';
    }
}
