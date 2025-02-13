/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numberprocessor;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
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
    
    public static void main(String[] args) {
        NumberProcessor g = new NumberProcessor();
        int low = 1;
        int high = 100;
        int guess = (low+high)/2;
        final int TOO_LOW = 1;
        final int TOO_HIGH = 2;
        final int CORRECT = 3;
        Random rand = new Random();
        ArrayList<String> responses = new ArrayList<>();
        responses.add("Is it ");
        responses.add("Oh I know it is ");
        responses.add("Could it be ");
        responses.add("My guess is ");
        String response = responses.get(rand.nextInt(responses.size()));
        boolean keepPlaying = true;
        
        g.say("Enter a number between 1-100 and i'll guess it. I won't look at what you enter.");
        int playerNumber = g.getInteger();
        guess = rand.nextInt(guess - low) + low;
        while (keepPlaying) {
        response = responses.get(rand.nextInt(responses.size()));
        g.say(response + guess);
        g.say("Enter 1 for too low, 2 for too high, 3 for correct");
        int feedback = g.getInteger();
        if (feedback == TOO_LOW) {
            low = guess + 1; // Increase the low bound if the guess was too low
            guess = rand.nextInt(high - low + 1) + low; // Generate a new guess within the new range
        } 
        else if (feedback == TOO_HIGH) {
            high = guess - 1; // Decrease the high bound if the guess was too high
            guess = rand.nextInt(high - low + 1) + low; // Generate a new guess within the new range
        }
        else if (feedback == CORRECT){
            if ( guess == playerNumber) {
            ArrayList<String> winningResponses = new ArrayList<>();
            winningResponses.add("gg no re");
            winningResponses.add("It's too easy");
            winningResponses.add("I'm just better");
            winningResponses.add("L");
            String winningResponse = winningResponses.get(rand.nextInt(responses.size()));
            g.say(winningResponse);
            }
            else{
                g.say("You didn't have to let me win.");
            }
            keepPlaying = false;
        }
        else {
            g.say("Yeah");
            keepPlaying = false;
            }
        }
    }
    
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
            JOptionPane.showMessageDialog(null, "The number is a whole number", "Warning: Missinput" ,JOptionPane.WARNING_MESSAGE, null);
        }
        return value;
    }
        
public int getInteger() {
        int result = -1;
        
        // Keep asking for input until a valid integer is entered
        while (result == -1) {
            String userInput = JOptionPane.showInputDialog("Enter a whole number:");
            result = process(userInput, false); 
            if (result == -1) {
                 result = this.getInteger();
            }
        }
        
        return result;
    }

public void say(String message) {
        JOptionPane.showMessageDialog(null,message);
}








}
