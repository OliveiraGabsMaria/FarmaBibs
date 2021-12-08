package br.com.farmabibs.FarmaBibs.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.farmabibs.FarmaBibs.Model.Medicamentos;

@Repository
public interface MedicamentosRepository extends JpaRepository<Medicamentos, Long> {
	
	public List<Medicamentos> findAllByNomeContainingIgnoreCase (String nome);
}
