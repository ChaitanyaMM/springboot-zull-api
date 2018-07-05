package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/product")

public class ProductController {
	

	@RequestMapping(value = "/pro", method = RequestMethod.GET)
	@ResponseBody
	public String sample() {
		System.out.println("Sample is calling <><>s");

		return "Sample in webservices-api is up!!!!!";

	}

	/*
	 * @RequestMapping(value="/")
	 * 
	 * @ResponseBody public String home() { return "Hello MMBit"; }
	 */
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@ResponseBody
	public String getHello() {
		return "Hello image Api is working";
	}

}
