package org.fiap.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.model.Assessment;
import org.fiap.repository.AssessmentRepository;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class AssesmentService {

 /*   private AssessmentRepository assessmentRepository;

    public AssesmentService(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }
*/
    public List<org.fiap.model.Assessment> listarTodas() {
//       return assessmentRepository.listAll();
        return Arrays.asList(new Assessment("Tema abordado",10),new Assessment("Material usado na aula", 9));
 }


  /* public Optional<Assessment> buscarPorId(Long id) {
       return assessmentRepository.findByIdOptional(id);
   }


   @Transactional
   public Assessment salvar(Assessment assessment) {
       assessmentRepository.persist(noticia);
       return noticia;
   }


   @Transactional
   public Assessment atualizar(Long id, Assessment assessment) {
       return assessmentRepository.findByIdOptional(id).map(existente -> {
           existente.setTitulo(noticia.getTitulo());
           existente.setConteudo(noticia.getConteudo());
           existente.setDataPublicacao();
           return existente;
       }).orElseThrow(() -> new RuntimeException("Nota não encontrada"));
   }


   @Transactional
   public boolean deletar(Long id) {
       return assessmentRepository.deleteById(id);
   }*/
}
