package com.springboot.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	@PostMapping("/upload")
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		try {
			byte bytes[]= file.getBytes();
			Path path = Paths.get("D://" + file.getOriginalFilename());
			Files.write(path, bytes);
		} catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
		return "Done";
	}
}
