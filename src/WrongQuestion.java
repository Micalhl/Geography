public class WrongQuestion {

    private final CityInfo info;
    private final String name;
    private final String errorName;
    private final String errorCity;

    /**
     * @param info 城市信息
     * @param name 城市全称
     * @param errorName 错误简称
     * @param errorCity 错误省会
     */
    public WrongQuestion(CityInfo info, String name, String errorName, String errorCity) {
        this.info = info;
        this.name = name;
        this.errorName = errorName;
        this.errorCity = errorCity;
    }

    public CityInfo getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public String getErrorCity() {
        return errorCity;
    }

    public String getErrorName() {
        return errorName;
    }

    public static WrongQuestionBuilder builder() {
        return new WrongQuestionBuilder();
    }

    public static class WrongQuestionBuilder {

        private CityInfo info;
        private String name;
        private String errorName;
        private String errorCity;

        public WrongQuestionBuilder info(CityInfo info) {
            this.info = info;
            return this;
        }

        public WrongQuestionBuilder name(String name) {
            this.name = name;
            return this;
        }

        public WrongQuestionBuilder errorName(String errorName) {
            this.errorName = errorName;
            return this;
        }

        public WrongQuestionBuilder errorCity(String errorCity) {
            this.errorCity = errorCity;
            return this;
        }

        public WrongQuestion build() {
            return new WrongQuestion(info, name, errorName, errorCity);
        }
    }

    @Override
    public String toString() {
        return "WrongQuestion{" +
                "info=" + info +
                ", name='" + name + '\'' +
                ", errorName='" + errorName + '\'' +
                ", errorCity='" + errorCity + '\'' +
                '}';
    }
}
