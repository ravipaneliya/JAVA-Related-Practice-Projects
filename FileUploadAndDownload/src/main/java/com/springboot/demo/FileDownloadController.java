package com.springboot.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController {

	@GetMapping("/download")
	public ResponseEntity<Object> downloadFile() throws FileNotFoundException{
		String file = "src\\main\\resources\\static\\myfile.txt";
		
		File f = new File(file);
		InputStreamResource isr = new InputStreamResource(new FileInputStream(f));
		HttpHeaders hh = new HttpHeaders();
		hh.add("Content-Disposition",String.format("attachment;filename=\"%s\"", f.getName()));
		hh.add("Cache-Control", "no-cache,no-store,must-revalidate");
		hh.add("pragma", "no-cache");
		hh.add("Expires", "0");
		
		ResponseEntity<Object> res = ResponseEntity.ok().headers(hh).contentLength(f.length()).contentType(MediaType.parseMediaType("application/txt")).body(isr);
		
		return res;
	}
}
