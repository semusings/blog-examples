package bhuwanupadhyay.springbootjwttoken;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootJwtTokenApplicationTests {

    @Autowired
    private TestRestTemplate rest;
    @LocalServerPort
    private int serverPort;

    @Test
    public void canLogin() {
        ResponseEntity<HashMap> response = rest.postForEntity(rootUri() + "/api/auth/login", login(), HashMap.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    public void canRefresh() {
        ResponseEntity<HashMap> loginResponse = rest.postForEntity(rootUri() + "/api/auth/login", login(), HashMap.class);
        HttpHeaders headers = new HttpHeaders();
        HashMap body = Optional.ofNullable(loginResponse.getBody()).orElseThrow(() -> new IllegalArgumentException("Not Logged In"));
        headers.add("Authorization", body.get("tokenType") + " " + body.get("accessToken"));
        ResponseEntity<HashMap> refreshResponse = rest.exchange(rootUri() + "/api/auth/refresh", HttpMethod.GET, new HttpEntity<>(headers), HashMap.class);
        assertEquals(HttpStatus.OK, refreshResponse.getStatusCode());
    }

    @Test
    public void canCallSecuredApi() {
        ResponseEntity<HashMap> loginResponse = rest.postForEntity(rootUri() + "/api/auth/login", login(), HashMap.class);
        HttpHeaders headers = new HttpHeaders();
        HashMap body = Optional.ofNullable(loginResponse.getBody()).orElseThrow(() -> new IllegalArgumentException("Not Logged In"));
        headers.add("Authorization", body.get("tokenType") + " " + body.get("accessToken"));
        ResponseEntity<String> helloOk = rest.exchange(rootUri() + "/api/hello", HttpMethod.GET, new HttpEntity<>(headers), String.class);
        assertEquals(HttpStatus.OK, helloOk.getStatusCode());
        assertEquals("Welcome!", helloOk.getBody());
    }

    private LoginDto login() {
        LoginDto dto = new LoginDto();
        dto.setUsername("developerbhuwan");
        dto.setPassword("Password");
        return dto;
    }

    private String rootUri() {
        return "http://localhost:" + serverPort;
    }

}
