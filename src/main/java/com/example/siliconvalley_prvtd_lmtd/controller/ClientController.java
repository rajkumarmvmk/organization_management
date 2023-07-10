package com.example.siliconvalley_prvtd_lmtd.controller;

import com.example.siliconvalley_prvtd_lmtd.dao.ClientDAO;
import com.example.siliconvalley_prvtd_lmtd.enumBox.Status;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorResponse;
import com.example.siliconvalley_prvtd_lmtd.exceptionBox.response.Response;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.ClientUpdateRequestDTO;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.ClientResponseDTO;
import com.example.siliconvalley_prvtd_lmtd.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/v1/client")
@PreAuthorize("hasAuthority('admin:read')")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/register/sub")
    public ResponseEntity<List<ClientResponseDTO>> registerToSubOrg(@RequestBody @Valid List<ClientRequestDTO> clientRequestDTOS, @RequestParam(value = "subOrganizationCode") String subOrganizationCode) {

        List<ClientResponseDTO> clientResponseDTOS = clientService.registerToSubOrg(clientRequestDTOS, subOrganizationCode);
        return new ResponseEntity<>(clientResponseDTOS,HttpStatus.OK);

    }

    @PostMapping("/register/org")
    public List<ClientResponseDTO> registerToOrg(@RequestBody @Valid List<ClientRequestDTO> clientRequestDTOS, @RequestParam(value = "organizationCode") String organizationCode) {

        List<ClientResponseDTO> clientResponseDTOS = clientService.registerToOrg(clientRequestDTOS, organizationCode);
        return clientResponseDTOS;

    }

    @GetMapping("/getall")
    public ResponseEntity<List<ClientResponseDTO>> GetAll() {
        List<ClientResponseDTO> clientResponseDTOS = clientService.getAll();
        return new ResponseEntity<>(clientResponseDTOS,HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ClientResponseDTO updateClient(@RequestBody @Valid ClientUpdateRequestDTO clientUpdateRequestDTO, @RequestParam(value = "clientCode") String clientCode) {
        ClientResponseDTO clientResponseDTO = clientService.updateClient(clientUpdateRequestDTO, clientCode);
        return clientResponseDTO;
    }

    @DeleteMapping(value = "deactivate")
    public ResponseEntity<?> deactivateRecordByProjectCode(@RequestParam(value = "clientCode") String clientCode, @RequestParam(value = "status") Status status) {
        if (clientService.deactivateRecordByClientCode(clientCode,status)) {
            ErrorResponse errorResponse = new ErrorResponse("CODE_606", "given record deactivate successfully");
            log.info("-------------------------"+clientCode+"-deactivated successfully-----------------");
            return new ResponseEntity<>(errorResponse, HttpStatus.OK);
        } else {
            return null;

        }
    }
}
