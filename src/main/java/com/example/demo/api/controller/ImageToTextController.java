package com.example.demo.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class ImageToTextController {
	
    @PostMapping("/convert")
    public String convertImageToText(@RequestParam("file") MultipartFile file) throws TesseractException {
        try {
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Users\\shubrato.iwl\\AppData\\Local\\Programs\\Tesseract-OCR\\tessdata"); // Path to Tesseract OCR data
            // Set resolution (for example, 300 DPI)
            tesseract.setTessVariable("user_defined_dpi", "1000");
            
            return tesseract.doOCR(convertMultiPartToFile(file));            
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    
    // Utility method to convert MultipartFile to File
    private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
        }
        return file;
    }
}

