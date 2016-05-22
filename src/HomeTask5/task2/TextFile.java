package HomeTask5.task2;

import java.io.*;
import java.util.*;

public class TextFile extends ArrayList<String>{
    private ArrayList<Integer> numbers;
    private String str ="";
    private File file;
    private int rand[];

    /**
     *
     * @param fileName
     *        имя файла в который записываем.
     * @param capacity
     *          размер массива в куда записываем рандомные числа.
     *          capacity, должно совпадать с кол-вом надомных чисел
     */
    public TextFile(File fileName, int capacity) {
        this.file = fileName;
        numbers = new ArrayList<Integer>();
        rand = new int[capacity];
    }

    /**
     * Метод reader() - читает файл file ("test1.txt"), записывает в "test2.txt".
     * @throws IOException
     * Файлы находятся в корне проекта.
     */
    public void reader() throws IOException {

        FileReader reader = new FileReader(file);
        Writer writer = new FileWriter(new File("test2.txt"));
        int symbol;
        while((symbol = reader.read()) != -1) str += (char) symbol;
        sortRandom(rand);
        for (Integer number: rand){
            writer.write(Integer.toString(number)+", ");
        }
        writer.flush();
        writer.close();
    }

    /**
     *
     * @param fileName - имя файла, куда записуются рандомные числа
     * @param i - кол-во рандомных чисел, должно совпадать с размером
     *          массива rand[];
     * @throws IOException
     */

    public void writeFile(String fileName, int i) throws IOException {
        FileWriter stream = new FileWriter(fileName);
        try{
            for (int j = 0; j< i;j++){
                rand[j] = (int)(Math.random()*100 +1);
                stream.write(Integer.toString(rand[j])+", ");

            }
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            stream().close();
        }

    }

    /**
     *
     * @param rand - массив для сортировки(пузырьком)
     *             внешний цикл сокращает фрагмент массива,
     *             внутренний цикл каждый раз ставит в конец максимальный элемент.
     */
    public static void sortRandom(int[] rand){
        for (int i = rand.length-1;i>0; i--){
            for (int j = 0; j< rand.length-1; j++){
                if (rand[j]> rand[j+1]){
                    int temp = rand[j];
                    rand[j]= rand[j+1];
                    rand[j+1]=temp;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        TextFile textFile = new TextFile(new File("test1"),10);

        textFile.writeFile("test1.txt",10);

        textFile.reader();


    }

}
