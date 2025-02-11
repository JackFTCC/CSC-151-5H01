/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberprocessor;
import javax.swing.JOptionPane;
/**
 *
 * @author solliscj4556
 */
public class NumberProcessor {
    /**
     * Processes a string input and attempts to convert it to an integer.This method demonstrates basic input validation and error handling. 
     * Things to consider:
 1. What should happen if the user enters nothing?
 2. What should happen if the user enters "abc"?
 3. What should happen if the user enters "3.14"?
     * 
     * @param input The string that should be converted to an integer
     * @param isDouble
     * @return A message describing what happened during processing
     */
    public int process(String input, Boolean isDouble) {
        int value = -1;
        try{
            if (isDouble){
                Double dValue = Double.valueOf(input);
                value = dValue.intValue();
            }
            else {
                value  = Integer.parseInt(input);
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, input + " is not an integer!", "Warning: Misinput" ,JOptionPane.WARNING_MESSAGE, null);
        }
        return value;
    }

    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        
        // Test Case 1: Ask for a number
        String userInput = JOptionPane.showInputDialog("Enter a whole number:");
        int result = processor.process(userInput, false);
        if (result != 1){
            JOptionPane.showMessageDialog(null, result);
        }
        else {
            JOptionPane.showMessageDialog(null, userInput + " is not an integer!", "Warning: Misinput" ,JOptionPane.WARNING_MESSAGE, null);
        }
       
        
        // Test Case 2: What happens with invalid input?
        userInput = JOptionPane.showInputDialog("Try entering something that isn't a whole number:");
        result = processor.process(userInput, true);
        JOptionPane.showMessageDialog(null, result);
        if (result != 1){
            JOptionPane.showMessageDialog(null, result);
        }
        else {
            JOptionPane.showMessageDialog(null, userInput + " is not an integer!", "Warning: Misinput" ,JOptionPane.WARNING_MESSAGE, null);
        }
    }
}
