package matheusbelo.todosimple.DefinicaoSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import matheusbelo.todosimple.models.Paciente;
import matheusbelo.todosimple.repository.PacienteRepository;

@SpringBootTest
public class PacienteSteps {

    @Autowired
    private PacienteRepository pacienteRepository;

    private Paciente paciente;
    private double imc;
    private String situacaoIMC;
    private byte idade;

    @Before
    public void setup() {
        pacienteRepository.deleteAll();
    }

    @Given("existe um paciente com nome {string} e sobrenome {string}")
    public void existe_um_paciente_com_nome_e_sobrenome(String nome, String sobrenome) {
        paciente = new Paciente(null, nome, sobrenome, 'M', LocalDate.of(2002, 11, 6), (short) 170, 70.5, "12345678900");
        pacienteRepository.save(paciente);
    }

    @Given("o paciente tem altura {int} cm e peso {double} kg")
    public void o_paciente_tem_altura_e_peso(Integer altura, Double peso) {
        paciente.setAltura(altura.shortValue());
        paciente.setPeso(peso);
        pacienteRepository.save(paciente);
    }

    @Given("o paciente nasceu em {string}")
    public void o_paciente_nasceu_em(String dataNascimento) {
        LocalDate nascimento = LocalDate.parse(dataNascimento);
        paciente.setNascimento(nascimento);
        pacienteRepository.save(paciente);
    }

    @When("eu calcular o IMC")
    public void eu_calcular_o_IMC() {
        imc = paciente.getImc();
    }

    @When("eu verificar a situação do IMC")
    public void eu_verificar_a_situacao_do_IMC() {
        situacaoIMC = paciente.obterSituacaoIMC();
    }

    @When("eu calcular a idade")
    public void eu_calcular_a_idade() {
        idade = paciente.calcularIdade();
    }

    @Then("o IMC deve ser {double}")
    public void o_IMC_deve_ser(Double expectedImc) {
        assertEquals(expectedImc, imc, 0.01);
    }

    @Then("a situação do IMC deve ser {string}")
    public void a_situacao_do_IMC_deve_ser(String expectedSituacao) {
        assertEquals(expectedSituacao, situacaoIMC);
    }

    @Then("a idade deve ser {int}")
    public void a_idade_deve_ser(Integer expectedIdade) {
        assertEquals(expectedIdade.byteValue(), idade);
    }
}