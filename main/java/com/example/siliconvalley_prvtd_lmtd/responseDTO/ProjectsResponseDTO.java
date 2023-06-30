package com.example.siliconvalley_prvtd_lmtd.responseDTO;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class ProjectsResponseDTO {

    private String projectCode;
    private String projectTitle;
    private Status status;
    private LocalDate StartDate;
    private LocalDate endDate;




}
