package year2021.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public static List<Integer> inputReadToListOfInteger(String filePath) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String str;

        List<Integer> inputList = new ArrayList<Integer>();
        while((str = in.readLine()) != null){
            inputList.add(Integer.parseInt(str));
        }
        return inputList;
    }

    public static List<String> inputReadToListOfLines(String filePath) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        String str;

        List<String> inputList = new ArrayList<String>();
        while((str = in.readLine()) != null){
            inputList.add(str);
        }
        return inputList;
    }

    public static List<String> inputReadByColumns(String filePath) throws IOException{
        List<String> columnData = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        while((line = br.readLine()) != null){
            for(int i = 0; i< line.length(); i++){
                char c = line.charAt(i);
                if(i >= columnData.size()){
                    columnData.add(Character.toString(c));
                }else{
                    columnData.set(i, columnData.get(i) + c);
                }
            }
        }
        return columnData;
    }
}
