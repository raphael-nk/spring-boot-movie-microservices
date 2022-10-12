package demo.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class MovieCatalogServiceApplication {

	@Bean   // producer
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		// Allows you to create timeout 
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000); // 3s
		
		return new RestTemplate(clientHttpRequestFactory); // wait response only in 3s 
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}
	
}
