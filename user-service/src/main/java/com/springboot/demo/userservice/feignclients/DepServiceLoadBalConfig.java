/*
 * package com.springboot.demo.userservice.feignclients;
 *No NEED TOPERFORM LOAD BALANCING AS ITS DONE BY API Gateway itself
 * 
 * import org.springframework.cloud.client.loadbalancer.LoadBalanced; import
 * org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient; import
 * org.springframework.context.annotation.Bean;
 * 
 * import feign.Feign;
 * 
 * @LoadBalancerClient(value="department-service") public class
 * DepServiceLoadBalConfig {
 * 
 * @Bean
 * 
 * @LoadBalanced public Feign.Builder feignBuilder(){ return Feign.builder(); }
 * 
 * }
 */