package com.eyedentify.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.datastax.driver.core.utils.UUIDs;
import com.eyedentify.Entity.Sample;
import com.eyedentify.Repository.SampleRepo2;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping(value = "/sample")
@Component
public class SampleController {

	@Autowired
	SampleRepo2  samplerepo;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String sample() {
		System.out.println("Sample is calling <><>s");

		return "Sample in webservices-api is up!!!!!";

	}

	@RequestMapping(value = "/hi")
	@ResponseBody
	public String getHello() {
		return "Hello image Api is working";
	}
	
	//@ApiOperation(value = "pay", response = Sample.class)
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createsection(@RequestBody String data)
			throws IOException, ParseException {
		System.out.println("sample insert is calling ");
		Sample estimate = new Sample();

		try {
			estimate = new ObjectMapper().readValue(data, Sample.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());
		estimate.setId(UUIDs.timeBased());
		estimate.setActive(false);
		Sample fecthed = samplerepo.save(estimate);
		System.out.println("Checking after");

		map.put("Data", fecthed);
		map.put("message", "Data! Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	// @ApiOperation(value = "find-all", response = Sample.class)
	 @RequestMapping(value = "/find-all", method = RequestMethod.GET)
	 @ResponseBody
	 public ResponseEntity<Map<String, Object>> findestimatebystatus() throws
	 IOException {
	 System.out.println("find-estimates");
	 List<Sample> fecthed = samplerepo.findAll();
	 System.out.println("size<><><>>"+fecthed.size());
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("Data", fecthed);
	 map.put("message", "Successfully Retrieved data");
	 map.put("status", true);
	 return ResponseEntity.ok().body(map);
	 }
	 
	
	
}
