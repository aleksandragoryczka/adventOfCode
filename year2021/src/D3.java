package year2021.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.SysexMessage;

public class D3 {
    public static void main(String[] args) throws IOException{
        String filePath = "year2021//inputs//D3//D3.txt";
        

        //partOne(filePath);
        partTwo(filePath);
    }

    private static void partOne(String filePath) throws IOException{

        List<String> inputList = year2021.utilities.Utilities.inputReadByColumns(filePath);
        StringBuilder sbGamma = new StringBuilder();
        StringBuilder sbEpsioln = new StringBuilder();
        for(String column: inputList){
            long oneCount = column.chars().filter(ch -> ch == '1').count();
            long zeroCount = column.chars().filter(ch -> ch == '0').count();
            if(oneCount > zeroCount){
                sbGamma.append('1');
                sbEpsioln.append('0');
            }else{
                sbGamma.append('0');
                sbEpsioln.append('1');
            }
        }
        System.out.println(Integer.parseInt(sbGamma.toString(), 2) * Integer.parseInt(sbEpsioln.toString(), 2)); 
    }

    private static void partTwo(String filePath) throws IOException{
        List<String> inputList = year2021.utilities.Utilities.inputReadToListOfLines(filePath);
        String strCo2 = "", strOxygen = "";

        StringBuilder oxygenSb = new StringBuilder();
        StringBuilder co2Sb = new StringBuilder();
        for(int i = 0; i < inputList.get(0).length(); i++){
            List<String> tempListOxygen = new ArrayList<String>();
            List<String> tempListCo2 = new ArrayList<String>();
            for(String line: inputList){
                if(oxygenSb.isEmpty() && co2Sb.isEmpty()){
                    tempListOxygen.add(line.substring(0, 1));
                    tempListCo2.add(line.substring(0, 1));
                }
                else if(line.substring(0, i).equals(oxygenSb.toString())){
                    tempListOxygen.add(line);
                }else if(line.substring(0, i).equals(co2Sb.toString())){
                    tempListCo2.add(line);
                }
            }
            if(tempListCo2.size() != 1){
                co2Sb.append(determineCharToKeep(tempListCo2, false));
            }else {
                strCo2 = co2Sb.replace(0, i, tempListCo2.get(0)).toString();
            }
            
            if(tempListOxygen.size() != 1){
                oxygenSb.append(determineCharToKeep(tempListOxygen, true));
            }else{
                strOxygen = oxygenSb.replace(0, i, tempListOxygen.get(0)).toString();
            }
        }
        if(strCo2.isBlank()){
            strCo2 = co2Sb.toString();
        }else if(strOxygen.isBlank()){
            strOxygen = oxygenSb.toString();
        }
        System.out.println(strCo2);
        System.out.println(strOxygen);
        System.out.println(Integer.parseInt(strOxygen, 2) * Integer.parseInt(strCo2, 2) );
    }

    private static char determineCharToKeep(List<String> lines, boolean rateFlag){
        int oneCount = 0, zeroCount = 0;
        for(String line: lines){
            if(line.charAt(line.length() - 1) == '1'){
                oneCount += 1;
            }else{
                zeroCount +=1;
            }
        }
        if(rateFlag){
            if(oneCount >= zeroCount){
                return '1';
            }else{
                return '0';
            }
        }else{
            if(oneCount < zeroCount){
                return '1';
            }else{
                return '0';
            }
        }

    }
    
}
