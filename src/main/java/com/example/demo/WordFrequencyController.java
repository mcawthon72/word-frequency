package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WordFrequencyController {

	@PostMapping(value = "/word-frequency", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String countWordFrequency(@RequestBody Object data) throws JsonProcessingException {
		return new WordFrequencyService().determineWordFrequency(data);
	}

}