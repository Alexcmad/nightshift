package com.alex.nightshift.nightshift.controller;

import com.alex.nightshift.nightshift.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/s3")
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String rawFileUrl = s3Service.uploadFile(file);
            String parsedFileUrl = rawFileUrl.replaceAll(" ", "+");
            return ResponseEntity.ok(parsedFileUrl);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error uploading file");
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<String> getDownloadUrl(@PathVariable String fileName) {
        URL url = s3Service.generateDownloadUrl(fileName);
        return ResponseEntity.ok(url.toString());
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        s3Service.deleteFile(fileName);
        return ResponseEntity.ok("File deleted successfully");
    }
}
