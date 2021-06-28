public class Member {
    private int num; //넘버링
    private String name; //이름
    private String gender; //성별
    private String major; //학부
    private String studentNum; //학번
    private String date; //등록일자

    public Member(){

    }

    public Member(int num, String name, String gender, String major, String studentNum, String date){
        this.num = num;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.studentNum = studentNum;
        this.date = date;
    }

    @Override
    public String toString() {
        return this.num + "\t" + this.name + "\t\t" + this.gender + "\t\t" + this.major + "\t\t" + this.studentNum + "\t" + this.date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
