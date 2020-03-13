package com.vivo.wayne.ms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.vivo.wayne.ms.model.Model;
import com.vivo.wayne.ms.model.UsageRequest;
import com.vivo.wayne.ms.model.UsageResponse;
import com.vivo.wayne.ms.service.CdrDatabaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Validated
@ControllerAdvice
public class UsageApiDelegateImpl implements UsageApiDelegate {
	
	private CdrDatabaseService cdrDatabaseService;
    private ObjectMapper objectMapper;
    
	@Autowired
	public UsageApiDelegateImpl(CdrDatabaseService cdrDatabaseService,
			ObjectMapper objectMapper) {
		this.cdrDatabaseService = cdrDatabaseService;
		objectMapper.registerModule(new Jdk8Module());
		this.objectMapper = objectMapper;
	}
	

	@Override
	public ResponseEntity<UsageResponse> createCDR(UsageRequest data) {
		log.debug("createCDR: "+ data);
		try {
			
			Model usageVO = cdrDatabaseService
					.getCdr(null)
					.orElseThrow(() -> new Exception());
			UsageResponse response = new UsageResponse();//objectMapper.convertValue(usageVO, UsageResponse.class);
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, e.getMessage(), e);
		}
    }	
	
	@Override
	public ResponseEntity<Void> deleteCDRbyId(String id, List<String> cdr) {
		log.debug("createCDR: "+ cdr);
		try {
			
			return new ResponseEntity<>( HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, e.getMessage(), e);
		}
    }	

}
