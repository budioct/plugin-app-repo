package imam.corp.utilities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecuritySecretKey {

    @Value("${application.security.secret-key}")
    private String secretKey;

    private String getSecretKey() {
        return this.secretKey;
    }

    public String secretKey() {
        return getSecretKey();
    }

}
