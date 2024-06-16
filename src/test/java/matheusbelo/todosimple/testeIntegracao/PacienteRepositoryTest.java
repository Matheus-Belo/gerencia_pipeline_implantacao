package matheusbelo.todosimple.testeIntegracao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;

import matheusbelo.todosimple.models.Paciente;
import matheusbelo.todosimple.repository.PacienteRepository;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    private Paciente paciente;

    @BeforeEach
    void setup(){
        paciente = new Paciente(null, "Matheus", "Sobrenome", 'M', LocalDate.of(2002, 12, 17), (short) 170, 70.5, "12345678900");
        pacienteRepository.save(paciente);
    }

    @Test
    public void testShouldFindPacienteById() {
        Paciente found = pacienteRepository.findById(paciente.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertEquals(paciente.getNome(), found.getNome());
    }

    @Test
    public void testShouldCalculateIMC() {
        Paciente found = pacienteRepository.findById(paciente.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertEquals(24.39, found.getImc(), 0.01);
    }

    @Test
    public void testShouldGetSituacaoIMC() {
        Paciente found = pacienteRepository.findById(paciente.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertEquals("Peso normal", found.obterSituacaoIMC());

        found.setPeso(85);
        pacienteRepository.save(found);

        Paciente updated = pacienteRepository.findById(found.getId()).orElse(null);
        assertThat(updated).isNotNull();
        assertEquals("Acima do peso", updated.obterSituacaoIMC());
    }
}
