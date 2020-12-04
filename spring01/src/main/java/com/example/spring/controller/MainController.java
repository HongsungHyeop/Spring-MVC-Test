package com.example.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.model.dto.PointDTO;
import com.example.spring.model.dto.ProductDTO;

@Controller
public class MainController {
		@RequestMapping("/")
		public String main(Model model) {
			model.addAttribute("name" , "이름이름이름");
			model.addAttribute("message", "안녕하세요 방문을 환영합니다.");
			return "main";
		}
		
		@RequestMapping("gugu.do")
		public String gugu() {
			return "test/gugu";
		}
		
		@RequestMapping("gugu_result.do")
		public String gugu_result(@RequestParam(defaultValue = "3") int dan, Model model) {
			String result = "";
			for(int i = 1; i <= 9; i++) {
				result += dan + "x" + i + "=" + dan * i + "<br>";
			}
			model.addAttribute("result", result);
			return "test/gugu_result";
		}
		
		@RequestMapping("point.do")
		public String point() {
			return "test/point";
		}
		
		@RequestMapping("point_result.do")
		public String point_result(@ModelAttribute PointDTO dto, Model model) {
			
			dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
//			double average = dto.getTotal() / 3.0;
//			dto.setAverage(average);
			String average = String.format("%.2f", dto.getTotal() / 3.0);
			dto.setAverage(Double.parseDouble(average));
			model.addAttribute("dto", dto);
			return "test/point_result";
		}
		
		@RequestMapping("move.do")
		public String move() {
//			return "redirect:/result.do
			return "redirect:/result.do?name=kim&age=20";
		}
		
		@RequestMapping("result.do")
		public String result(Model model
					, @RequestParam(defaultValue = "noname") String name
					, @RequestParam(defaultValue = "10") int age) {
			
			model.addAttribute("name",name);
			model.addAttribute("age", age);
			return "test/result";
		}
		
		@RequestMapping("mav.do")
		public ModelAndView mav() {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("product", new ProductDTO("샤프", 1000));
			//ModelAndView(url, key, value)
			return new ModelAndView("test/mav_result", "map", map);
		}
}
