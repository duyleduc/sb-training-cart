package com.r00t.usermserv.controllers.publIc;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r00t.usermserv.models.DTO.UserDTO;
import com.r00t.usermserv.services.impls.UserServiceImpl;

@RestController
@RequestMapping("api/v1/public/users")
public class UserPublicController {
    @Autowired
    private UserServiceImpl uService;

    @GetMapping(value = "")
    public List<UserDTO> getAllUsers() throws Exception {
        return uService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserDTO getOneByID(@PathVariable BigInteger id) throws Exception {
        return uService.getOneUser(id);
    }
}
