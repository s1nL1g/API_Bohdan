package petStore.pojo.petDTO;

import lombok.Data;

@Data
public class PetAddingResponse {
    public Integer id;
    public String name;
    public String status;
}
