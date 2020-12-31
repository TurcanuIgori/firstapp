package com.firstapp.firstapp.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/foo")
public class FooController {

  @GetMapping("/{username}")
  public Map foo(@PathVariable String username) {

    createFileIfFolderExists();

    Map<String, Object> result = new HashMap<>();
    result.put("message", "Hello " + username + ", from foo controller!");
    result.put("dateTime", LocalDateTime.now());
    return result;
  }

  private void createFileIfFolderExists() {
    File file = new File("/mnt/sample-file.txt");
    System.out.println("/home/sample-file.txt");
    File parentFolder = new File(file.getParent());
    boolean folderExists = parentFolder.exists();

    if (folderExists) {
      createFileIfNotExists(file);
    } else {
      System.out.println("Parent folder doesn't exists!");
    }
  }

  private void createFileIfNotExists(File file) {
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
    } catch (IOException e) {
      System.out.println(e.getCause());
      System.out.println(e.getStackTrace());
      e.printStackTrace();
    }
  }
}
