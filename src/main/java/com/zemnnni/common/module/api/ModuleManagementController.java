package com.zemnnni.common.module.api;

import com.zemnnni.common.module.domain.service.ModuleManagementService;
import com.zemnnni.common.module.dto.ModuleManagementResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "모듈관리", description = "메뉴관리와 같은 개념으로 생성형 메뉴를 관리")
@RestController
@RequestMapping("/module-management")
public class ModuleManagementController {

    private final ModuleManagementService moduleManagementService;

    public ModuleManagementController(ModuleManagementService moduleManagementService) {
        this.moduleManagementService = moduleManagementService;
    }

    @Operation(summary = "모듈관리 목록 조회")
    @GetMapping("/list")
    public ResponseEntity<List<ModuleManagementResponse>> getModuleManagementList() {
        return ResponseEntity.ok(moduleManagementService.getModuleManagementList());
    }

    @Operation(summary = "모듈관리 상세 조회")
    @GetMapping("/{moduleId}")
    public ResponseEntity<ModuleManagementResponse> getModuleManagement(@PathVariable("moduleId") String moduleId) {
        return ResponseEntity.ok(moduleManagementService.getModuleManagement(moduleId));
    }
}
