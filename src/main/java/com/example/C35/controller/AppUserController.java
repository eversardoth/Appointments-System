package com.example.C35.controller;

import com.example.C35.dto.AppUserDTO;
import com.example.C35.entity.AppUser;
import com.example.C35.login.AuthenticationRequest;
import com.example.C35.login.AuthenticationResponse;
import com.example.C35.login.JwtUtil;
import com.example.C35.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class AppUserController {

    private AppUserService appUserService;

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    public AppUserController(AppUserService appUserService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.appUserService = appUserService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value="/register", method= RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody AppUserDTO appUserDTO){
        appUserService.create(appUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("El usuario ha sido creado con exito");
    }

    @RequestMapping(value="/authenticate", method=RequestMethod.POST)
     public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
       try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
           );

       } catch(BadCredentialsException e){
           throw new Exception("Incorrect username or password", e);
       }

       final UserDetails userDetails = appUserService.loadUserByUsername(authenticationRequest.getUsername());

       final String jwt = jwtUtil.generateToken(userDetails);

       return ResponseEntity.ok(new AuthenticationResponse(jwt));


    }
}
