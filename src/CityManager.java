import java.util.HashMap;
import java.util.Map;

public class CityManager {

    private static final Map<String, CityInfo> cities = new HashMap<String, CityInfo>() {
        {
            put("北京市", CityInfo.builder().name("京").city("北京").build());
            put("天津市", CityInfo.builder().name("津").city("天津").build());
            put("河北省", CityInfo.builder().name("冀").city("石家庄").build());
            put("山西省", CityInfo.builder().name("晋").city("太原").build());
            put("内蒙古自治区", CityInfo.builder().name("内蒙古").city("呼和浩特").build());
            put("辽宁省", CityInfo.builder().name("辽").city("沈阳").build());
            put("吉林省", CityInfo.builder().name("吉").city("长春").build());
            put("黑龙江省", CityInfo.builder().name("黑").city("哈尔滨").build());
            put("上海市", CityInfo.builder().name("沪").city("上海").build());
            put("江苏省", CityInfo.builder().name("苏").city("南京").build());
            put("浙江省", CityInfo.builder().name("浙").city("杭州").build());
            put("安徽省", CityInfo.builder().name("皖").city("合肥").build());
            put("福建省", CityInfo.builder().name("闽").city("福州").build());
            put("江西省", CityInfo.builder().name("赣").city("南昌").build());
            put("山东省", CityInfo.builder().name("鲁").city("济南").build());
            put("河南省", CityInfo.builder().name("豫").city("郑州").build());
            put("湖北省", CityInfo.builder().name("鄂").city("武汉").build());
            put("湖南省", CityInfo.builder().name("湘").city("长沙").build());
            put("广东省", CityInfo.builder().name("粤").city("广州").build());
            put("广西壮族自治区", CityInfo.builder().name("桂").city("南宁").build());
            put("海南省", CityInfo.builder().name("琼").city("海口").build());
            put("重庆市", CityInfo.builder().name("渝").city("重庆").build());
            put("四川省", CityInfo.builder().name("川/蜀").city("成都").build());
            put("贵州省", CityInfo.builder().name("贵/黔").city("贵阳").build());
            put("云南省", CityInfo.builder().name("云/滇").city("昆明").build());
            put("西藏自治区", CityInfo.builder().name("藏").city("拉萨").build());
            put("陕西省", CityInfo.builder().name("陕/秦").city("西安").build());
            put("甘肃省", CityInfo.builder().name("甘/陇").city("兰州").build());
            put("青海省", CityInfo.builder().name("青").city("西宁").build());
            put("宁夏回族自治区", CityInfo.builder().name("宁").city("银川").build());
            put("新疆维吾尔自治区", CityInfo.builder().name("新").city("乌鲁木齐").build());
            put("香港特别行政区", CityInfo.builder().name("港").city("香港").build());
            put("澳门特别行政区", CityInfo.builder().name("澳").city("澳门").build());
            put("台湾省", CityInfo.builder().name("台").city("台湾").build());
        }
    };

    public static Map<String, CityInfo> getCities() {
        return cities;
    }
}
