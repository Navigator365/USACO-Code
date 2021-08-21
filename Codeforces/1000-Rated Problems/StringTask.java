import java.io.*;
import java.util.*;

public class StringTask {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String word = r.readLine().toLowerCase();
        int arrayLength = word.length();
        char[] storageArr = new char[word.length()];
        int indexCounter = 0; 

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || 
                word.charAt(i) == 'i' || word.charAt(i) == 'o' ||
                    word.charAt(i) == 'u' || word.charAt(i) == 'y') {
                        arrayLength--;
                    }
            else {
                arrayLength++;
                storageArr[indexCounter] = word.charAt(i);
                indexCounter++;
            }
        }

        char[] charArray = new char[arrayLength];
        int index = 0; 
        for(int i = 0; i < arrayLength; i+=2) {
            charArray[i] = '.';
            charArray[i+1] = storageArr[index];
            index++;
        }

        pw.println(charArray);
        pw.close();
    }
}
