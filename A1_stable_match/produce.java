import java.util.*;

public class produce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 接收用户输入的参数 n，这里需要输入一个数字，和题干中的n一样
    
        int n = scanner.nextInt();

        // 生成男孩和女孩的名字，确保不重复
        String[] boys = generateNames(n);
        String[] girls = generateNames(n);

        // 生成男孩对女孩的偏好顺序和女孩对男孩的偏好顺序
        ArrayList<String> boysPreferences = generatePreferences(n, girls);
        ArrayList<String> girlsPreferences = generatePreferences(n, boys);

        // 输出格式化的测试数据
        System.out.println(n);
        System.out.println(String.join(" ", boys));
        System.out.println(String.join(" ", girls));
        for (String preference : boysPreferences) {
            System.out.println(preference);
        }
        for (String preference : girlsPreferences) {
            System.out.println(preference);
        }
    }

    // 生成指定数量的名字，确保不重复
    private static String[] generateNames(int n) {
        String[] names = new String[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            names[i] = generateUniqueName(names, random);
        }
        return names;
    }

    // 生成一个唯一的名字，确保不与现有的名字重复
    private static String generateUniqueName(String[] existingNames, Random random) {
        String name;
        do {
            name = generateRandomName(random);
        } while (Arrays.asList(existingNames).contains(name));
        return name;
    }

    // 生成一个随机的名字，由大写字母和数字组成
    private static String generateRandomName(Random random) {
        StringBuilder name = new StringBuilder();
        int length = random.nextInt(6) + 5; // 随机生成长度为 5 到 10 的名字
        for (int i = 0; i < length; i++) {
            char ch = (char) (random.nextInt(26) + 'A');
            name.append(ch);
        }
        return name.toString();
    }

    // 生成指定数量的偏好顺序，随机打乱名字数组并将其转换为字符串格式
    private static ArrayList<String> generatePreferences(int n, String[] names) {
        ArrayList<String> preferences = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            shuffleArray(names, random);
            StringBuilder preference = new StringBuilder();
            for (String name : names) {
                preference.append(name).append(" ");
            }
            preferences.add(preference.toString().trim());
        }
        return preferences;
    }

    // 随机打乱数组元素的顺序
    private static void shuffleArray(String[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

}
