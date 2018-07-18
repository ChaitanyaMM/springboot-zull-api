package com.eyedentify.Test.Controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eyedentify.Controller.SampleController;
import com.eyedentify.Entity.Sample;
import com.eyedentify.Repository.SampleRepo2;


@RunWith(SpringRunner.class)
@WebMvcTest(value = SampleController.class, secure = false)
@ContextConfiguration(classes=SampleController.class)
public class SampleControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	 UUID id;
	 
	@MockBean
	private SampleRepo2 samplrep;
	
	@Mock
	private Sample product;

	
	

	
	@Test
	public void create() throws Exception {
	   
		Sample mockCourse = new Sample("kcB",10,false);
		String json = "{\"name\":\"kcB\",\"age\":\"10\",\"active\":\"false\"}";

		String uripath="http://localhost/sample/insert/";

		// samplrep.save add to respond back with mockCourse
		
		Mockito.when(
				samplrep.save(Mockito.any(Sample.class))).thenReturn(mockCourse);

		// Send course as body to uripath
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(uripath)
				.accept(MediaType.APPLICATION_JSON).content(json)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		    System.out.println("response"+response);
		
		/*assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals(uripath,
				response.getHeader(HttpHeaders.LOCATION));*/

	}
	
	
	
	
	
	@Test
	 public void testtofinAll() {
		
		List<Sample> fetched = new ArrayList<Sample>();
		   Sample obj = new Sample("c",10,false);
		    fetched.add(obj);
		  when(samplrep.findAll()).thenReturn(fetched);
		    System.out.println(fetched+" "+fetched.size());
		 
	}
	
	
	
	
	
	
	
	/*@Test
    public void myTest() throws Exception {
		Sample samp =new Sample();
		samp.setId(null);
		samp.setActive(false);
		samp.setAge(32);
		samp.setName("krishna Chaitanya Bodala");
		
		samplrep.save(samp);
    }*/
	
	
	
	
	

}
