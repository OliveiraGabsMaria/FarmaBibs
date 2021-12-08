package br.com.farmabibs.FarmaBibs.Repository;

import java.util.List;
import br.com.farmabibs.FarmaBibs.Model.CategoriaFarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaFarmRepository extends JpaRepository<CategoriaFarm, Long> {

	public List<CategoriaFarm> findAllByDescricaoContainingIgnoreCase (String descricao);
}
