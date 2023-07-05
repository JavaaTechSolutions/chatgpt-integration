package com.sc.chatgpt.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTResponse {
	private List<Choice> choices;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Choice {
		private int index;
		private Message message;
	}
}
