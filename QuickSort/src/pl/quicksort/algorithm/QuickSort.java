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

    private String stringValues;
    private ArrayList<Integer> values;

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

    private void deleteLetters() {

        StringBuilder sb = new StringBuilder(stringValues);
        for (int i = 0; i < sb.length(); i++) {
            System.out.println("Litera=" + sb.charAt(i));
            if (((sb.charAt(i) < 48) || (sb.charAt(i) > 57)) && (sb.charAt(i) != 44)) { // 48=0; 57=9; 44=,
              

                sb.deleteCharAt(i);
                //sb is shorter and shorter --> i--
                i--;
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
