package com.example.marspictures;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mars/pictures")
@RequiredArgsConstructor
public class MarsPictureController {

  private final MarsPictureClient marsPictureClient;

  @GetMapping(value = "/largest", produces = MediaType.IMAGE_JPEG_VALUE)
  public byte[] findLargestMarsPicture(@RequestParam int sol, @RequestParam(required = false) String camera) {
    return marsPictureClient.findLargestMarsPicture(sol, camera);
  }
}
