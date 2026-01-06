package org.fiap;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;
import io.quarkus.runtime.StartupEvent;
import org.fiap.avaliacao.entity.UsuarioEntity;
import org.fiap.avaliacao.enuns.Role;

@ApplicationScoped
public class UsuarioStartup {

    @Transactional
    void onStart(@Observes StartupEvent ev) {

        if (UsuarioEntity.find("email", "admin@fiap.com").firstResult() == null) {
            UsuarioEntity admin = new UsuarioEntity();
            admin.nome = "Admin";
            admin.email = "admin@fiap.com";
            admin.senha = "123";
            admin.role = Role.ADMIN;
            admin.persist();
        }

        if (UsuarioEntity.find("email", "aluno@fiap.com").firstResult() == null) {
            UsuarioEntity student = new UsuarioEntity();
            student.nome = "Aluno";
            student.email = "aluno@fiap.com";
            student.senha = "123";
            student.role = Role.STUDENT;
            student.persist();
        }

        System.out.println("USUÁRIOS NO BANCO: " + UsuarioEntity.count());
    }
}

