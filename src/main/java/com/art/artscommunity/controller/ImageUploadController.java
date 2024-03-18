package com.art.artscommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ImageUploadController {

    public static final String uploadDir = "/home/htetaungkyaw/Desktop/spring-complete/Arts Community/src/main/resources/static/images/arts/";

    @GetMapping("/imageUpload")
    public String upload(Model model) {
        File file = new File(uploadDir);
        model.addAttribute("files", file.listFiles());
        return "imageUpload";
    }

    @PostMapping("/upload")
    public String uploadingPost(@RequestParam("uploadFile") MultipartFile[] uploadFile) throws IOException {
        for(MultipartFile upFile : uploadFile) {
            File file = new File(uploadDir + upFile.getOriginalFilename());
            upFile.transferTo(file);
        }

        return "redirect:/artAdd";
    }
}
