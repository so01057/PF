package com.zemnnni.common.module.domain.service;

import com.zemnnni.common.module.dto.ModuleManagementResponse;
import com.zemnnni.common.module.repository.ModuleManagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleManagementService {

    private final ModuleManagementRepository moduleManagementRepository;

    public ModuleManagementService(ModuleManagementRepository moduleManagementRepository) {
        this.moduleManagementRepository = moduleManagementRepository;
    }

    public List<ModuleManagementResponse> getModuleManagementList() {
        return moduleManagementRepository.selectModuleManagementList();
    }
}
