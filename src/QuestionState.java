public class QuestionState {

    private final CityInfo info;
    private final String name;
    private final String enterName;
    private final String enterCity;
    private boolean pass;

    public QuestionState(CityInfo info, String name, boolean pass, String enterName, String enterCity) {
        this.info = info;
        this.name = name;
        this.pass = pass;
        this.enterName = enterName;
        this.enterCity = enterCity;
    }

    public CityInfo getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }

    public boolean isPass() {
        return pass;
    }

    public String getEnterName() {
        return enterName;
    }

    public String getEnterCity() {
        return enterCity;
    }

    public static QuestionStateBuilder builder() {
        return new QuestionStateBuilder();
    }

    public static class QuestionStateBuilder {

        private CityInfo info;
        private String name;
        private boolean pass;
        private String enterName;
        private String enterCity;

        public QuestionStateBuilder info(CityInfo info) {
            this.info = info;
            return this;
        }

        public QuestionStateBuilder name(String name) {
            this.name = name;
            return this;
        }

        public QuestionStateBuilder pass(boolean pass) {
            this.pass = pass;
            return this;
        }

        public QuestionStateBuilder enterName(String enterName) {
            this.enterName = enterName;
            return this;
        }

        public QuestionStateBuilder enterCity(String enterCity) {
            this.enterCity = enterCity;
            return this;
        }

        public QuestionState build() {
            return new QuestionState(info, name, pass, enterName, enterCity);
        }
    }

    @Override
    public String toString() {
        return "QuestionState{" +
                "info=" + info +
                ", name='" + name + '\'' +
                ", pass=" + pass +
                '}';
    }
}
