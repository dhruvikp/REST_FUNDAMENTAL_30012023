package com.simplilearn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		try {
			// Write code to save file somewhere.
			File uploadedFile = new File("D:\\simplilearn\\" + file.getOriginalFilename());
			if (!uploadedFile.exists()) {
				uploadedFile.createNewFile();
			}

			FileOutputStream fos = new FileOutputStream(uploadedFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "File uploaded successfully";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) {
		try {
			File file = new File("D:\\simplilearn\\" + fileName);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=" + fileName);

			return ResponseEntity.ok().headers(headers).contentType(MediaType.parseMediaType("application/txt"))
					.body(resource);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
