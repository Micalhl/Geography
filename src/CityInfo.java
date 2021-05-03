public class CityInfo {

    private final String name;
    private final String city;

    /**
     * 城市
     * @param name 简称
     * @param city 省会
     */
    public CityInfo(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public static CityInfoBuilder builder() {
        return new CityInfoBuilder();
    }

    public static class CityInfoBuilder {

        private String name;
        private String city;

        public CityInfoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CityInfoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public CityInfo build() {
            return new CityInfo(name, city);
        }
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
