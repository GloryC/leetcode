package p535;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glory
 * @date 2019/10/30 8:43
 */
public class Codec {

    private Map<Integer, String> map = new HashMap<>(1);

    /**
     * Encodes a URL to a shortened URL.
     *
     * @param longUrl
     * @return
     */
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    /**
     * Decodes a shortened URL to its original URL.
     *
     * @param shortUrl
     * @return
     */
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

}
