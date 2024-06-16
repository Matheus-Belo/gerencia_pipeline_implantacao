package matheusbelo.todosimple.models;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = Paciente.TABLE_NAME)
public class Paciente {
    
    public interface CreatePaciente {
    }

    public interface UpdatePaciente {
    }

    public static final String TABLE_NAME = "paciente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    @NotNull(groups = CreatePaciente.class)
    @NotEmpty(groups = CreatePaciente.class)
    @Size(groups = CreatePaciente.class, min = 2, max = 100)
    private String nome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    @NotNull(groups = CreatePaciente.class)
    @NotEmpty(groups = CreatePaciente.class)
    @Size(groups = CreatePaciente.class, min = 2, max = 100)
    private String sobrenome;

    @Column(name = "sexo", nullable = false)
    @NotNull(groups = CreatePaciente.class)
    private Character sexo;

    @Column(name = "nascimento", nullable = false)
    @NotNull(groups = CreatePaciente.class)
    private LocalDate nascimento;

    @Column(name = "idade")
    private byte idade;

    @Column(name = "altura", nullable = false)
    @NotNull(groups = CreatePaciente.class)
    @Min(value = 0, groups = CreatePaciente.class)
    private short altura;

    @Column(name = "peso", nullable = false)
    @NotNull(groups = CreatePaciente.class)
    @Min(value = 0, groups = CreatePaciente.class)
    private double peso;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    @NotNull(groups = CreatePaciente.class)
    @NotEmpty(groups = CreatePaciente.class)
    @Size(groups = CreatePaciente.class, min = 11, max = 11)
    private String cpf;

    @JsonProperty(access = Access.WRITE_ONLY)
    private double imc;

    public Paciente() {
    }

    public Paciente(Long id, String nome, String sobrenome, Character sexo, LocalDate nascimento, short altura, double peso, String cpf) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.altura = altura;
        this.peso = peso;
        this.cpf = cpf;
        this.idade = calcularIdade();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Character getSexo() {
        return this.sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public byte getIdade() {
        return this.idade;
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

    public short getAltura() {
        return this.altura;
    }

    public void setAltura(short altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getImc() {
        this.imc = calcularIMC();
        return (float) this.imc;
    }

    private double calcularIMC() {
        double alturaMetros = this.altura / 100.0;
        imc = this.peso / (alturaMetros * alturaMetros);
        return imc;
    }

    public String obterSituacaoIMC() {
        imc = getImc();
        if (imc < 17) {
            return "Muito abaixo do peso";
        } else if (imc >= 17 && imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 30) {
            return "Acima do peso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidade I";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidade II (severa)";
        } else {
            return "Obesidade III (mórbida)";
        }
    }

    public double obterPesoIdeal() {
        double alturaMetros = this.altura / 100.0;
        if (this.sexo == 'M' || this.sexo == 'm') {
            return (72.7 * alturaMetros) - 58;
        } else if (this.sexo == 'F' || this.sexo == 'f') {
            return (62.1 * alturaMetros) - 44.7;
        } else {
            throw new IllegalArgumentException("Sexo deve ser 'M' para masculino ou 'F' para feminino.");
        }
    }
   

    public String obterCpfOfuscado() {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        }
        return "***." + cpf.substring(3, 6) + ".***-**";
    }

    public byte calcularIdade() {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(this.nascimento, hoje);
        return (byte) periodo.getYears();
    }
   
    
    public boolean returnValidarCPF() {
        return validarCpf(cpf);
    }

    private boolean validarCpf(String cpf) {
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") ||
                cpf.equals("33333333333") ||
                cpf.equals("44444444444") ||
                cpf.equals("55555555555") ||
                cpf.equals("66666666666") ||
                cpf.equals("77777777777") ||
                cpf.equals("88888888888") ||
                cpf.equals("99999999999") ||
                cpf.length() != 11)
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - '0');
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + '0');

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - '0');
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + '0');

            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (Exception erro) {
            return false;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Paciente other = (Paciente) obj;
        return Objects.equals(id, other.id) && Objects.equals(cpf, other.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

}