import HomeTask5.task1.FileInput;
import HomeTask5.task3.FileFind;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileFindTest {

    @Test
    public static void findInt() throws IOException {
        FileInput fileInput = new FileInput(new File("test5.txt"));
        String str = "" ;
        fileInput.reader();
        fileInput.upWord();
        System.out.println(str);
        Assert.assertEquals("DSAF WQEGB  EWHFBB gg d", str);

    }
}
