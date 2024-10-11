package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.ListNumberList;
import com.example.demo.model.NumberEntity;
import com.example.demo.model.NumberList;
import com.example.demo.model.StringList;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.FunctionalService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/functions")
public class FunctionalController {

    @Autowired
    private FunctionalService service;
    
	/*
	 * @PostMapping("/calculate") public Integer checkCalculator(@Valid @RequestBody
	 * NumberEntity obj) { return service.performCalculation(obj); }
	 * 
	 * @PostMapping("/even") public List<Integer> filterEven(@Valid @RequestBody
	 * NumberList request) { return service.filterEvenNumbers(request.getNumbers());
	 * }
	 * 
	 * @PostMapping("/length") public List<Integer> getLength(@Valid @RequestBody
	 * StringList request) { return
	 * service.getStringLength(request.getStringList()); }
	 * 
	 * @PostMapping("/filter") public List<String> filterStrings(@Valid @RequestBody
	 * StringList request) { return
	 * service.filterStringList(request.getStringList()); }
	 * 
	 * @PostMapping("/double") public void doubleValue(@Valid @RequestBody
	 * NumberList request) { service.doubleNumberList(request.getNumbers()); }
	 * 
	 * @GetMapping("/random") public List<Integer> getRandomList(){ return
	 * service.getRandomIntegerList(); }
	 * 
	 * @PostMapping("/sort") public List<String> getSortedList(@Valid @RequestBody
	 * StringList request){ return
	 * service.getSortedStringList(request.getStringList()); }
	 */
    
    
    @PostMapping("/calculate")
    public ResponseEntity<ApiResponse> checkCalculator(@Valid @RequestBody NumberEntity obj){
    	Integer result=service.performCalculation(obj);
    	String message="Calculation result: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    
    @PostMapping("/even")
    public ResponseEntity<ApiResponse> filterEven(@Valid @RequestBody NumberList request)
    {
    	List<Integer> result=service.filterEvenNumbers(request.getNumbers());
    	String message="Even Number List: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/length")
    public ResponseEntity<ApiResponse> getLength(@Valid @RequestBody StringList request)
    {
    	List<Integer> result=service.getStringLength(request.getStringList());
    	String message="Length of Strings: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/filter")
    public ResponseEntity<ApiResponse> filterStrings(@Valid @RequestBody StringList request)
    {
    	List<String> result=service.filterStringList(request.getStringList());
    	String message="Filtered List: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/double")
    public ResponseEntity<ApiResponse> doubleValue(@Valid @RequestBody NumberList request)
    {
    	service.doubleNumberList(request.getNumbers()); 
    	String message="Result printed in console";
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @GetMapping("/random")
    public ResponseEntity<ApiResponse> getRandomList()
    {
    	List<Integer> result=service.getRandomIntegerList(); 
    	String message="Random Number List: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/sort")
    public ResponseEntity<ApiResponse> getSortedList(@Valid @RequestBody StringList request)
    {
    	List<String> result=service.getSortedStringList(request.getStringList());; 
    	String message="Sorted List: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    
    
    
    
    ////////////////////////////////////////////////////////////////
    @PostMapping("/even-number")
    public ResponseEntity<ApiResponse> getEvenNumber(@Valid @RequestBody NumberList request)
    {
    	List<Integer> result=service.getEvenNumbers(request.getNumbers());
    	String message="Even Number List: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/sqaure")
    public ResponseEntity<ApiResponse> getSumOfSquares(@Valid @RequestBody NumberList request)
    {
    	Integer result=service.sumOfSquares(request.getNumbers()); 
    	String message="Result is: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/minmax")
    public ResponseEntity<ApiResponse> getMinMax(@Valid @RequestBody NumberList request)
    {
    	Map<String,Integer> result=service.findMinAndMax(request.getNumbers()); 
    	String message="Result: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/department")
    public ResponseEntity<ApiResponse> getEmpByDept(@Valid @RequestBody List<Employee> request)
    {
    	Map<String,List<Employee>> result=service.groupByDepartment(request); 
    	String message="Result: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    
    @PostMapping("/product")
    public ResponseEntity<ApiResponse> getProductOfElements(@Valid @RequestBody NumberList request)
    {
    	Integer result=service.productOfElements(request.getNumbers()); 
    	String message="Result is: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/flat")
    public ResponseEntity<ApiResponse> transformList(@Valid @RequestBody ListNumberList request)
    {
    	List<Integer> result=service.transformListofList(request.getNumbers()); 
    	String message="Result is: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/findFirst")
    public ResponseEntity<ApiResponse> findFirstStartingWithA(@Valid @RequestBody StringList request)
    {
    	String result=service.findFirstStartingWithA(request.getStringList()); 
    	String message="Result is: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    
    @PostMapping("/salary")
    public ResponseEntity<ApiResponse> sortEmployeesBySalaryDesc(@Valid @RequestBody List<Employee> request)
    {
    	List<Employee> result=service.sortBySalaryDesc(request); 
    	String message="Result: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    @PostMapping("/stream")
    public ResponseEntity<ApiResponse> getStreamOfList(@Valid @RequestBody StringList request)
    {
    	List<String> result=service.getStreamsOfStrings(request.getStringList()); 
    	String message="Inserted List: "+request.getStringList()+"    Output: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    
    @PostMapping("/duplicate")
    public ResponseEntity<ApiResponse> removeDuplicates(@Valid @RequestBody NumberList request)
    {
    	List<Integer> result=service.removeDuplicatesNumbers(request.getNumbers()); 
    	String message="Result is: "+result;
    	ApiResponse response=new ApiResponse(message,HttpStatus.OK.value());
    	return ResponseEntity.ok(response);
    }
    
    
    
}

