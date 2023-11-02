package studyPackAPI.pojoFiles;

public class SingleUserInfoResponseDTO {
    public Data data;
    public Support support;

    public static class Data {
        public Integer id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }

    public static class Support {
        public String url;
        public String text;
    }
}
