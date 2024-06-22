package ryan.cloud.myapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderNoUtil {

    // 定义订单号长度
    private static final int ORDER_NUMBER_LENGTH = 20;

    // 定义随机数生成器
    private static final Random RANDOM = new Random();

    /**
     * 生成订单号
     * @return 生成的订单号
     */
    public static String generateOrderNumber() {
        // 获取当前时间戳
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 计算需要补充的随机数长度
        int randomLength = ORDER_NUMBER_LENGTH - timestamp.length();

        // 生成随机数
        StringBuilder randomBuilder = new StringBuilder();
        for (int i = 0; i < randomLength; i++) {
            randomBuilder.append(RANDOM.nextInt(10));
        }

        // 组合时间戳和随机数生成订单号
        return timestamp + randomBuilder.toString();
    }

    public static void main(String[] args) {
        // 生成并打印订单号示例
        String orderNumber = generateOrderNumber();
        System.out.println("Generated Order Number: " + orderNumber);
    }
}
