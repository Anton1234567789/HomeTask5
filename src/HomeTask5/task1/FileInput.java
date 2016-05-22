package HomeTask5.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileInput {
    private File file;
    private static String str;

    public FileInput(File file) {
        this.file = file;
        str = "";
    }
   public static void upWord(){
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (stringTokenizer.hasMoreTokens()){
            String str = stringTokenizer.nextToken().trim();
            if (str.length()>2) {
                stringBuffer.append(str.toUpperCase() + ", ");
            }else {
                stringBuffer.append(str+", ");
            }
        }
        str = stringBuffer.toString();
    }
    public void reader()throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int symbol=0;
        while ((symbol=bufferedReader.read())!=-1){
            str+=(char)symbol;
        }

    }

    public static void main(String[] args) throws IOException{
        FileInput fileI = new FileInput(new File("test.txt"));
        fileI.reader();
        fileI.upWord();
        System.out.println(fileI.str);
    }
}
