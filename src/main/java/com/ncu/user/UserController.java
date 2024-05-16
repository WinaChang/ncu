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
                "select * from \"user\" where username = '" + request.getUsername() + "' and password = '" + request.getPassword() + "'";

        return String.valueOf(jdbcTemplate.queryForList(sql).size() > 0);
    }

    @PostMapping("/search")
    public String search(@Validated @RequestBody SearchVoReq request) {

        String sql =
                "select id, full_name, nick_name, slogan, price, lock_file_path, lock_file_name, shot_file_name from \"data\" where full_name like '%A人%' and verify_code = 'DA5442F'";

        return String.valueOf(jdbcTemplate.queryForList(sql).size() > 0);
    }
}
