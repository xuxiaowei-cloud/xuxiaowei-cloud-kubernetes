package cloud.xuxiaowei.gateway;

import io.kubernetes.client.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.kubernetes.commons.KubernetesClientProperties;
import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryClient;
import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryClientAutoConfiguration;
import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryClientProperties;
import org.springframework.cloud.kubernetes.discovery.KubernetesReactiveDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 程序执行入口
 *
 * @author xuxiaowei
 * @since 0.0.1
 * @see Config
 * @see KubernetesDiscoveryClientProperties
 * @see KubernetesClientProperties
 * @see KubernetesDiscoveryClient
 * @see KubernetesReactiveDiscoveryClient
 * @see KubernetesDiscoveryClientAutoConfiguration
 * @see org.springframework.cloud.kubernetes.client.discovery.KubernetesDiscoveryClientAutoConfiguration.KubernetesInformerDiscoveryConfiguration
 * @see Config#ENV_KUBECONFIG
 * @see Config#ENV_SERVICE_HOST
 * @see Config#ENV_SERVICE_PORT
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping("/")
public class GatewayApplication {

	private DiscoveryClient discoveryClient;

	@Autowired
	public void setDiscoveryClient(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@GetMapping
	public List<String> index() {
		List<String> services = discoveryClient.getServices();
		for (String service: services) {
			log.info(service);
		}
		return services;
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
