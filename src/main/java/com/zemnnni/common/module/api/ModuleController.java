package com.zemnnni.common.module.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/module")
public class ModuleController {

    @GetMapping("/list/{getCode}")
    public ResponseEntity<List<Map<String,Object>>> getModuleList(@PathVariable("getCode") String getCode) {
        return null;
    }
}
