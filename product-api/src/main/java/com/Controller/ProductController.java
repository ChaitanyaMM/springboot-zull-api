package com.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Eyedentify.User;
import com.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/product")
// @Slf4j
public class ProductController {

	@Autowired
	UserRepository userepo;

	@RequestMapping(value = "/pro", method = RequestMethod.GET)
	@ResponseBody
	public String sample() {
		System.out.println("Sample is calling <><>s");

		return "Sample in product-api is up!!!!!";

	}

	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	@ResponseBody
	public String getHello() {
		return "Hello @C";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> Createsection(@RequestBody String data)
			throws IOException, ParseException {
		System.out.println("sample insert is calling ");
		User estimate = new User();

		try {
			estimate = new ObjectMapper().readValue(data, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("entered");
		// Date ts=new Date(System.currentTimeMillis());

		User fecthed = userepo.save(estimate);
		System.out.println("Checking after");

		map.put("Data", fecthed);
		map.put("message", "Data! Successfully. !.");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

	// @ApiOperation(value = "find-all", response = Sample.class)
	@RequestMapping(value = "/find-all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> findestimatebystatus() throws IOException {
		System.out.println("find-estimates");
		List<User> fecthed = userepo.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Data", fecthed);
		map.put("message", "Successfully Retrieved data");
		map.put("status", true);
		return ResponseEntity.ok().body(map);
	}

}
