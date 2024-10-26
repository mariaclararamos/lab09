
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private List<Professor> professores = new ArrayList<>();

    // Criação
    @PostMapping
    public Professor adicionarProfessor(@RequestBody Professor professor) {
        professores.add(professor);
        return professor;
    }

    // Leitura
    @GetMapping("/{id}")
    public Professor obterProfessor(@PathVariable int id) {
        return professores.stream().filter(prof -> prof.getId() == id).findFirst().orElse(null);
    }

    // Atualização
    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable int id, @RequestBody Professor professorAtualizado) {
        Professor professor = obterProfessor(id);
        if (professor != null) {
            professor.setNome(professorAtualizado.getNome());
            // Outras atualizações de atributos
        }
        return professor;
    }

    // Remoção
    @DeleteMapping("/{id}")
    public void removerProfessor(@PathVariable int id) {
        professores.removeIf(prof -> prof.getId() == id);
    }
}
