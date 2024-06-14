package utils;

import org.apache.commons.lang3.StringUtils;

public class CustomFunctions {
	public static String capitalizeFirstLetter(String input) {
		if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.split("\\s+");
        if (words.length == 0) {
            return input; // No need to capitalize if there are no words
        }
        // Capitalize the first letter of the first word
        words[0] = capitalizeWord(words[0]);
        // Join the words back into a single string
        return String.join(" ", words);
    }
	private static String capitalizeWord(String word) {
        return StringUtils.capitalize(word);
    }
	
}

