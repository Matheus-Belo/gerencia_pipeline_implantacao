package matheusbelo.todosimple.testeUnitario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import matheusbelo.todosimple.models.Paciente;

public class PacienteTesteUnitario {

    private Paciente paciente;

    @BeforeEach
    void setup() {
        paciente = new Paciente( null, "Matheus", "Belo", 'M', LocalDate.of(2002, 12, 17), (short) 170, 70.5, "12345678900");
    }

    @Test
    public void testRetornarImc() {
        assertEquals(24.39, paciente.getImc(), 0.01);
    }

    @Test
    public void testRetornarPesoIdeal() {
        assertEquals(65.59, paciente.obterPesoIdeal(), 0.01);
    }

    @Test
    public void testRetornarCpfOfuscado() {
        assertEquals("***.456.***-**", paciente.obterCpfOfuscado());
    }

    @Test
    public void testRetornarSituacaoIMC() {
        assertEquals("Peso normal", paciente.obterSituacaoIMC());

        paciente.setPeso(95);
        assertEquals("Obesidade I", paciente.obterSituacaoIMC());

        paciente.setPeso(110);
        assertEquals("Obesidade II (severa)", paciente.obterSituacaoIMC());
    }

    @Test
    public void testRetornarCalculoIMC() {
        assertEquals(24.39, paciente.getImc(), 0.01);
    }

    @Test
    public void testRetonarCalculoIdade() {
        LocalDate data = LocalDate.of(2002, 12, 17);
        paciente.setNascimento(data);
        assertEquals(21, paciente.calcularIdade());
    }

    @Test
    public void testShouldValidarCpf() {
        assertEquals(false, paciente.returnValidarCPF());

        paciente.setCpf("14783602670");
        assertEquals(true, paciente.returnValidarCPF());
    }
    
}
