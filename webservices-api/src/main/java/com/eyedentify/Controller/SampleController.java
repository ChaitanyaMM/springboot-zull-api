package com.eyedentify.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sample")

public class SampleController {

	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String sample() {

		return "Sample in SWIMS is Up boy!!!!!";

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
