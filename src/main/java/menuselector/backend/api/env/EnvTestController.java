package menuselector.backend.api.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvTestController {

    // 환경변수 TEST_SECRET의 값을 가져와서 주입합니다.
    // 만약 못 찾으면 기본값으로 "값을 못 찾았어요!"를 넣습니다.
    @Value("${KEY_TEST:값을 못 찾았어요!}")
    private String testSecret;

    @GetMapping("/env-test")
    public String envTest() {
        return "Infisical 테스트 결과: " + testSecret;
    }
}
