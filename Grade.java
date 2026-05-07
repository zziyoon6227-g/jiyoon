public class Grade {
    private int stuId;
    private String stuName;
    private int kor;
    private int eng;
    private int math;
    private String teacherNote;

    public Grade(String stuName, int kor, int eng, int math){
        this.stuName = stuName;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    public int getStuId(){return stuId;}
    public void setStuId(int stuId){this.stuId = stuId;}

    public String getStuName(){return stuName;}
    public void setStuName(String stuName){this.stuName = stuName;}

    public int getKor(){return kor;}
    public void setKor(int kor){this.kor = kor;}

    public int getEng(){return eng;}
    public void setEng(int eng){this.eng = eng;}

    public int getMath(){return math;}
    public void setMath(int math){this.math = math;}

    public String getTeacherNote(){return teacherNote;}
    public void setTeacherNote(String teacherNote){this.teacherNote = teacherNote;}


}
