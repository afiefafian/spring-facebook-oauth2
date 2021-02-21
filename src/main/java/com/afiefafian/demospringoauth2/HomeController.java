package com.afiefafian.demospringoauth2;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("home")
    public String home(Principal principal) {
        Map<String, Object> authDetails =
                (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication()
                .getDetails();

        String username = (String) authDetails.get("name");

        return "Success auth " + username;
    }
}
