package controlador;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SiniestroRepository extends MongoRepository<Siniestro, String> {

	public Siniestro findByMatricula(String matricula);

	public List<Siniestro> findByModelo(String modelo);

}
