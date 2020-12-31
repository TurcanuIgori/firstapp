package com.firstapp.firstapp.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/guru")
public class GuruController {

  @GetMapping("/{username}")
  public Map guru(@PathVariable String username) {
    Map<String, Object> result = new HashMap<>();
    result.put("message", "Hello " + username + "from GURU controller!");
    result.put("dateTime", LocalDateTime.now());
    return result;
  }
}
