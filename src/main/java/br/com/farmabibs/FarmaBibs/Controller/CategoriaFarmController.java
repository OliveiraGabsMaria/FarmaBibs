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

import br.com.farmabibs.FarmaBibs.Model.CategoriaFarm;
import br.com.farmabibs.FarmaBibs.Repository.CategoriaFarmRepository;
	
	@RestController
	@RequestMapping("/categoria")
	@CrossOrigin(origins = "*",  allowedHeaders = "*")
 public class CategoriaFarmController {
		
		@Autowired
		private CategoriaFarmRepository categoriaFarmRepository;
		
		@GetMapping
		public ResponseEntity<List<CategoriaFarm>> getAll(){
			return ResponseEntity.ok(categoriaFarmRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<CategoriaFarm> getById(@Valid @PathVariable long id){
			return categoriaFarmRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<CategoriaFarm>> getByDescricao (@Valid @PathVariable String descricao){
		return ResponseEntity.ok(categoriaFarmRepository.findAllByDescricaoContainingIgnoreCase(descricao));	
		}
		
		@PostMapping
		public ResponseEntity<CategoriaFarm> postCategoriaFarm (@Valid @RequestBody CategoriaFarm categoria){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(categoriaFarmRepository.save(categoria));
		}
		
		@PutMapping
		public ResponseEntity<CategoriaFarm> putCategoriaFarm (@Valid @RequestBody CategoriaFarm categoria){
			return ResponseEntity.ok(categoriaFarmRepository.save(categoria));
					
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			categoriaFarmRepository.deleteById(id);
		}

}
