package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ClientResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/register/sub/{subOrganizationCode}")
    public List<ClientResponseDTO> registerToSubOrg(@RequestBody @Valid List<ClientRequestDTO> clientRequestDTOS,@PathVariable(value="subOrganizationCode") String subOrganizationCode){

        List<ClientResponseDTO> clientResponseDTOS =clientService.registerToSubOrg(clientRequestDTOS,subOrganizationCode);
        return clientResponseDTOS;

    }
    @PostMapping("/register/org/{organizationCode}")
    public List<ClientResponseDTO> registerToOrg(@RequestBody @Valid List<ClientRequestDTO> clientRequestDTOS,@PathVariable(value="organizationCode") String organizationCode){

        List<ClientResponseDTO> clientResponseDTOS =clientService.registerToOrg(clientRequestDTOS,organizationCode);
        return clientResponseDTOS;

    }
}
