import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataUtilTest {

    File oldFile = null;
    File newFile = null;


    @Before
    public void setUp() {

        oldFile = new File("oldFileTest.txt");
        newFile = new File("newFileTest.txt");

        if (!newFile.exists()){
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!oldFile.exists()) {
            try {
                oldFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(oldFile);

            fileWriter.write("Hello!" + System.lineSeparator() + "How are you?" + System.lineSeparator() + "Cool");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void getLinesFromFile() {


        List<String> expectedList = new LinkedList<>();
        expectedList.add("Hello!");
        expectedList.add("How are you?");
        expectedList.add("Cool");

        List<String> actualList = DataUtil.getLinesFromFile(oldFile);
        Assert.assertEquals(expectedList, actualList);


    }

    @Test
    public void generateNewFileByList() {


        newFile = DataUtil.generateNewFileByList(DataUtil.getLinesFromFile(oldFile));

        List<String> expectList = new LinkedList<>();
        expectList.add("Cool");
        expectList.add("Hello!");
        expectList.add("How are you?");
        List<String> actualList = DataUtil.getLinesFromFile(newFile);
        Assert.assertEquals(expectList, actualList);


    }

    @Test
    public void sortListByLength() {

        List<String> unSortedList = new LinkedList<>();

        unSortedList.add("Hello");
        unSortedList.add("I");
        unSortedList.add("am");
        unSortedList.add("19 year");
        unSortedList.add("old");


        List<String> expectedList = new LinkedList<>();

        expectedList.add("I");
        expectedList.add("am");
        expectedList.add("old");
        expectedList.add("Hello");
        expectedList.add("19 year");


        List<String> actualList = DataUtil.sortListByLength(unSortedList);

        Assert.assertEquals(expectedList, actualList);

    }
}