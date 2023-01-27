package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController
{
	/**
	 * Simple Hello World Controller that returns a String in the response body
	 * Invoke using /test1 URI
	 * 
	 * @return Hello World test string
	 */
	@GetMapping("/test1")
	@ResponseBody
	public String printHello()
	{
		// Simply return a String in the response body (must use the @ResponseBody annotation
		return "Hello World!";
	}
	
	/**
	 * Simple Hello World Controller that returns a View Name along with a Model Attribute names message.
	 * Invoke using /test2 URI
	 * @param model
	 * @return
	 */
	
	@GetMapping("/test2")
    public String printHello(Model model) 
	{
        model.addAttribute("message", "Hello Spring MVC Framework");
        return "hello";
    }
	
	@GetMapping("/test3")
    public ModelAndView printHello1() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", new String("Hello World from ModelAndView!"));
        mv.addObject("message2", new String("Another Hello World from ModelAndView"));
        mv.setViewName("hello");
        return mv;
    }

    @GetMapping("/test4")
    public String printHell(@RequestParam("message") String message, Model model){
        model.addAttribute("message", message);
        return "hello";
    }
}

