package com.zemnnni.auth.controller;

import com.zemnnni.auth.entity.Auth;
import com.zemnnni.auth.model.request.TokenRequest;
import com.zemnnni.auth.model.token.AuthenticationToken;
import com.zemnnni.auth.model.request.SignInRequest;
import com.zemnnni.auth.service.AuthService;
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
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticationToken> signIn(@RequestBody SignInRequest signInRequest){
        Auth auth = Auth.fromSignInRequest(signInRequest);
        AuthenticationToken signInResult = authService.signIn(auth);

        return ResponseEntity.ok(signInResult);
    }

    @PostMapping("/token")
    public ResponseEntity<AuthenticationToken> getToken(@RequestBody TokenRequest tokenRequest){
        Auth auth = Auth.fromTokenRequest(tokenRequest);
        AuthenticationToken authenticationToken = authService.getToken(auth);

        return ResponseEntity.ok(authenticationToken);
    }

}
