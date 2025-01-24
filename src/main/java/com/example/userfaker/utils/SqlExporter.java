package com.example.userfaker.utils;

import com.example.userfaker.model.User;

import java.util.List;

public class SqlExporter {

    public static String exportToSql(List<User> users, String tableName) {
        StringBuilder sqlBuilder = new StringBuilder();

        // Gera um comando INSERT para cada usuário
        for (User user : users) {
            sqlBuilder.append("INSERT INTO ").append(tableName).append(" (name, email, address) VALUES ('")
                    .append(user.getName().replace("'", "''")).append("', '")
                    .append(user.getEmail().replace("'", "''")).append("', '")
                    .append(user.getAddress().replace("'", "''")).append("');\n");
        }

        return sqlBuilder.toString();
    }
}
