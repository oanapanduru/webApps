package ro.calculator.demowebapp;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	
	public String badInput(String first, String second, String operator, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		model.addAttribute("operator", operator);
		return "badInput";
	}

	public String sum(String first, String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int sum = Integer.parseInt(first) + Integer.parseInt(second);
		model.addAttribute("sum", sum);
		return "sum";
	}

	public String subtract(String first, String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int result = Integer.parseInt(first) - Integer.parseInt(second);
		model.addAttribute("result", result);
		return "subtract";
	}

	public String multiply(String first, String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int result = Integer.parseInt(first) * Integer.parseInt(second);
		model.addAttribute("result", result);
		return "multiplication";
	}

	public String divide(String first, String second, Model model) {
		model.addAttribute("first", first);
		model.addAttribute("second", second);
		int result = Integer.parseInt(first) / Integer.parseInt(second);
		model.addAttribute("result", result);
		return "division";
	}
	
}
