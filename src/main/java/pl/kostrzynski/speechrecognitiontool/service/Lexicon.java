package pl.kostrzynski.speechrecognitiontool.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kostrzynski.speechrecognitiontool.model.LexiconResult;
import pl.kostrzynski.speechrecognitiontool.model.Root;

import java.util.List;

@Service
public class Lexicon {

    @Value("${DIRECTORYUSERNAME}")
    private String directoryUsername;

    @Value("${DIRECTORYPASSWORD}")
    private String directoryPassword;

    public List<LexiconResult> getLexiconInfo(String language, String text) {
        try {
            String link = "https://dictapi.lexicala.com/search?source=global&language=" + language + "&morph=false&text=" +
                    text + "&page=1&page-length=10&analyzed=false";
            String plainCreds = directoryUsername + ":" + directoryPassword;
            byte[] plainCredsBytes = plainCreds.getBytes();
            byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
            String base64Creds = new String(base64CredsBytes);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            HttpEntity<Root> request = new HttpEntity<>(headers);
            ResponseEntity<Root> response = new RestTemplate().exchange(link, HttpMethod.GET, request, Root.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                Root root = response.getBody();
                if (root != null) return root.getResults();
                else return null;
            } else return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
