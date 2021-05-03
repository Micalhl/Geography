import java.util.Random;
import java.util.Scanner;

public class Guide {

    public Guide() {
        try {
            final Scanner scanner = new Scanner(System.in);
            if (score(scanner)) {
                int index = 0;
                int count = 0;
                int continuous = 0;
                do {
                    boolean pass = runGuide(scanner);
                    count = pass ? count + 2 : count;
                    continuous = pass ? continuous + 1 : 0;
                    index++;
                } while (index < 50);
                System.out.println("答题结束! 你的得分: " + count + ", 你连续答对了 " + continuous + " 道题.");
            } else {
                runGuide(scanner);
            }
            scanner.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("你输入的不规范, 请按照要求输入.");
        }
    }

    public boolean runGuide(Scanner scanner) {
        final String[] keys = CityManager.getCities().keySet().toArray(new String[0]);
        final String randomKey = keys[new Random().nextInt(keys.length)];
        final CityInfo cityInfo = CityManager.getCities().get(randomKey);
        boolean pass = true;
        System.out.println("请按顺序输入 " + randomKey + " 城市的 简称 与 省会. 用 | 分割, 多个简称请用 / 分割.");
        final String input = scanner.next();
        if (input.contains("|")) {
            final String[] args = input.split("\\|");
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
                        pass = false;
                        System.out.println(randomKey + " 只有一个简称 " + cityInfo.getName() + ".");
                    }
                } else {
                    pass = false;
                    System.out.println(randomKey + " 的简称缺少. 正确答案是 " + cityInfo.getName().replace("/", "或") + ".");
                }
            } else {
                if (!cityInfo.getName().equals(args[0])) {
                    pass = false;
                    System.out.println(randomKey + " 的简称错误. 正确答案是 " + cityInfo.getName() + ".");
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
            pass = false;
            System.out.println("你输入的不规范. 请按照要求输入.");
        }
        return pass;
    }

    public boolean score(Scanner scanner) {
        System.out.println("是否开启积分模式? 将会答题 50 次, 满分 100 分. (y/n)");
        final String input = scanner.next();
        boolean b;
        if (input.equalsIgnoreCase("y")) {
            b = true;
        } else if (input.equalsIgnoreCase("n")) {
            b = false;
        } else {
            b = score(scanner);
        }
        return b;
    }
}
