import java.sql.Blob;
import java.util.Date;

public class Board {

    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;
    private String bfilename;
    private Blob bfiledata;

public void setBno(int bno) { this.bno = bno; }
public void setBtitle(String btitle) { this.btitle = btitle; }
public void setBcontent(String bcontent) { this.bcontent = bcontent; }
public void setBwriter(String bwriter) { this.bwriter = bwriter; }
public void setBdate(Date bdate) { this.bdate = bdate; }
public void setBfilename(String bfilename) { this.bfilename = bfilename; }
public void setBfiledata(Blob bfiledata) { this.bfiledata = bfiledata; }

public Blob getBfiledata() {  //꺼내오는 함수
    return bfiledata;
}

public String getBfilename() {
    return bfilename;
}
@Override
public String toString() {
    return "Board{" +
            "bno=" + bno +
            ", btitle='" + btitle + '\'' +
            ", bwriter='" + bwriter + '\'' +
            ", bdate=" + bdate +
            ", bfilename='" + bfilename + '\'' +
            '}';
}
}
