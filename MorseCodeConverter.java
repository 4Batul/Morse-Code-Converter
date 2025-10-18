import java.util.HashMap;
import java.util.Map;

public final class MorseCodeConverter {
    private static final Map<Character, String> MORSE_DICTION = new HashMap<>();
    private static final Map<String, Character> REVERSE_DICTION = new HashMap<>();

    static {
        MORSE_DICTION.put('A', ".-");
        MORSE_DICTION.put('B', "-...");
        MORSE_DICTION.put('C', "-.-.");
        MORSE_DICTION.put('D', "-..");
        MORSE_DICTION.put('E', ".");
        MORSE_DICTION.put('F', "..-.");
        MORSE_DICTION.put('G', "--.");
        MORSE_DICTION.put('H', "....");
        MORSE_DICTION.put('I', "..");
        MORSE_DICTION.put('J', ".---");
        MORSE_DICTION.put('K', "-.-");
        MORSE_DICTION.put('L', ".-..");
        MORSE_DICTION.put('M', "--");
        MORSE_DICTION.put('N', "-.");
        MORSE_DICTION.put('O', "---");
        MORSE_DICTION.put('P', ".--.");
        MORSE_DICTION.put('Q', "--.-");
        MORSE_DICTION.put('R', ".-.");
        MORSE_DICTION.put('S', "...");
        MORSE_DICTION.put('T', "-");
        MORSE_DICTION.put('U', "..-");
        MORSE_DICTION.put('V', "...-");
        MORSE_DICTION.put('W', ".--");
        MORSE_DICTION.put('X', "-..-");
        MORSE_DICTION.put('Y', "-.--");
        
        MORSE_DICTION.put('0', "-----");
        MORSE_DICTION.put('1', ".----");
        MORSE_DICTION.put('2', "..---");
        MORSE_DICTION.put('3', "...--");
        MORSE_DICTION.put('4', "....-");
        MORSE_DICTION.put('5', ".....");
        MORSE_DICTION.put('6', "-....");
        MORSE_DICTION.put('7', "--...");
        MORSE_DICTION.put('8', "---..");
        MORSE_DICTION.put('9', "----.");

        MORSE_DICTION.put('.', ".-.-.-");
        MORSE_DICTION.put(',', "--..--");
        MORSE_DICTION.put('?', "..--..");
        MORSE_DICTION.put('!', "-.-.--");
        MORSE_DICTION.put('/', "-..-.");
        MORSE_DICTION.put('(', "-.--.");
        MORSE_DICTION.put(')', "-.--.-");
        MORSE_DICTION.put('@', ".--.-.");
        MORSE_DICTION.put('&', ".-...");
        MORSE_DICTION.put(':', "---...");
        MORSE_DICTION.put(';', "-.-.-.");
        MORSE_DICTION.put('=', "-...-");
        MORSE_DICTION.put('+', ".-.-.");
        MORSE_DICTION.put('_', "..--.-");
        MORSE_DICTION.put('"', ".-..-.");
        MORSE_DICTION.put('$', "...-..-");


        MORSE_DICTION.forEach((key, value) -> REVERSE_DICTION.put(value, key));
    }

    public static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        String[] words = text.toUpperCase().split(" ");
        for (int i = 0; i < words.length; i++) {
            for (char w : words[i].toCharArray()) {
                morse.append(MORSE_DICTION.getOrDefault(w, "")).append(" ");
            }
            if (i < words.length - 1) {
                morse.append(" | ");
            }

        }
        String result =morse.toString().trim();
        return result;
    }

    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" \\| ");
        for (int i = 0; i < words.length; i++) {
            for (String code : words[i].split(" ")) {
                text.append(REVERSE_DICTION.getOrDefault(code, '?'));
            }
            if (i < words.length - 1) {
                text.append(" ");
            }
        }
        return text.toString();
    }
}