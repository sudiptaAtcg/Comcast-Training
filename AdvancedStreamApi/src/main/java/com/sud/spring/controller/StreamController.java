package com.sud.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sud.spring.constant.ApiConstant;
import com.sud.spring.model.NumberList;
import com.sud.spring.model.StringList;
import com.sud.spring.response.ApiResponse;
import com.sud.spring.response.SumResult;
import com.sud.spring.service.StreamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiConstant.url)
public class StreamController {
	@Autowired
	private StreamService service;

	@PostMapping("/sum")
	public ResponseEntity<ApiResponse> getSumOfEvenAndTimeDiff(@Valid @RequestBody NumberList request) {

		SumResult result1 = service.sumofEvenNumberParallel(request.getNumbers());
		SumResult result2 = service.sumofEvenNumberSequentil(request.getNumbers());
		String message = "Parallel-stream:Sum=" + result1.getSum() + " time=" + result1.getTime()
				+ "ms Sequential-stream:Sum=" + result2.getSum() + " time=" + result2.getTime() + "ms Time Difference="
				+ (result1.getTime() - result2.getTime());
		ApiResponse response = new ApiResponse(message, HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/groupBy")
	public ResponseEntity<ApiResponse> groupListOfStringsByLength(@Valid @RequestBody StringList request) {
		Map<Integer, List<String>> map = service.groupByLength(request.getStrings());
		String message = "Group: " + map;
		ApiResponse response = new ApiResponse(message, HttpStatus.OK.value());
		return ResponseEntity.ok(response);

	}

	@PostMapping("/partitionBy")
	public ResponseEntity<ApiResponse> partitioningByEvenOddNumber(@Valid @RequestBody NumberList request) {
		Map<Boolean, List<Integer>> map = service.partitioningByEvenOdd(request.getNumbers());
		String message = "Result: " + map;
		ApiResponse response = new ApiResponse(message, HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/custom")
	public ResponseEntity<ApiResponse> getCustomCollector(@Valid @RequestBody StringList request) {
		String result = service.customCollector(request.getStrings());
		String message = "Result String: " + result;
		ApiResponse response = new ApiResponse(message, HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/multiple/{digit}/{count}")
	public ResponseEntity<ApiResponse> getListOfMultiples(@PathVariable Integer digit, @PathVariable Integer count) {
		List<Integer> result = service.generateListOfMultiples(digit, count);
		String message = "Multiple of " + digit + ":" + result;
		ApiResponse response = new ApiResponse(message, HttpStatus.OK.value());
		return ResponseEntity.ok(response);
	}

}
