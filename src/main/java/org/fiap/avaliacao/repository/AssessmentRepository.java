package org.fiap.avaliacao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.avaliacao.entity.Assessment;

@ApplicationScoped
public class AssessmentRepository implements PanacheRepository<Assessment> {
}
