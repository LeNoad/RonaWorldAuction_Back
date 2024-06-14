package kr.mmgg.auction.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/discord-login")
    public String getDiscordOauthUrl() {
        return "https://discord.com/oauth2/authorize?client_id=1235200687705559050&response_type=code&redirect_uri=http%3A%2F%2Flocalhost%3A3000&scope=identify+email";
    }
}
