package com.vivo.wayne.ms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vivo.wayne.ms.model.Model;
import com.vivo.wayne.ms.proxy.CdrDatabaseProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CdrDatabaseService{

	private CdrDatabaseProxy proxy;

	@Autowired
	public CdrDatabaseService(CdrDatabaseProxy proxy) {
		this.proxy = proxy;
	}

	public Optional<Model> getCdr(String id){
		log.debug(id);
		return proxy.getCdr(id);
	}
	
}