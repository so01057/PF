package com.zemnnni.common.module.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Schema(description = "모듈관리 조회 객체")
public class ModuleManagementResponse {

    @Schema(description = "모듈ID")
    private String moduleId;

    @Schema(description = "모듈명")
    private String moduleName;

    @Schema(description = "모듈유형명")
    private String moduleTypeName;

    @Schema(description = "모듈설명")
    private String moduleDescription;

    @Schema(description = "모듈사용여부")
    @JsonProperty("isModuleUsed")
    private boolean isModuleUsed;

    @Schema(description = "수정자고유ID")
    private String modifierUid;

    @Schema(description = "수정일시")
    private Timestamp modificationDatetime;
}
