package petStore.pojo.builders;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StoreRequestBuilder {
    @Builder.Default
    private Long id = 7L;

    @Builder.Default
    private Long petId = 777L;

    @Builder.Default
    private Long quantity = 77L;

    @Builder.Default
    private String shipDate = "2023-11-02T02:04:15.691Z";

    @Builder.Default
    private String status = "placed";

    @Builder.Default
    private Boolean complete = true;
}
