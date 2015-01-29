package instilLabQuestions;

import java.io.*;
import java.util.HashMap;


public class Lab1WordCounterAttempt2 {

    static BufferedReader buffer = null;
    //static Scanner keyboard = new Scanner(System.in);

    static String enterFileName() {
        String retVal = null;
        System.out.println("Please Enter File ");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try {
                 retVal= buffer.readLine();
        } catch (IOException e) {

        }
        return retVal;
    }

    static String readFile(String filepath)
    {
        String fileContent = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            fileContent = br.readLine();
            while (fileContent != null) {
                String temp = br.readLine();
                if (temp == null) {
                    break;
                } else {
                    fileContent += " " + temp;
                }
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
        static String [] TokeniseInput (String content) {

           String [] tokens = content.split(" ");
            return tokens;
        }

        static HashMap<String,Integer> wordCount(String[] tokens) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String token : tokens)
        {
            if (map.containsKey(token)) {
                int count = map.get(token).intValue();
                map.put(token, new Integer(count + 1));
            }
                else {
                map.put(token, new Integer(1));
            }
        }
            return map;
        }



    public static void main(String[] args) {

        String filename = enterFileName();
        String content = readFile(filename);
        String [] tokens = TokeniseInput(content);
        HashMap<String,Integer> wordCountMap = wordCount(tokens);

        for (String key : wordCountMap.keySet())
        {
            int value = wordCountMap.get(key).intValue();
            System.out.println(key + " " + value);
        }

    }//main
}//class
