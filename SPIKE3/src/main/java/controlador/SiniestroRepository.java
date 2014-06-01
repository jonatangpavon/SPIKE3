package controlador;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiniestroRepository extends MongoRepository<Siniestro, String> {

    //public Siniestro findByFirstMatricula(String matricula);
    //public List<Siniestro> findByLastname(String modelo);
   

}
