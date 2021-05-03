import java.util.Random;
import java.util.Scanner;

public class Guide {

    public Guide() {
        final String[] keys = CityManager.getCities().keySet().toArray(new String[0]);
        final String randomKey = keys[new Random().nextInt(keys.length)];
        final CityInfo cityInfo = CityManager.getCities().get(randomKey);
        System.out.println("请按顺序输入 " + randomKey + " 城市的 简称 与 省会. 用 | 分割, 多个简称请用 / 分割.");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.next();
        if (input.contains("|")) {
            final String[] args = input.split("\\|");
            boolean pass = true;
            if (cityInfo.getName().contains("/")) {
                if (args[0].contains("/")) {
                    if (cityInfo.getName().contains("/")) {
                        final String[] temp = args[0].split("/");
                        final String[] name = cityInfo.getName().split("/");
                        if (temp[0].equals(name[0])) {
                            if (!temp[1].equals(name[1])) {
                                pass = false;
                            }
                        } else {
                            if (temp[0].equals(name[1])) {
                                if (!temp[1].equals(name[0])) {
                                    pass = false;
                                }
                            } else {
                                pass = false;
                            }
                        }
                    } else {
                        System.out.println(randomKey + " 只有一个简称 " + cityInfo.getName() + ".");
                    }
                } else {
                    System.out.println(randomKey + " 的简称缺少. 正确答案是 " + cityInfo.getName().replace("/", "或"));
                }
            }
            if (!cityInfo.getCity().equals(args[1])) {
                pass = false;
                System.out.println(randomKey + " 的省会错误. 正确答案是 " + cityInfo.getCity() + ".");
            }
            if (pass) {
                System.out.println("你答对了. " + randomKey + " 的简称和省会分别是 " + cityInfo.getName().replace("/", "或") + " " + cityInfo.getCity() + ".");
            }
        } else {
            System.out.println("你输入的不规范. 请按照要求输入.");
        }
        scanner.close();
    }
}
