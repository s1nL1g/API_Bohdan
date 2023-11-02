package petStore.pojo.petDTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class GetPetResponse {
    private Integer id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private String status;

    @Data
    public static class Main {
        private List<GetPetResponse> arrResponse;
    }

    @Data
    public static class Tag {
        private Integer id;
        private String name;
    }

    @Data
    public static class Category {
        private Integer id;
        private String name;
    }
}



