package org.fiap.avaliacao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.fiap.avaliacao.enuns.Role;

@Entity
public class UsuarioEntity extends PanacheEntity {

    public String nome;
    public String email;
    public String senha;

    @Enumerated(EnumType.STRING)
    public Role role;
}
