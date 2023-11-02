package petStore.pojo.storeDTO;

import lombok.Data;

@Data
public class StorePostResponse {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;
}
