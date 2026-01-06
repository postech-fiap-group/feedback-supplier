package org.fiap.seguranca.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.avaliacao.entity.UsuarioEntity;

import java.util.Set;

@ApplicationScoped
public class AuthService {

    public String gerarToken(UsuarioEntity usuario) {

        return Jwt.issuer("fiap-api")
                .upn(usuario.email)
                .groups(Set.of(usuario.role.name()))
                .sign();
    }
}

