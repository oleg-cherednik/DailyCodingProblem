import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Oleg Cherednik
 * @since 04.02.2019
 */
public class Solution {

    public static void main(String... args) {
        UrlShortener urlShortener = new UrlShortener();

        String url = "www.microsoft.com";
        String shortUrl;
        System.out.println(url + " - " + (shortUrl = urlShortener.shorten(url)) + " - " + urlShortener.restore(shortUrl));
        System.out.println(url + " - " + (shortUrl = urlShortener.shorten(url)) + " - " + urlShortener.restore(shortUrl));

        url = "www.google.com";
        System.out.println(url + " - " + (shortUrl = urlShortener.shorten(url)) + " - " + urlShortener.restore(shortUrl));
        System.out.println(url + " - " + (shortUrl = urlShortener.shorten(url)) + " - " + urlShortener.restore(shortUrl));
    }
}

final class UrlShortener {
    private final Map<String, String> map = new HashMap<>();
    private final Random random = new Random();
    private final int length = 6;

    public String shorten(String url) {
        String shortUrl;

        do {
            shortUrl = getRandomString(length);
        } while (map.containsKey(shortUrl));

        map.put(shortUrl, url);
        return shortUrl;
    }

    public String restore(String shortUrl) {
        return map.get(shortUrl);
    }

    private String getRandomString(int length) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (random.nextBoolean())
                buf.append(random.nextInt(10));
            else {
                char ch = random.nextBoolean() ? 'A' : 'a';
                ch += random.nextInt(26);
                buf.append(ch);
            }
        }

        return buf.toString();
    }

}
