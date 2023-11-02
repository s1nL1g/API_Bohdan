package petStore.pojo.storeDTO;

import lombok.Data;

import java.util.Date;

@Data
public class GetStoreResponse {
    public Integer id;
    public Integer petId;
    public Integer quantity;
    public Date shipDate;
    public String status;
    public Boolean complete;
}
