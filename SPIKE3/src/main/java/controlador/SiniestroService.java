package controlador;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SiniestroService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "siniestro";

	public void addSiniestro(Siniestro sini) {
		if (!mongoTemplate.collectionExists(Siniestro.class)) {
			mongoTemplate.createCollection(Siniestro.class);
		}
		sini.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(sini, COLLECTION_NAME);
	}

	public List<Siniestro> listSiniestro() {
		return mongoTemplate.findAll(Siniestro.class, COLLECTION_NAME);
	}

	public void deleteSiniestro(Siniestro sini) {
		mongoTemplate.remove(sini, COLLECTION_NAME);
	}

	public void updateSiniestro(Siniestro sini) {
		mongoTemplate.insert(sini, COLLECTION_NAME);
	}
}
