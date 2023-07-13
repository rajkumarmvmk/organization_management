package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ProjectsResponseDTO;

import java.util.List;

public interface BuilderService {
   List<ProjectsResponseDTO> projectsByStatusAndProjectTitle(Status status, String projectTitle);
}
