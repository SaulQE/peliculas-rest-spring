package com.saul.service;

import com.saul.controller.dto.LoginRequest;
import com.saul.controller.dto.LoginResponse;

public interface AuthenticationService
{
    LoginResponse login(LoginRequest loginRequest);
}
