package com.example.demo.resources;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Worker;
import com.example.demo.repositories.WorkerRepository;

@RefreshScope
@RestController //para ser um recurso web que vai disponibilizar endpoints
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

//	@Value("${test.config}")
//	private String testConfig;
	
	@Autowired
	private Environment env;
	
	// Endpoint para retornar todos os trabalhadores do banco de dados
	@Autowired    //Para que o próprio Spring possa injetar a dependencia de formar automatica
	private WorkerRepository repository;
	
//	@GetMapping(value = "/configs")
//	public ResponseEntity<Void> getConfigs() {
//		logger.info("CONFIG = " + testConfig);
//		return ResponseEntity.noContent().build();
//	}	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){    // ResponseEntity<> encapsula uma resposta http
		
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);  
	}
	
}
