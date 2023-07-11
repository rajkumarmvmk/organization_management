package com.example.siliconvalley_prvtd_lmtd.service;



import com.example.siliconvalley_prvtd_lmtd.entity.User;
import com.example.siliconvalley_prvtd_lmtd.exception.ErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.exceptionBox.customException.BaseErrorCodes;
import com.example.siliconvalley_prvtd_lmtd.exceptionBox.customException.BaseException;
import com.example.siliconvalley_prvtd_lmtd.exceptionBox.customException.BusinessException;
import com.example.siliconvalley_prvtd_lmtd.repository.UserRepository;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.AuthenticationRequest;
import com.example.siliconvalley_prvtd_lmtd.requestDTO.RegisterRequest;
import com.example.siliconvalley_prvtd_lmtd.responseDTO.AuthenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

//@RequiredArgsConstructor
//@Service
@Slf4j
@Component
public class AuthenticationService {
  @Autowired
  private  UserRepository repository;
@Autowired
 private  BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private JwtService jwtService;
@Autowired
  private  AuthenticationManager authenticationManager;



  public AuthenticationResponse register(RegisterRequest request) throws BusinessException {
   User userRecord =repository.getByEmail(request.getEmail());
    if(!request.getEmail().equals(userRecord.getEmail())){
      log.info(String.valueOf(repository.findByEmail(request.getEmail())));
      var user = User.builder()
              .firstname(request.getFirstname())
              .lastname(request.getLastname())
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .role(request.getRole())
              .build();
       repository.save(user);
      var jwtToken = jwtService.generateToken(user);
      var refreshToken = jwtService.generateRefreshToken(user);
      return AuthenticationResponse.builder()
              .accessToken(jwtToken)
              .refreshToken(refreshToken)
              .build();
    }else{
      throw new BusinessException(BaseErrorCodes.DUPLICATE_RECORD.name(),BaseErrorCodes.DUPLICATE_RECORD.message());
    }
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
        .build();
  }



  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      var user = this.repository.findByEmail(userEmail)
              .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, user)) {
        var accessToken = jwtService.generateToken(user);
        var authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}
