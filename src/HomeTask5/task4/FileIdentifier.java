package HomeTask5.task4;

import java.io.*;

public class FileIdentifier {
    /**
     *
     * @param mails - файл имеет логин и почту
     * @param groups - файл имеет логин и группу
     * @param users - выходной поток со всей информацией
     * @throws IOException
     * Метод выводит содержимое файлов mails.txt and groups.txt
     */
    private static void filter(Reader mails, Reader groups, Writer users) throws IOException {
        BufferedReader readMails = new BufferedReader(mails);
        BufferedReader readGroups = new BufferedReader(groups);
        BufferedWriter writerUsers = new BufferedWriter(users);

        String mails1 = readMails.readLine();
        String groups1 = readGroups.readLine();


        while (mails1 != null && groups1 != null) {
            if (!mails1.contains("#") && !groups1.contains("#")) {
                writerUsers.write(mails1 + ";" + groups1.split(";")[1] + "\n");
            }
            mails1 = readMails.readLine();
            groups1 = readGroups.readLine();
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader("mails.txt"));
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("groups.txt"));
        String str="";
        String str1="";
        int symbol=0;
        int symbols=0;
        while ((symbol=bufferedReader.read())!=-1&&(symbols=bufferedReader1.read())!=-1){
            str+=(char)symbol;

            str1+=(char)symbols;
        }
        System.out.println(str);
        System.out.println(" ");
        System.out.println(str1);
        writerUsers.flush();
        writerUsers.close();
    }
    public static void main(String[] args) throws IOException {

        FileReader readMails = new FileReader("mails.txt");
        FileReader readGroups = new FileReader("groups.txt");
        FileWriter writeUsers = new FileWriter("users.txt");

        filter(readMails, readGroups, writeUsers);

        readMails.close();
        readGroups.close();
        writeUsers.close();
    }
}
