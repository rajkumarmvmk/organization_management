package com.example.siliconvalley_prvtd_lmtd.requestDTO;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubOrganizationIndexRequestDTO {
  private List<SubOrganizationRequestDTO> subOrganizationRequestDTOList;
}
