import java.io.FileWriter;
import java.io.IOException;

public class DataWriteIntoFile {
    public static void main(String[] args) {
        
        char[] cbuf = {'j', 'A', 'V', 'A'};
        String lang = "Language";
        FileWriter fos = null;

        try{
            fos = new FileWriter("C:/javame/jiyoon1/src/data5.txt");
            fos.write(cbuf);
            fos.write("\n--------------------\n");
            fos.write(lang);
        }

        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                fos.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
    }
}
