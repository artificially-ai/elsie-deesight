package ai.ekholabs.cv.controller;

import java.io.IOException;

import ai.ekholabs.cv.client.FaceClassifierFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class ElsieDeeSightController {

  private final FaceClassifierFeignClient elsieDeeSightClient;

  @Autowired
  public ElsieDeeSightController(final FaceClassifierFeignClient elsieDeeSightClient) {
    this.elsieDeeSightClient = elsieDeeSightClient;
  }

  @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<byte[]> process(final @RequestParam(value = "image") MultipartFile image) throws IOException {
    return elsieDeeSightClient.process(image);
  }
}
