package com.example.siliconvalley_prvtd_lmtd.service;

import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ClientResponseDTO;

import java.util.List;

public interface ClientService {
    List<ClientResponseDTO> registerToSubOrg(List<ClientRequestDTO> clientRequestDTOS,  String subOrganizationCode);
    List<ClientResponseDTO> registerToOrg(List<ClientRequestDTO> clientRequestDTOS,  String organizationCode);
    List<ClientResponseDTO> getAll();
    ClientResponseDTO updateClient(ClientUpdateRequestDTO clientUpdateRequestDTO, String clientCode);
    boolean deactivateRecordByClientCode(String clientCode, Status status);
}
