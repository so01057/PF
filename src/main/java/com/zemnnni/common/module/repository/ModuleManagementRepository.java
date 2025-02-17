package com.zemnnni.common.module.repository;

import com.zemnnni.common.module.dto.ModuleManagementResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModuleManagementRepository {
    List<ModuleManagementResponse> selectModuleManagementList();
}
