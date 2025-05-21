package com.example.member520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.member520.dto.SampleForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";
	}
	
	@PostMapping("/addSample")
	public String addSample(SampleForm sampleForm, Model model) {
		log.info(sampleForm.toString());
		if(sampleForm.getName() == null || sampleForm.getName().length()<4 || sampleForm.getAge()<0 || sampleForm.getAge()>200) {
			model.addAttribute("msg","값에 조건이 맞지 않아 로그인 불일치");
			return "addSample";
		}
		return "redirect:/";
	}
}
