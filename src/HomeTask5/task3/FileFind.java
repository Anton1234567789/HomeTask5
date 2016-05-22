package HomeTask5.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileFind {
    /**
     *
     * @param filename - файл в котором будет происходить
     *                 поиск одного из типов:
     *                 Double, String, Boolean, Int.
     */
    public static void findType(String filename){
        Scanner scanner = null;
        try {
            FileReader fr = new FileReader(filename);
            scanner = new Scanner(fr);
            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    System.out.println(scanner.nextInt() + " :int");
                }
                else if (scanner.hasNextBoolean()){
                    System.out.println(scanner.nextBoolean()+ " :boolean");
                }else if(scanner.hasNextDouble()){
                    System.out.println(scanner.nextDouble() + " :double");
                }else {
                    System.out.println(scanner.next() + " : String");
                }
            }
        }catch (FileNotFoundException e){
            System.err.println(e);
        }finally {
            if (scanner!=null){
                scanner.close();
            }
        }
    }
    public static void main(String[] args) {
        FileFind fileFind = new FileFind();
        findType("test3.txt");

    }
}
