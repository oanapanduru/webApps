package ro.calculator.demowebapp;

import org.springframework.ui.Model;

public interface CalculatorService {
	
	public String badInput(String first, String second, String operator, Model model);

	public String sum(String first, String second, Model model);

	public String subtract(String first, String second, Model model);

	public String multiply(String first, String second, Model model);

	public String divide(String first, String second, Model model);

}
