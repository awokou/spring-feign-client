package com.server.spring.feign.client;

import com.server.spring.feign.client.dto.Post;
import com.server.spring.feign.client.dto.reponse.AirlineResponse;
import com.server.spring.feign.client.repository.FeignClientRepository;
import com.server.spring.feign.client.web.WebToolsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignClientApplication {

	private final WebToolsService webToolsService;
	private final FeignClientRepository feignClientRepository;

    public SpringFeignClientApplication(WebToolsService webToolsService, FeignClientRepository feignClientRepository) {
        this.webToolsService = webToolsService;
        this.feignClientRepository = feignClientRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringFeignClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			List<AirlineResponse> airlineResponses = webToolsService.readAirlineData();
			List<Post> listProducts = feignClientRepository.getPosts();
			System.out.println(listProducts);
		};
	}
}
