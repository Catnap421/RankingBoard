package com.bleum.biz.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO(Data Access Object)
@Slf4j
@Repository
public class UserDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // SQL 명령어들
    private final String USER_GET = "select * from ranking_user where email=?";
    private final String USER_INSERT = "insert into ranking_user(id, email, nickname, birth) values(?,?,?,?)";
    private final String USER_EXIST = "select count(*) from ranking_user where email=?";
    // CRUD 기능의 메소드 구현
    // 회원 등록
    public void insertUser(UserDTO dto) {
        System.out.println("===> JDBC로 insertUser() 기능 처리");
        jdbcTemplate.update(USER_INSERT, dto.getId(), dto.getEmail(), dto.getNickname(), dto.getBirth());
    }

    public UserDTO getUser(UserDTO dto) {
        System.out.println("===> JDBC로 getUser() 기능 처리");
        Object[] args = {dto.getEmail()};
        UserDTO user = jdbcTemplate.queryForObject(USER_GET, new UserRowMapper(), args);
        System.out.println("===> user: " + user);
        return user;
    }

    public boolean existUser(UserDTO dto) {
        log.info("===> JDBC로 existUser() 기능 처리");
        Object[] args = {dto.getEmail()};
        int count = jdbcTemplate.queryForObject(USER_EXIST, Integer.class, args);
        return count > 0;
    }
}

class UserRowMapper implements RowMapper<UserDTO> {
    public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDTO user = new UserDTO();
        user.setId(rs.getLong("ID"));
        user.setEmail(rs.getString("EMAIL"));
        user.setNickname(rs.getString("NICKNAME"));
        user.setBirth(rs.getString("BIRTH"));
        return user;
    }
}
