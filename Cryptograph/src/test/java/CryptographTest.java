import org.junit.Assert;

import java.io.File;

public class CryptographTest {

    private File file = new File("testFile.txt");




    @org.junit.Test
    public void writeEncryptDataToFile() {

        String dataToEncrypt="Hello,my name is Polina!.";
        String  encryptData = Cryptograph.encryptDataAndWrite(dataToEncrypt,file);

        Assert.assertNotEquals(encryptData,dataToEncrypt);


    }

    @org.junit.Test
    public void decryptDataFromFile() {

        String inputData="Hello.I am 19 year old ?";
        String decryptDataFromFile;
       String encryptData =  Cryptograph.encryptDataAndWrite(inputData,file);

        Assert.assertNotEquals(inputData,encryptData);

        decryptDataFromFile= Cryptograph.decryptDataAndWrite(file);
        Assert.assertEquals(inputData,decryptDataFromFile);


    }
}