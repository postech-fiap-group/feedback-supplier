package org.fiap.avaliacao.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.fiap.avaliacao.entity.Assessment;

import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class AssesmentService {

 /*   private AssessmentRepository assessmentRepository;

    public AssesmentService(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }
*/
    public List<Assessment> listarTodas() {
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
