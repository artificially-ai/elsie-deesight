package ai.ekholabs.cv.client;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(serviceId = "elsie-deesight")
public interface ElsieDeeSightFeignClient {

}
