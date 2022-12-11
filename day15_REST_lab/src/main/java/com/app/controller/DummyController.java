package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // mandatroy class level annotation that consists of @Controller +
				// @ResposnseBody(for marshalling-serialisation-java to json) added on all
				// request handling methods(@RequestMapping, @GetMapping, @PostMapping)
@RequestMapping("/dummy")
public class DummyController {
	public DummyController() {
		// TODO Auto-generated constructor stub
		System.out.println("in def ctr of " + getClass());
	}

	// add res handling method(REST API end point) to return representation of a
	// dummy resource
	@GetMapping
	public List<Number> getNumberList() {
		System.out.println("in method of getNumber List");
		return List.of(11, 22, 33, 44, 55); // handler return the resource annotated with @ResponseBody --> DS sees this
											// ann and skips the view resolver and directly does marshalling coverting
											// java object to json array of numbers
	}
}
