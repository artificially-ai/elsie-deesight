package ai.ekholabs.cv.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@FeignClient(serviceId = "face-classifier")
public interface ElsieDeeSightFeignClient {

  @PostMapping(path = "/process", consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_OCTET_STREAM_VALUE)
  byte[] process(final @PathVariable("face") MultipartFile face);
}
