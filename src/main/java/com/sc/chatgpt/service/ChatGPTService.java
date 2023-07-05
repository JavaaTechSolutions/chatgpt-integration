package com.sc.chatgpt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sc.chatgpt.dto.ChatGPTRequest;
import com.sc.chatgpt.dto.ChatGPTResponse;
import com.sc.chatgpt.dto.Message;

@Service
public class ChatGPTService {

	@Value("${openai.api.key}")
	private String apiKey;

	private static final String OPEN_API_CHAT_ENDPOINT = "https://api.openai.com/v1/chat/completions";

	public ChatGPTResponse getChatGPTRespone(String prompt) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + apiKey);

		ChatGPTRequest request = new ChatGPTRequest();
		request.setModel("gpt-3.5-turbo");
		request.setMessages(List.of(new Message("user", prompt)));

		HttpEntity<ChatGPTRequest> entity = new HttpEntity<>(request, headers);

		RestTemplate template = new RestTemplate();
		return template.postForObject(OPEN_API_CHAT_ENDPOINT, entity, ChatGPTResponse.class);
	}
}
