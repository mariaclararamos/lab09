

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private List<Disciplina> disciplinas = new ArrayList<>();

    // Criação
    @PostMapping
    public Disciplina adicionarDisciplina(@RequestBody Disciplina disciplina) {
        disciplinas.add(disciplina);
        return disciplina;
    }

    // Leitura
    @GetMapping("/{id}")
    public Disciplina obterDisciplina(@PathVariable int id) {
        return disciplinas.stream().filter(disc -> disc.getId() == id).findFirst().orElse(null);
    }

    // Atualização
    @PutMapping("/{id}")
    public Disciplina atualizarDisciplina(@PathVariable int id, @RequestBody Disciplina disciplinaAtualizada) {
        Disciplina disciplina = obterDisciplina(id);
        if (disciplina != null) {
            disciplina.setNome(disciplinaAtualizada.getNome());
            disciplina.setSigla(disciplinaAtualizada.getSigla());
            disciplina.setCurso(disciplinaAtualizada.getCurso());
            disciplina.setSemestre(disciplinaAtualizada.getSemestre());
        }
        return disciplina;
    }

    // Remoção
    @DeleteMapping("/{id}")
    public void removerDisciplina(@PathVariable int id) {
        disciplinas.removeIf(disc -> disc.getId() == id);
    }
}
