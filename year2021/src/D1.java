package year2021.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class D1 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        String filePath = "year2021//inputs//D1//D1.txt";
        List<Integer> inputList = year2021.utilities.Utilities.inputReadToListOfInteger(filePath);

        //partOne(inputList);
        partTwo(inputList);
    }

    private static void partOne(List<Integer> inputList){
        int increasingCounter = 0;
        for(int i = 1; i < inputList.size(); i++){
            if(inputList.get(i) > inputList.get(i-1)){
                increasingCounter += 1;
            }
        }
        System.out.println(increasingCounter);
    }

    private static void partTwo(List<Integer> inputList) throws NumberFormatException, IOException{
        List<Integer> measuresSumList = new ArrayList<Integer>();

        for(int i = 1; i < inputList.size() - 1; i++){
            measuresSumList.add(inputList.get(i-1) + inputList.get(i) + inputList.get(i+1));
        }
        partOne(measuresSumList);
    }
}