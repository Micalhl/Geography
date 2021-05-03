public class CityInfo {

    private final String name;
    private final String city;

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
            if (name == null && city == null) {
                throw new NullPointerException("name and city mustn't be null.");
            }
            if (name == null) {
                throw new NullPointerException("name mustn't be null");
            }
            if (city == null) {
                throw new NullPointerException("city mustn't be null");
            }
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
