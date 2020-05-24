import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        String line = "Lorem ipsum dolor sit amet, consectetur  adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String [] wordMassive = line.replace("  ", " ").split(" ");

        String[] result = makeArrayOfUniqueSymbolsWords(wordMassive);
        for (String word : result){
            System.out.println(word);
        }


    }

    public static String[] makeArrayOfUniqueSymbolsWords (String[] line){
        String[] result = new String[20];
        int i = 0;
        for (String word : line){
            if(checkUniqueSymbolsWord(word)){
                word = word.replace(",","");
                result[i++] = word;
            }
        }
        result = Arrays.copyOf(result, i);
        return result;
    }

    public static boolean checkUniqueSymbolsWord (String word){
        for (int i = 0; i<(word.length()-1); i++){
            if (word.lastIndexOf(word.charAt(i)) != i){
                return false;
            }
        }
        return true;
    }
}
