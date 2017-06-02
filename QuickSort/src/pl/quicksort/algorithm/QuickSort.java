/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.quicksort.algorithm;

import java.util.ArrayList;

/**
 *
 * @author Marcel Woznica
 * @version 1.0
 */
public class QuickSort {

    private String stringValues; //values from textbox
    private ArrayList<Integer> values; //values converted from stringValues

    public QuickSort(String stringValues) {
        this.stringValues = stringValues;
    }

    /**
     * delete unnecessary characters; push value to array; sort values
     */
    public void executeSort() {
        int size;
        StringBuilder sb = new StringBuilder();
        deleteLetters();
        splitString();
        size = values.size();
        quickSort(0, size);  //left index, right index

    }

    /**
     *
     * @return String to MainGui with sorted array
     */
    public String convertToString() {
        StringBuilder sb = new StringBuilder();
        for (Integer v : values) {
            sb.append(" " + v);
        }
        return sb.toString();
    }

    private void deleteLetters() {
        
        StringBuilder sb = new StringBuilder(stringValues);
        int sbSize=sb.length();
        for (int i = 0; i < sbSize; i++) {
            System.out.println("Litera=" + sb.charAt(i));
            if (((sb.charAt(i) < 48) || (sb.charAt(i) > 57)) && (sb.charAt(i) != 44) ) { // 48=0; 57=9; 44=,
                
             if ( (sb.charAt(i) != 45) ){
                sb.deleteCharAt(i);
                 if(i>0) i--;
             }
             
             else if ((i+1)<sbSize && (sb.charAt(i+1) < 48) || (sb.charAt(i) > 57)) {  
                 sb.deleteCharAt(i);
                 if(i>0) i--;
             }
                //sb is shorter and shorter --> i--
              
            sbSize=sb.length();
               
            }
        }

        stringValues = sb.toString();

    }

    private void splitString() {
        String[] parts = stringValues.split(",");
        int parseFromString;
        values = new ArrayList<Integer>(parts.length);

        for (String s : parts) {
            try {
                parseFromString = Integer.parseInt(s);
                values.add(parseFromString);
            } catch (NumberFormatException nfe) {
                System.out.print("Error in function: splitString");
                throw new NumberFormatException();
            };
        }

    }

    private void quickSort(int left, int right) {
        int key, swapIndex;

        if (left < right) {
            key = values.get(left);
            swapIndex = left;
            for (int i = left + 1; i < right; i++) {
                if (values.get(i) < key) {
                    ++swapIndex;
                    swapElement(swapIndex, i);
                }
            }

            swapElement(left, swapIndex);
            quickSort(left, swapIndex);
            quickSort(swapIndex + 1, right);
        }

    }

    private void swapElement(int index1, int index2) {
        int value1 = values.get(index1);
        int value2 = values.get(index2);
        values.set(index2, value1);
        values.set(index1, value2);
    }

}
