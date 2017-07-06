package ai.ekholabs.cv.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

@FeignClient(serviceId = "elsie-deesight")
public interface ElsieDeeSightFeignClient {

  @PostMapping(path = "elsie-deesight/process", consumes = APPLICATION_OCTET_STREAM_VALUE, produces = APPLICATION_OCTET_STREAM_VALUE)
  byte[] process(final byte[] imageBytes);
}
