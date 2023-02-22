package authenticationapp.controller;

import authenticationapp.dto.Userdtoedit;
import authenticationapp.entity.AuthRequest;
import authenticationapp.service.UserClassService;
import authenticationapp.util.BaseResponse;
import authenticationapp.util.JwtUtil;
import authenticationapp.dto.Userdto;
import authenticationapp.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserClassService userClassService ;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to javatechie !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
    // Controller to register a new user
    @PostMapping("/addUser")
    ResponseEntity<?> addUser(@Valid @RequestBody Userdto model) {
        BaseResponse response = userClassService.registerUser(model);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<> (response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    //Controller to update user details
    @PutMapping("/editUser")
    ResponseEntity<?> editUser(@RequestBody Userdtoedit model) {
        BaseResponse response = userClassService.updateDetails(model);
        if (response.getStatusCode() == HttpServletResponse.SC_OK) {
            return new ResponseEntity<> (response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }


}
