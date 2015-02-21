package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.net.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

	
	@Autowired
	private SiniestroRepository repositorySini;
	
	private static TemplateEngine templateEngine;
	
		    
	private static void initializeTemplateEngine() {
	        
	        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	        	        
	        templateResolver.setTemplateMode("XHTML");	       
	        templateResolver.setPrefix("/WEB-INF/templates/");
	        templateResolver.setSuffix(".html");	        
	        templateResolver.setCacheTTLMs(Long.valueOf(3600000L));	        	      
	        templateResolver.setCacheable(true);
	        
	        templateEngine = new TemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver);
	        
	}
	
	public static TemplateEngine getTemplateEngine() {
	        return templateEngine;
	}

	public static void main(String[] args) {
		
		initializeTemplateEngine();
		SpringApplication.run(Application.class, args);
	}

//	@Override
	public void run(String... args) throws Exception {
			
		repositorySini.deleteAll();

		// save a couple of siniestros
		repositorySini.save(new Siniestro("4720BNL", "0000001", "VF1DA050525512550", "RENAULT", "RENAULT MEGANE DYNAMIQUE 1900 DCI COUPE", "01/01/2014", "A42 KM 30", "Siniestro total"));
		
		
		// Clases que se cargan
		/*
		URLClassLoader Cargador = (URLClassLoader)ClassLoader.getSystemClassLoader();
		URL[] cjto = Cargador.getURLs();
		System.err.println("Classpath size: " + cjto.length);
		for (int i=0; i < cjto.length; i++)
			System.err.println(i + " " + cjto[i].toString()); 
		*/
				
		System.out.println("Siniestros found with findAll():");
		System.out.println("-------------------------------");
		for (Siniestro sini : repositorySini.findAll()) {
			System.out.println(sini);
		}
		System.out.println();

	}
}


