package com.zemnnni.authentication.controller;

import com.zemnnni.authentication.entity.Authentication;
import com.zemnnni.authentication.model.request.TokenRequest;
import com.zemnnni.authentication.model.token.AuthenticationToken;
import com.zemnnni.authentication.model.request.SignInRequest;
import com.zemnnni.authentication.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @작성자 : DATA
 * @파일명 : AuthController
 * @작성일 : 2025-05-07
 * @설명 :
 */

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationToken> signIn(@RequestBody SignInRequest signInRequest) throws Exception {
        Authentication auth = Authentication.fromSignInRequest(signInRequest);
        AuthenticationToken signInResult = authenticationService.signIn(auth);

        return ResponseEntity.ok(signInResult);
    }

    @PostMapping("/oauth2/sign-in")
    public ResponseEntity<AuthenticationToken> oAuth2SignIn(@RequestBody SignInRequest signInRequest) throws Exception {
        Authentication auth = Authentication.fromSignInRequest(signInRequest);
        AuthenticationToken signInResult = authenticationService.signIn(auth);
        return ResponseEntity.ok(signInResult);
    }

    @PostMapping("/token")
    public ResponseEntity<AuthenticationToken> getToken(@RequestBody TokenRequest tokenRequest) throws Exception {
        Authentication auth = Authentication.fromTokenRequest(tokenRequest);
        AuthenticationToken authenticationToken = authenticationService.getToken(auth);

        return ResponseEntity.ok(authenticationToken);
    }
}
