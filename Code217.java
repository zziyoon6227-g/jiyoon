import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Code217 {
    public static void main(String[] args) {
        
        FileInputStream fis = null;
        byte b[] = new byte[50];
        try{
            fis = new FileInputStream("C:/javame/jiyoon1/src/data1.txt"); //파일 속성에 들어가서 "\"이부분을 /슬래시로 변경후 뒤에 data1.txt 파일명 넣고 여기서 복붙
            fis.read(b);
            for(byte x : b)
            System.out.println((char)x);
        }
        catch(FileNotFoundException e){
            System.out.println("data1.txt는 없는 파일입니다.");
        }
        catch(IOException e){
            System.out.println(e);
        }
        finally{
            try{
                fis.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
            catch(NullPointerException e){
                System.out.println("fis가 null값을 갖고 있습니다.");
            }
        }
    }
}
