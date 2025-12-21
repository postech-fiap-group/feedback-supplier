package org.fiap.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.model.Assessment;

@ApplicationScoped
public class AssessmentRepository implements PanacheRepository<Assessment> {
}
