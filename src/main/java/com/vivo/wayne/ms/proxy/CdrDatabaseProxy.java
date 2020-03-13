package com.vivo.wayne.ms.proxy;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vivo.wayne.ms.model.Model;

@Component
@FeignClient(name = "CdrDatabasepi", url = "${servicos.db-api.address}")
public interface CdrDatabaseProxy {

	@GetMapping(path = "${servicos.db-api}/{id}", 
			produces = APPLICATION_JSON_VALUE)
	Optional<Model> getCdr(@PathVariable("id") String id);

	
	
}
