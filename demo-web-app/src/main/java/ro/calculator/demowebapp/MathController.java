package ro.calculator.demowebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.lang3.StringUtils;

@Controller
@RequestMapping("/mathematics")
public class MathController {
	
	@Autowired
	CalculatorService calculatorService;

	@GetMapping("/maths")
	public String doMath(@RequestParam(name = "first", required = true) String first,
			@RequestParam(name = "second", required = true) String second,
			@RequestParam(name = "operator", required = true) String operator, Model model) {
		boolean validOp = false;
		String res = "";
		operator = operator.toUpperCase();
		if (operator.equals("SUM") || operator.equals("SUB") || operator.equals("MUL") || operator.equals("DIV")) {
			validOp = true;
		}
		if (StringUtils.isNumeric(first) && StringUtils.isNumeric(second) && validOp) {
			int first1 = Integer.parseInt(first);
			int second2 = Integer.parseInt(second);
			switch (operator) {
			case "SUM":
				res = calculatorService.sum(first, second, model);
				break;
			case "SUB":
				res = calculatorService.subtract(first, second, model);
				break;
			case "MUL":
				res = calculatorService.multiply(first, second, model);
				break;
			case "DIV":
				res = calculatorService.divide(first, second, model);
				break;
			default:
				res = calculatorService.badInput(first, second, operator, model);
			}

		} else {
			res = calculatorService.badInput(first, second, operator, model);
		}
		return res;
	}

	

}
