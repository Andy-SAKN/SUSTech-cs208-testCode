import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class check {
    public static void main(String[] args) {
        // 读取Mine.txt和Std.txt文件中的配对情况，并存储到HashMap中
        HashMap<String, String> minePairs = readPairsFromFile("D:\\大二下学习\\算法设计与分析\\Assignment\\A1\\src\\Mine.txt");
        HashMap<String, String> stdPairs = readPairsFromFile("D:\\大二下学习\\算法设计与分析\\Assignment\\A1\\src\\Std.txt");

        // 检查配对情况是否一致
        boolean consistent = checkConsistency(minePairs, stdPairs);

        // 输出结果
        if (consistent) {
            System.out.println("配对情况一致！");
        } else {
            System.out.println("配对情况不一致：");
            for (String boy : minePairs.keySet()) {
                if (!stdPairs.containsKey(boy) || !stdPairs.get(boy).equals(minePairs.get(boy))) {
                    System.out.println("Mine.txt中的配对：" + boy + " " + minePairs.get(boy));
                    System.out.println("Std.txt中的配对：" + boy + " " + stdPairs.get(boy));
                }
            }
        }
    }

    // 从文件中读取配对情况，并存储到HashMap中
    private static HashMap<String, String> readPairsFromFile(String filename) {
        HashMap<String, String> pairs = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                pairs.put(tokens[0], tokens[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pairs;
    }

    // 检查配对情况是否一致
    private static boolean checkConsistency(HashMap<String, String> minePairs, HashMap<String, String> stdPairs) {
        return minePairs.equals(stdPairs);
    }
}
