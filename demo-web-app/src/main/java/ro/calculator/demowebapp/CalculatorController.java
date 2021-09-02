package ro.calculator.demowebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
@RequestMapping("/math")
public class CalculatorController {
	
	@GetMapping("/sum")
	public String sum(@RequestParam(name = "first", required = true) String first,
			@RequestParam(name = "second", required = true) String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int sum = Integer.parseInt(first)+Integer.parseInt(second);
		model.addAttribute("sum", sum);
		return "sum";
	}
	@GetMapping("/subtract")
	public String subtract(@RequestParam(name = "first", required = true) String first,
			@RequestParam(name = "second", required = true) String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int result = Integer.parseInt(first)-Integer.parseInt(second);
		model.addAttribute("result", result);
		return "subtract";
	}
	@GetMapping("/multiplication")
	public String multiply(@RequestParam(name = "first", required = true) String first,
			@RequestParam(name = "second", required = true) String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int result = Integer.parseInt(first)*Integer.parseInt(second);
		model.addAttribute("result", result);
		return "multiplication";
	}
	@GetMapping("/division")
	public String divide(@RequestParam(name = "first", required = true) String first,
			@RequestParam(name = "second", required = true) String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int result = Integer.parseInt(first)/Integer.parseInt(second);
		model.addAttribute("result", result);
		return "division";
	}
	
}
