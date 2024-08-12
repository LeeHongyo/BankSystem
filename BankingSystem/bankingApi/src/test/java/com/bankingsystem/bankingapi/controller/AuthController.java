package com.bankingsystem.bankingapi.controller;

import com.bankingsystem.bankingapi.util.JwtUtil;
import com.bankingsystem.bankingapi.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private MyUserDetailsService userDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/authenticate")
  public Map<String, String> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
      );
    } catch (Exception e) {
      throw new Exception("잘못된 사용자 이름 또는 비밀번호", e);
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails.getUsername());

    Map<String, String> response = new HashMap<>();
    response.put("token", jwt);
    return response;
  }

  public static class AuthRequest {
    private String username;
    private String password;

    // Getters and Setters
    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }
}
