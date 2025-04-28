package com.example.fufastorebemongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fufastorebemongo.dto.UserDTO;
import com.example.fufastorebemongo.service.UserService;
import com.example.fufastorebemongo.util.ApiResponse;
import com.example.fufastorebemongo.util.ResponseUtil;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<Object>> getAllUsers() {
        try {
            List<UserDTO> users = this.userService.getAllUsers();
            if (users == null || users.isEmpty()) {
                return ResponseUtil.generateSuccessResponse("No data found.", null, HttpStatus.NOT_FOUND);
            }
            return ResponseUtil.generateSuccessResponse("Get All Data Success",
                    users,
                    HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.generateErrorResponse("Get data failed.", e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
