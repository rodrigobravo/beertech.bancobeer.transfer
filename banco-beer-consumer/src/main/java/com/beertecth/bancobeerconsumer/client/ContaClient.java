package com.beertecth.bancobeerconsumer.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.beertecth.bancobeerconsumer.model.OperacaoMessage;

@Service
public class ContaClient {
	
	@Value("${banco.url}")
	private String bancoUrl;

	public void sendOperation(OperacaoMessage message) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<OperacaoMessage> request = new HttpEntity<>(message);
		ResponseEntity<OperacaoMessage> response = restTemplate
		  .exchange(bancoUrl, HttpMethod.POST, request, OperacaoMessage.class);
	}	
}