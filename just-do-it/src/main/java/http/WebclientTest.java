//package http;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//public class WebclientTest {
//
//    public static void testGet() {
//    }
//
//    public static void main(String[] args) {
//
//        final  Logger logger = LoggerFactory.getLogger(WebclientTest.class);
//        Mono<String> mono = WebClient.builder().build()
//                .get() // GET 请求
//                .uri("http://jsonplaceholder.typicode.com/posts/1")  // 请求路径
//                .retrieve() // 获取响应体
//                .bodyToMono(String.class); //响应数据类型转换
//        logger.debug(mono.block());
//    }
//
//}
