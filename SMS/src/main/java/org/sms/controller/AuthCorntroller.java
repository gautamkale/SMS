package org.sms.controller;

import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sms.model.ErrorCode;
import org.sms.model.ErrorResponse;
import org.sms.model.GenricRepsponse;
import org.sms.model.RegisterDto;
import org.sms.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
public class AuthCorntroller {
private static final Log LOG = LogFactory.getLog(AuthCorntroller.class);
    private final AuthService authService;

    public AuthCorntroller(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<GenricRepsponse> register(@Valid @RequestBody RegisterDto registerDto){
        if(validatePw(registerDto))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(authService.checkUserExists(registerDto)){
            return new ResponseEntity<>(new GenricRepsponse("",new ErrorResponse(HttpStatus.NO_CONTENT.value(),"User already register"
                    ,System.currentTimeMillis(), ErrorCode.ERR_001.toString())),HttpStatus.OK);
        }
        if(authService.register(registerDto) !=null)
            return new ResponseEntity<>(new GenricRepsponse("user register successfully",null),HttpStatus.OK);
        else
            return new ResponseEntity<>(new GenricRepsponse("user failed to register",null),HttpStatus.OK);
    }

    private boolean validatePw(RegisterDto registerDto){
        return (!registerDto.password().equals(registerDto.confirmPassword()));
    }
}
