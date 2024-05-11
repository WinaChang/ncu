package com.ncu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public String login(@Validated @RequestBody LoginVoReq request) {

        String sql =
                "select * from \"user\" where username = '" + request.getUsername() + "'";

        return String.valueOf(jdbcTemplate.queryForList(sql).size() > 0);
    }
}
