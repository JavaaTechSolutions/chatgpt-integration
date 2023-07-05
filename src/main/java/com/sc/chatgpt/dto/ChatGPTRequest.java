package com.sc.chatgpt.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatGPTRequest {
	private String model;

	private List<Message> messages;

}
