import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Guide {

    public Guide() {
        try {
            final Scanner scanner = new Scanner(System.in);
            if (score(scanner)) {
                final List<WrongQuestion> wrongs = new ArrayList<>();
                int index = 0;
                int count = 0;
                int continuous = 0;
                do {
                    final QuestionState state = runGuide(scanner);
                    boolean pass = state.isPass();
                    if (!pass) {
                        wrongs.add(WrongQuestion.builder()
                                .name(state.getName())
                                .info(state.getInfo())
                                .errorName(state.getEnterName())
                                .errorCity(state.getEnterCity())
                                .build());
                    }
                    count = pass ? count + 2 : count;
                    continuous = pass ? continuous + 1 : 0;
                    index++;
                } while (index < 50);
                System.out.println("答题结束! 你的得分: " + count + ", 你连续答对了 " + continuous + " 道题.");
                if (enableWrong(scanner)) {
                    wrongs.forEach(wrongQuestion -> wrong(scanner, wrongQuestion));
                }
            } else {
                final QuestionState state = runGuide(scanner);
                if (!state.isPass()) {
                    if (enableWrong(scanner)) {
                        wrong(scanner, WrongQuestion.builder()
                                .name(state.getName())
                                .info(state.getInfo())
                                .errorName(state.getEnterName())
                                .errorCity(state.getEnterCity())
                                .build());
                    }
                }
            }
            scanner.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("你输入的不规范, 请按照要求输入.");
        }
    }

    public QuestionState runGuide(Scanner scanner) {
        final String[] keys = CityManager.getCities().keySet().toArray(new String[0]);
        final String randomKey = keys[new Random().nextInt(keys.length)];
        final CityInfo cityInfo = CityManager.getCities().get(randomKey);
        return ask(scanner, cityInfo, randomKey);
    }

    public QuestionState ask(Scanner scanner, CityInfo cityInfo, String name) {
        boolean pass = true;
        System.out.println("请按顺序输入 " + name + " 城市的 简称 与 省会. 用 | 分割, 多个简称请用 / 分割.");
        final String input = scanner.next();
        String enterName = null;
        String enterCity = null;
        if (input.contains("|")) {
            final String[] args = input.split("\\|");
            enterName = args[0];
            enterCity = args[1];
            if (cityInfo.getName().contains("/")) {
                if (args[0].contains("/")) {
                    if (cityInfo.getName().contains("/")) {
                        final String[] temp = args[0].split("/");
                        final String[] cityName = cityInfo.getName().split("/");
                        if (temp[0].equals(cityName[0])) {
                            if (!temp[1].equals(cityName[1])) {
                                pass = false;
                            }
                        } else {
                            if (temp[0].equals(cityName[1])) {
                                if (!temp[1].equals(cityName[0])) {
                                    pass = false;
                                }
                            } else {
                                pass = false;
                            }
                        }
                    } else {
                        pass = false;
                        System.out.println(name + " 只有一个简称 " + cityInfo.getName() + ".");
                    }
                } else {
                    pass = false;
                    System.out.println(name + " 的简称缺少. 正确答案是 " + cityInfo.getName().replace("/", "或") + ".");
                }
            } else {
                if (!cityInfo.getName().equals(args[0])) {
                    pass = false;
                    System.out.println(name + " 的简称错误. 正确答案是 " + cityInfo.getName() + ".");
                }
            }
            if (!cityInfo.getCity().equals(args[1])) {
                pass = false;
                System.out.println(name + " 的省会错误. 正确答案是 " + cityInfo.getCity() + ".");
            }
            if (pass) {
                System.out.println("你答对了. " + name + " 的简称和省会分别是 " + cityInfo.getName().replace("/", "或") + " " + cityInfo.getCity() + ".");
            }
        } else {
            pass = false;
            System.out.println("你输入的不规范. 请按照要求输入.");
        }
        return QuestionState.builder()
                .name(name)
                .info(cityInfo)
                .pass(pass)
                .enterName(enterName)
                .enterCity(enterCity)
                .build();
    }

    public boolean score(Scanner scanner) {
        System.out.println("是否开启积分模式? 将会答题 50 次, 满分 100 分. (y/n)");
        return scanBoolean(scanner);
    }

    public boolean enableWrong(Scanner scanner) {
        System.out.println("是否回顾错题? (y/n)");
        return scanBoolean(scanner);
    }

    public boolean scanBoolean(Scanner scanner) {
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

    public void wrong(Scanner scanner, WrongQuestion wrong) {
        System.out.println("错题: " + wrong.getName());
        System.out.println("正确答案: " + wrong.getInfo().getName() + " " + wrong.getInfo().getCity());
        System.out.println("你的答案: " + wrong.getErrorName() + " " + wrong.getErrorCity());
        if (!ask(scanner, wrong.getInfo(), wrong.getName()).isPass()) {
            wrong(scanner, wrong);
        }
    }
}
