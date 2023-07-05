package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectsRequestDTO {
    @NotNull(message = "Name is mandatory")
    private String projectCode;
    @NotBlank(message = "Name is mandatory")
    private String projectTitle;

    private Status status;
    @NotNull(message = "Name is mandatory")
    private LocalDate StartDate;
    @NotNull(message = "Name is mandatory")
    private LocalDate endDate;




}
