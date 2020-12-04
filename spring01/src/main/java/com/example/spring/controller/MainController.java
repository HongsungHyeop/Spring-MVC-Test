package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
		@RequestMapping("/")
		public String main(Model model) {
			model.addAttribute("name" , "이름이름이름");
			model.addAttribute("message", "안녕하세요 방문을 환영합니다.");
			return "main";
		}
		
		@RequestMapping("gugu.do")
		public String write() {
			return "test/gugu";
		}
		
		@RequestMapping("gugu_result.do")
		public String gugu(@RequestParam(defaultValue = "3") int dan, Model model) {
			String result = "";
			for(int i = 1; i <= 9; i++) {
				result += dan + "x" + i + "=" + dan * i + "<br>";
			}
			model.addAttribute("result", result);
			return "test/gugu_result";
		}
}
