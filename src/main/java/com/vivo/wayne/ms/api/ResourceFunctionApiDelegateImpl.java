package com.vivo.wayne.ms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.vivo.wayne.ms.model.ResourceFunction;
import com.vivo.wayne.ms.model.ResourceFunctionResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Validated
@ControllerAdvice
public class ResourceFunctionApiDelegateImpl implements ResourceFunctionApiDelegate {
	
//	private Service service;
    private ObjectMapper objectMapper;
    
	@Autowired
	public ResourceFunctionApiDelegateImpl(//Service service,
			ObjectMapper objectMapper) {
//		this.Service = service;
		objectMapper.registerModule(new Jdk8Module());
		this.objectMapper = objectMapper;
	}
	

	@Override
	public ResponseEntity<Void> phoneActivationCallback(String id, ResourceFunction data) {
		log.debug("resourceFunctionIdPatch: "+ id + " - " + data);
		try {
			
			return new ResponseEntity<>( HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, e.getMessage(), e);
		}
    }	
	
	@Override
	@Cacheable("searchPhonesToActivateByHardware_query")
	public ResponseEntity<ResourceFunctionResponse> searchPhonesToActivateByHardware(String id, String state, String q) {
		log.debug("searchPhonesToActivateByHardware: "+ id + " - " + state + " - " + q);
		try {
			
			ResourceFunctionResponse response = new ResourceFunctionResponse();
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, e.getMessage(), e);
		}
    }	

}
