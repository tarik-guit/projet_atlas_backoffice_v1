package backoffice.back.services;

import backoffice.back.requestetresponse.SignupRequest;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class Createagent {
  @Autowired
  private catchjwt jwtc;
    @Autowired
    private RestTemplate restTemplate;

    public JSONObject createagentcompte(SignupRequest signup) {
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        this.jwtc.avoirjwt();
        headers.add("Authorization", this.jwtc.getJwt_ml_f());
        HttpEntity<SignupRequest> entity = new HttpEntity<SignupRequest>(signup,headers);

        return restTemplate.exchange(
                "http://localhost:8002/signup", HttpMethod.POST, entity, JSONObject.class).getBody();


    }
}
