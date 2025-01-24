package com.example.userfaker.controller;

import com.example.userfaker.model.User;
import com.example.userfaker.service.UserService;
import com.example.userfaker.utils.SqlExporter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Gerar um único usuário", description = "Gera um único usuário aleatório com nome, e-mail e endereço.")
    @ApiResponse(responseCode = "200", description = "Usuário gerado com sucesso")
    @GetMapping("/user")
    public User getSingleUser() {
        return userService.generateUser();
    }

    @Operation(summary = "Gerar múltiplos usuários", description = "Gera uma lista de usuários aleatórios.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuários gerados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetro de contagem inválido")
    })
    @GetMapping("/users")
    public List<User> getMultipleUsers(@RequestParam(defaultValue = "10") int count) {
        return userService.generateUsers(count);
    }

    @Operation(summary = "Exportar usuários para SQL", description = "Gera um script SQL para inserir usuários aleatórios em um banco de dados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Script SQL gerado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetro de contagem inválido")
    })
    @GetMapping("/users/export-sql")
    public ResponseEntity<String> exportUsersToSql(@RequestParam(defaultValue = "10") int count,
                                                   @RequestParam(defaultValue = "users") String tableName) {
        // Gera os usuários e cria o script SQL
        List<User> users = userService.generateUsers(count);
        String sqlContent = SqlExporter.exportToSql(users, tableName);

        // Retorna o script SQL como texto puro
        return ResponseEntity.ok(sqlContent);
    }

}
