package petStore.pojo.petDTO;

import lombok.Data;

@Data
public class PetStoreResponse {
    private Integer code;
    private String type;
    private String message;
}
