package org.fiap.seguranca.service;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.fiap.avaliacao.entity.UsuarioEntity;
import org.fiap.avaliacao.repository.UsuarioRepository;
import org.fiap.seguranca.dto.LoginRequestDTO;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    @PermitAll
    public String login(LoginRequestDTO dto) {

        System.out.println("DTO EMAIL = [" + dto.email + "]");
        System.out.println("DTO SENHA = [" + dto.senha + "]");

        UsuarioEntity usuario =
                UsuarioEntity.find("email", dto.email).firstResult();

        if (usuario == null) {
            System.out.println("USUÁRIO NÃO ENCONTRADO");
            throw new NotAuthorizedException("Credenciais inválidas");
        }

        System.out.println("SENHA BANCO = [" + usuario.senha + "]");
        System.out.println("IGUAIS?     = " + usuario.senha.equals(dto.senha));

        if (!usuario.senha.equals(dto.senha)) {
            throw new NotAuthorizedException("Credenciais inválidas");
        }

        return authService.gerarToken(usuario);
    }
}
