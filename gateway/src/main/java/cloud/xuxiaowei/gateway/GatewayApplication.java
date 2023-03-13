package cloud.xuxiaowei.gateway;

import io.kubernetes.client.util.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.kubernetes.commons.KubernetesClientProperties;
import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryClient;
import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryClientAutoConfiguration;
import org.springframework.cloud.kubernetes.discovery.KubernetesDiscoveryClientProperties;
import org.springframework.cloud.kubernetes.discovery.KubernetesReactiveDiscoveryClient;

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
 */
@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
