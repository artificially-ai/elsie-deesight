package ai.ekholabs.cv.controller;

import java.io.IOException;

import ai.ekholabs.cv.client.FaceClassifierFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
public class ElsieDeeSightController {

  private final FaceClassifierFeignClient faceClassifierFeignClient;

  @Autowired
  public ElsieDeeSightController(final FaceClassifierFeignClient faceClassifierFeignClient) {
    this.faceClassifierFeignClient = faceClassifierFeignClient;
  }

  @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<byte[]> process(final @RequestParam(value = "face") MultipartFile face) throws IOException {
    final HttpHeaders headers = new HttpHeaders();
    headers.setCacheControl(CacheControl.noCache().getHeaderValue());

    final byte[] resultImage = faceClassifierFeignClient.process(face);
    return new ResponseEntity<>(resultImage, headers, HttpStatus.OK);
  }
}
