package petStore.pojo.builders;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class PetRequestBuilder {
    @Builder.Default
    private Integer id = 7;
    @Builder.Default
    private Category category = null;
    @Builder.Default
    private String name = "niger";
    @Builder.Default
    private ArrayList<String> photoUrls = null;
    @Builder.Default
    private ArrayList<Tag> tags = null;
    @Builder.Default
    private String status = "adopted";

    public static class Tag{
        private Integer id;
        private String name;
    }

    public static class Category{
        private Integer id;
        private String name;
    }
}
