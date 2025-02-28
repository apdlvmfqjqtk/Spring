package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {

	@GetMapping("/smain")
	public String smain() {
		return "smain";
	}
	
	@GetMapping("/sprods")
	public String sprods() {
		return "sprods";
	}
	
	@GetMapping("/sprodview")
	public String sprodview() {
		return "sprodview";
	}
	
	@GetMapping("/sptwind")
	public String sptwind() {
		return "sptwind";
	}
	
	@GetMapping("/sptdone")
	public String sptdone() {
		return "sptdone";
	}
	
	
}