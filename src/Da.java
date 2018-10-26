import java.math.BigDecimal;
/*
　float和double类型的主要设计目标是为了科学计算和工程计算。他们执行二进制浮点运算，这是为了在广域数值范围上提供较为精确的快速近似计算而精心设计的。
然而，它们没有提供完全精确的结果，所以不应该被用于要求精确结果的场合。但是，商业计算往往要求结果精确，这时候BigDecimal就派上大用场啦。
 */
public class Da{

    public static void main(String[] args)
    {
        /*
        BigDecimal构造方法
　　1.public BigDecimal(double val)    将double表示形式转换为BigDecimal *不建议使用

　　2.public BigDecimal(int val)　　将int表示形式转换成BigDecimal

　　3.public BigDecimal(String val)　　将String表示形式转换成BigDecimal
         */
        BigDecimal bigDecimal = new BigDecimal(2);
        BigDecimal bDouble = new BigDecimal(2.3);
        BigDecimal bString = new BigDecimal("2.3");
        System.out.println("bigDecimal=" + bigDecimal);
        System.out.println("bDouble=" + bDouble);
        System.out.println("bString=" + bString);
        /*
        为什么会出现这种情况呢？

 JDK的描述：1、参数类型为double的构造方法的结果有一定的不可预知性。有人可能认为在Java中写入newBigDecimal(0.1)所创建的BigDecimal正好
 等于 0.1（非标度值 1，其标度为 1），但是它实际上等于0.1000000000000000055511151231257827021181583404541015625。
 这是因为0.1无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。
 这样，传入到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。

        2、另一方面，String 构造方法是完全可预知的：写入 newBigDecimal("0.1") 将创建一个 BigDecimal，它正好等于预期的 0.1。
        因此，比较而言，通常建议优先使用String构造方法。
当double必须用作BigDecimal的源时，请使用Double.toString(double)转成String，然后使用String构造方法，或使用BigDecimal的静态方法valueOf，如下
         */
        BigDecimal bDouble1 = BigDecimal.valueOf(2.3);
        BigDecimal bDouble2 = new BigDecimal(Double.toString(2.3));

        System.out.println("bDouble1=" + bDouble1);
        System.out.println("bDouble2=" + bDouble2);

        /*
        他的加减乘除运算
    public BigDecimal add(BigDecimal value);                        //加法

    public BigDecimal subtract(BigDecimal value);                   //减法

    public BigDecimal multiply(BigDecimal value);                   //乘法

    public BigDecimal divide(BigDecimal value);                     //除法
         */
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");

        System.out.println("a + b =" + a.add(b));
        System.out.println("a - b =" + a.subtract(b));
        System.out.println("a * b =" + a.multiply(b));
        System.out.println("a / b =" + a.divide(b));
    }
}
