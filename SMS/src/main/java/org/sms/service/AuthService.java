package org.sms.service;

import org.sms.entities.User;
import org.sms.model.LoginDto;
import org.sms.model.RegisterDto;


public interface AuthService {
    User register(RegisterDto user);
    User login(LoginDto loginDetials);

    boolean checkUserExists(RegisterDto registerDto);
}
