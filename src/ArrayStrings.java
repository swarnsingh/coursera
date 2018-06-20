import java.util.Arrays;

/**
 * @author Swarn Singh.
 */
public class ArrayStrings {

    public static void main(String[] args) {
        String str1 = "abcdefghijklmnopqrstuvwxyz";
        String str2 = "zbcdefghijklmnopqrstuvwxya";
        System.out.println("String : " + str1 + " has unique characters : " + isUniqueChars(str1));

        System.out.println("Permutation : " + permutation(str1, str2));
    }

    private static boolean hasUniqueCharacters(String str) {

        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (c == str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    private static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    private static boolean permutation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        str1 = new String(char1);
        str2 = new String(char2);

        return str1.equals(str2);
        /*for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i])
                return false;
        }
        return true;*/
    }
}
