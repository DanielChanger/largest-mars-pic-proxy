package com.example.marspictures;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "mars-picture-client", url = "http://localhost:8080/mars")
public interface MarsPictureClient {

  @Cacheable("pictures")
  @GetMapping(value = "/pictures/largest", produces = MediaType.IMAGE_JPEG_VALUE)
  byte[] findLargestMarsPicture(@RequestParam int sol, @RequestParam(required = false) String camera);
}
