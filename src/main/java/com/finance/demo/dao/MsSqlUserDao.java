package com.finance.demo.dao;

import java.sql.Types;
import java.util.UUID;
import com.finance.demo.model.User;
import com.finance.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("mssql")
class MsSqlUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MsSqlUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public boolean isExisting(User user) {
        String sql = "SELECT username FROM users WHERE username = ?";
        boolean exists = jdbcTemplate.queryForObject(sql, new Object[]{user.getUsername()}, (resultSet, i) -> {
            // verify condition
            if (resultSet != null) {
                return true;
            }
            return false;
        });
        return exists;
	}
	
	@Override
	public int insertUser(UUID id, User user) {
        if (isExisting(user)) {
            return 1;
        }
        // TODO add hash
        String sql = "INSERT INTO users (id, username) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{id, user.getUsername()}, new int[]{Types.VARCHAR, Types.VARCHAR});
        return 0;
    }
}