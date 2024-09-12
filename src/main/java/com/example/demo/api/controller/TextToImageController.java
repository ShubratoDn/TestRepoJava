package com.example.demo.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

@RestController
public class TextToImageController {

    @GetMapping("/generate-image")
    public ResponseEntity<byte[]> generateImageFromText(@RequestParam("text") String text) {
        int width = 300;
        int height = 100;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();

        // Set background color
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);

        // Set text color and font
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 24));

        // Draw text
        graphics.drawString(text, 10, 30);

        // Convert image to byte array
        byte[] imageBytes;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", baos);
            imageBytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("Error generating image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Set up HTTP headers for downloading
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentDispositionFormData("attachment", "text_image.png");

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}
