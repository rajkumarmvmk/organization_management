package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ProjectsRequestDTO {
    @NotNull(message = "Name is mandatory")
    private Long projectId;
    @NotBlank(message = "Name is mandatory")
    private String projectTitle;
    @NotBlank(message = "Name is mandatory")
    private String organizationName;
    @NotBlank(message = "Name is mandatory")
    private String status;
    @NotBlank(message = "Name is mandatory")
    private Integer projectDuration;
    @NotNull(message = "Name is mandatory")
    private LocalDate StartDate;
    @NotNull(message = "Name is mandatory")
    private LocalDate endDate;




}
