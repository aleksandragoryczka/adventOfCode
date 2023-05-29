package year2021.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2 {
    public static void main(String[] args) throws IOException{
        String filePath = "year2021//inputs//D2//D2_test.txt";
        List<String> inputList = year2021.utilities.Utilities.inputReadToListOfLines(filePath);

        partOne(inputList);
        partTwo(inputList);
    }

    private static void partOne(List<String> inputList){
        int horizontalPosition = 0;
        int depth = 0;
        for(String line: inputList){
            List<String> lineList = new ArrayList<String>(Arrays.asList(line.split(" ")));
            switch(lineList.get(0)){
                case "forward":{
                    horizontalPosition += Integer.parseInt(lineList.get(1));
                    break;
                }
                case "up": {
                    depth -= Integer.parseInt(lineList.get(1));
                    break;
                }
                case "down": {
                    depth += Integer.parseInt(lineList.get(1));
                    break;
                }
            }    
        }
        System.out.println(horizontalPosition * depth);
    }

    private static void partTwo(List<String> inputList){
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for(String line: inputList){
            List<String> lineList = new ArrayList<String>(Arrays.asList(line.split(" ")));
            switch(lineList.get(0)){
                case "forward":{
                    horizontalPosition += Integer.parseInt(lineList.get(1));
                    depth += Integer.parseInt(lineList.get(1)) * aim;
                    break;
                }
                case "up": {
                    aim -= Integer.parseInt(lineList.get(1));
                    break;
                }
                case "down": {
                    aim += Integer.parseInt(lineList.get(1));
                    break;
                }  
            }  
        }
        System.out.println(horizontalPosition * depth);
    }
    
}
