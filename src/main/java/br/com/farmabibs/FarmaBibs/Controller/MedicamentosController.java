package br.com.farmabibs.FarmaBibs.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farmabibs.FarmaBibs.Model.Medicamentos;
import br.com.farmabibs.FarmaBibs.Repository.MedicamentosRepository;

@RestController
@RequestMapping("/medicamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicamentosController {
	
	@Autowired
	private MedicamentosRepository medicamentosRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Medicamentos>> getAll(){
		return ResponseEntity.ok(medicamentosRepository.findAll());
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<Medicamentos> GetById(@Valid @PathVariable long id){
		 return medicamentosRepository.findById(id)
		.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}

	  @GetMapping("/nome/{nome}")
	  public ResponseEntity<List<Medicamentos>> GetByNome(@Valid @PathVariable String nome){
		  return ResponseEntity.ok(medicamentosRepository.findAllByNomeContainingIgnoreCase(nome));
		}
	  
	  @PostMapping
	  public ResponseEntity<Medicamentos> postMedicamentos (@Valid @RequestBody Medicamentos medicamentos){
		  return ResponseEntity.status(HttpStatus.CREATED).body(medicamentosRepository.save(medicamentos));

	  }
	  @PutMapping
	  public ResponseEntity<Medicamentos> putMedicamentos (@Valid @RequestBody Medicamentos medicamentos){
		  return ResponseEntity.status(HttpStatus.OK).body(medicamentosRepository.save(medicamentos));
	  }
	  
	  @DeleteMapping("/{id}")
	  public void delete(@PathVariable long id) {
		  medicamentosRepository.deleteById(id);
	  }

}
