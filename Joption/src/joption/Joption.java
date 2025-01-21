/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package joption;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joption {

    public static void main(String[] args) {
        try {
            // Ask the user for the number of genres
            String input = JOptionPane.showInputDialog(null, "Enter the number of genres you want:", "Genre Picker", JOptionPane.QUESTION_MESSAGE);
            if (input == null || input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You didn't enter a valid number! Exiting.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int genreCount = Integer.parseInt(input);

            // Predefined list of song genres
            List<String> songGenres = Arrays.asList("Rock", "Pop", "Jazz", "Classical", "Hip-Hop", "Electronic", "Country", "Blues", "Reggae", "Folk");

            // Pick random genres from the predefined list
            List<String> randomGenres = getRandomGenres(songGenres, genreCount);

            // Fetch random Wikipedia topics
            List<String> wikipediaTopics = fetchRandomWikipediaTopics(genreCount);

            // Display the genres and Wikipedia topics to the user
            StringBuilder result = new StringBuilder("Here are your random song genres and Wikipedia topics:\n\n");

            result.append("Song Genres:\n");
            for (int i = 0; i < randomGenres.size(); i++) {
                result.append(i + 1).append(") ").append(randomGenres.get(i)).append("\n");
            }

            result.append("\nWikipedia Topics:\n");
            for (int i = 0; i < wikipediaTopics.size(); i++) {
                result.append(i + 1).append(") ").append(wikipediaTopics.get(i)).append("\n");
            }

            JOptionPane.showMessageDialog(null, result.toString(), "Random Genres and Topics", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number entered! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static List<String> getRandomGenres(List<String> genres, int count) {
        List<String> randomGenres = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int index = random.nextInt(genres.size());
            randomGenres.add(genres.get(index));
        }

        return randomGenres;
    }

    private static List<String> fetchRandomWikipediaTopics(int count) throws Exception {
        List<String> topics = new ArrayList<>();
        String apiUrl = "https://en.wikipedia.org/w/api.php?action=query&list=random&rnlimit=1&format=json";

        while (topics.size() < count) {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the JSON response to extract titles
            String json = response.toString();
            int index = json.indexOf("\"title\":\"");
            if (index != -1) {
                index += 9; // Move past "title":"
                int endIndex = json.indexOf("\"", index);
                if (endIndex != -1) {
                    String title = json.substring(index, endIndex);
                    // Only add valid topics (no colons)
                    if (!title.contains(":")) {
                        topics.add(title);
                    }
                }
            }
        }

        return topics;
    }
}




