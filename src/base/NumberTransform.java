package base;

/**
 * NumberTransform class
 *
 * 数值转化规则
 * 不丢失精度
 *   byte -> short -> int
 *   char -> int
 *   int -> long|double
 * 丢失精度
 *   int -> float
 *   long -> float|double
 *
 * @author xiwang
 * @date 2019-08-28
 */
public class NumberTransform {
    private static int intMaxValue = Integer.MAX_VALUE;
    private static short shortMaxValue = Short.MAX_VALUE;
    private static byte byteMaxValue = Byte.MAX_VALUE;
    private static long longMaxValue = Long.MAX_VALUE;
    private static char charValue = 1;
    private static float floatMaxValue = Float.MAX_VALUE;
    private static double doubleMaxValue = Double.MAX_VALUE;

    /**
     * 运行结果
     * int 越界情况 (int)2147483649L： -2147483647
     * long -> float 精度丢失：maxLongValue 9223372036854775807 -> float:9.223372E18
     * */
    public static void main(String[] args){
        System.out.println("int 越界情况 (int)2147483649L： " + (int)2147483649L);
        System.out.println("long -> float 精度丢失：maxLongValue 9223372036854775807 -> float:" + (float)longMaxValue);
    }

}
