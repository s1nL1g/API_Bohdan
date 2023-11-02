package petStore.pojo.builders;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequestBuilder {
    @Builder.Default
    private Integer id = 7;
    @Builder.Default
    private String username = "battery";
    @Builder.Default
    private String firstName = "battery";
    @Builder.Default
    private String lastName = "exotic";
    @Builder.Default
    private String email = "usr@email.com";
    @Builder.Default
    private String password = "pass123";
    @Builder.Default
    private String phone = "+380636363636";
    @Builder.Default
    private Integer userStatus = 0;
}
