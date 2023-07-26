package com.lee.controller;


import com.lee.common.Result;
import com.lee.services.UploadAvaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
public class UploadAvaterController {

    @Autowired
    private UploadAvaterService uploadAvaterService;

    @PostMapping("/uploadAvater")
    public Result<?> uploadAvater(String username, MultipartFile file, HttpServletRequest req) throws IOException {
        String path = req.getServletContext().getRealPath("/avater/");
        System.out.println();
        String filename = saveFile(file, path);
        uploadAvaterService.uploadAvater(username, "avater/" + filename);
        HashMap<String, String> map = new HashMap<>();
        map.put("imgUrl", "avater/" + filename);
        return Result.success(map);
    }

    public String saveFile(MultipartFile f, String path) throws IOException {
        File upDir = new File(path);
        if (!upDir.exists()) {
            upDir.mkdir();
        }
        String filename = new Date().getTime() + f.getOriginalFilename();
        File file = new File(path + filename);
        f.transferTo(file);
        return filename;

    }
}


