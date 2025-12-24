package org.fiap.avaliacao.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class UsuarioEntity extends PanacheEntity {

    public String nome;
    public String email;
}
