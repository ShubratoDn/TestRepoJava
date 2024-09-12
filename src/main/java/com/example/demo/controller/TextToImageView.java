package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextToImageView {

	@GetMapping("/textToImage")
	public String getPage() {
		return "textToImage.html";
	}
	
}
