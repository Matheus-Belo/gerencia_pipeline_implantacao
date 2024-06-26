package matheusbelo.todosimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import matheusbelo.todosimple.models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}