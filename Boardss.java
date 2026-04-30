public class Boardss {

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String bdate;

    public int getBno() { return bno; } // 받는값 타입 입력 get/set (반환타입) 출력
    public void setBno(int bno) { this.bno = bno; }

    public String getBtitle() { return btitle; }
    public void setBtitle(String btitle) { this.btitle = btitle; }

    public String getBcontent() { return bcontent; }
    public void setBcontent(String bcontent) { this.bcontent = bcontent; }

    public String getBwriter() { return bwriter; }
    public void setBwriter(String bwriter) { this.bwriter = bwriter; }

    public String getBdate() { return bdate; }
    public void setBdate(String bdate) { this.bdate = bdate; }


    @Override
    public String toString() {
        return bno + "\t" + btitle + "\t" + bwriter + "\t" + bdate;
    }
}