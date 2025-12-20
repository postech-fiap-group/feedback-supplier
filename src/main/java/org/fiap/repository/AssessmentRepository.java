package org.fiap.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.Models.Assessment;

@ApplicationScoped
public class AssessmentRepository implements PanacheRepository<Assessment> {
}
