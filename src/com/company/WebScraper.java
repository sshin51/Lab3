import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        String script = urlToString("http://erdani.com/tdpl/hamlet.txt");
        /**
         * System.out.println(script.toUpperCase());
         */

        wordCount(script);
        countWord(script, "hamlet");

    }


    public static int wordCount(String script) {
        String[] count = script.split("\\s+");

        System.out.println(count.length);
        return count.length;
    }


    public static int countWord(String script, String word) {
        int count = 0;
        String wordUppercase = word.toUpperCase();
        String scriptUppercase = script.toUpperCase();
        String[] splitScript = scriptUppercase.split("\\s+");
        for (int i = 0; i < splitScript.length; i++) {
            if (splitScript[i].contains(wordUppercase)) {
                count += 1;
            }
        }
        System.out.println(count);
        return count;
    }

}
