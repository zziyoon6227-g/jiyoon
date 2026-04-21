import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//바이트 단위로 읽기에 한글이 깨짐 BufferedInputStream  인코딩을 UDF-8로 해야 안깨짐
public class Code226 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        try{
            bis = new BufferedInputStream(new FileInputStream("C:/javame/jiyoon1/src/data6.txt"));
            int x=0;
            while((x=bis.read()) != -1)
            System.out.print((char) x);
        }

        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                bis.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
    }
}

  

