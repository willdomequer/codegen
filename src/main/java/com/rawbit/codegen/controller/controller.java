package com.rawbit.codegen.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Files;
import java.util.HashMap;


//@Controller
//@RequestMapping{"codegen/"}
//public class controller {
//
//    @RequestMapping(value = "genProject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ResponseEntity<byte[]> genProject (@RequestParam HashMap<String, String> projInfoMap) {
//
//        String projZip = new String("rawbit.zip".getBytes("UTF-8"), "ISO-8859-1");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentDispositionFormData("attachment", projZip);
//
//        byte[] buffer = Files.readAllBytes(projZip);
//        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(buffer, headers, HttpStatus.CREATED);
//
//        return responseEntity;
//    }
//}
