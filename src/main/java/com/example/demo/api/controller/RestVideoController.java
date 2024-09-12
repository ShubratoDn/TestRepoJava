package com.example.demo.api.controller;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RestVideoController {

    @GetMapping("/videos/{videoName}")
    public ResponseEntity<Resource> getVideo(@PathVariable String videoName) {

    	System.out.println("GOT REQUEST");
        // Construct the path to the video file
//        String videoPath = "" + videoName;
        String videoPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + videoName;

        // Read the video file as a Resource
        Resource videoResource = new FileSystemResource(videoPath);

        // Check if the file exists
        if (!videoResource.exists()) {
        	System.out.println("NOT EXIST");
            return ResponseEntity.notFound().build();
        }

        // Set the appropriate headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename(videoName).build());

        // Serve the video file as a Blob
        return ResponseEntity.ok()
                .headers(headers)
                .body(videoResource);
    }
}
