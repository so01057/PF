package com.zemnnni.common.controller.encryption;

import com.zemnnni.common.model.encryption.response.RSAPublicKey;
import com.zemnnni.common.service.encryption.EncryptionService;
import com.zemnnni.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

/**
 * @작성자 : DATA
 * @파일명 : EncryptionController
 * @작성일 : 2025-05-26
 * @설명 :
 */

@RestController
@RequestMapping("/encrypt")
public class EncryptionController {

    private final EncryptionService encryptionService;

    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @PostMapping("/rsa/key-gen")
    public ResponseEntity<Response> createRsaKey() throws NoSuchAlgorithmException {
        encryptionService.createRsaKey();

        return ResponseEntity.ok(Response.builder()
                .httpStatus(HttpStatus.OK)
                .message("RSA Key Generation Successful")
                .build());
    }

    @GetMapping("/rsa/public-key")
    public ResponseEntity<RSAPublicKey> getRsaPublicKey(){
        RSAPublicKey rsaPublicKey = encryptionService.getRsaPublicKey();

        return ResponseEntity.ok(rsaPublicKey);
    }
}
