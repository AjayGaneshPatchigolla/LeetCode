import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encodedUrl=URLEncoder.encode(longUrl,StandardCharsets.UTF_8);
        return encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String decodedUrl=URLDecoder.decode(shortUrl,StandardCharsets.UTF_8);
        return decodedUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));