import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; //얘는 문자 단위라 한글 안깨짐

public class Code225 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        try{
            fis = new FileInputStream("C:/javame/jiyoon1/src/data6.txt");
            reader =  new InputStreamReader(fis);
            int x;
            while ((x = reader.read()) != -1)
            System.out.print((char) x);
            
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                fis.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
    }
}
