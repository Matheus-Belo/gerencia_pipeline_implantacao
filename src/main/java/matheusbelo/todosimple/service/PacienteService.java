package matheusbelo.todosimple.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import matheusbelo.todosimple.models.Paciente;
import matheusbelo.todosimple.repository.PacienteRepository;


@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente findById(Long id) {
        Optional<Paciente> paciente = this.pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new RuntimeException(
                "Paciente não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
    }

    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Transactional
    public Paciente create(Paciente obj) {
        obj.setId(null);
        return this.pacienteRepository.save(obj);
    }

    @Transactional
    public Paciente update(Paciente obj) {
        Paciente newObj = findById(obj.getId());
        newObj.setNome(obj.getNome());
        newObj.setSobrenome(obj.getSobrenome());
        newObj.setSexo(obj.getSexo());
        newObj.setNascimento(obj.getNascimento());
        newObj.setAltura(obj.getAltura());
        newObj.setPeso(obj.getPeso());
        newObj.setCpf(obj.getCpf());
        return this.pacienteRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.pacienteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
