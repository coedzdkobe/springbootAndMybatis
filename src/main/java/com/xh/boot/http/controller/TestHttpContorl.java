package com.xh.boot.http.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xh.boot.http.entity.User;


@RestController
public class TestHttpContorl {
	
	@RequestMapping("/doGetControllerOne")
	public String doGetControllerOne(String name,int age) {
		return "nihaoa:"+name+"-------"+age;
	}
	
	@PostMapping("/postControllerOne")
	public User doPostControllerOne(@RequestBody User user) {
		System.out.println(user.toString());
		return user;
	}
	
	
	@PostMapping("/file")
	public String getFiles(@RequestParam("name") String name,@RequestParam("age") int age,@RequestParam("files") List<MultipartFile> multipartFiles) throws IllegalStateException, IOException {
		for (MultipartFile multipartFile2 : multipartFiles) {
			System.out.println(name+age);
			System.out.println(multipartFile2.getOriginalFilename());
			System.out.println(multipartFile2.getName());
			System.out.println(multipartFile2.getSize());
			System.out.println(multipartFile2.getContentType());
			File f = new File("E://"+multipartFile2.getOriginalFilename());
			multipartFile2.transferTo(f);
		}
		return "ok";
	}
	
	@GetMapping("/filterOne")
	public void TestFilter() {
		
		System.out.println("12222222222222222");
	}
}
