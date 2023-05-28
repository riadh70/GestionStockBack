package com.bellili.gestiondestock.controller.api;

import com.bellili.gestiondestock.dto.auth.AuthenticationRequest;
import com.bellili.gestiondestock.dto.auth.AuthenticationResponse;
import com.bellili.gestiondestock.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("authentication")
public interface AuthenticationApi {

  @PostMapping(Constants.AUTHENTICATION_ENDPOINT + "/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
