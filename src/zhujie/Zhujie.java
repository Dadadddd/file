package zhujie;

import java.lang.annotation.*;

/*
记住，这是注解的标配
1.@Documented
2.@Inherited
3.@Target({ElementType.TYPE,ElementType.FIELD})
4.@Retention(RetentionPolicy.RUNTIME)
1和2是标配
3和4是用来自定义架构的
3是来定义变量的属性和类型
4是用来表示在什么过程使用注解的（这里是@Zhujie），比如RUNTIME是代表运行时使用
 */
@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Zhujie {
    /*
    这里面是用来定义的值的
    例如：
     String value() default "";代表着加字符串，默认是空的，也可以在“”里面写个默认的字符串
     String value()代表不设置默认值
     int value() default 1;代表着加整形，默认是1，也可以写别的数字
     int value()代表不设置默认值

     这样就定义好了自定义注解，可以再测试类里面使用了
     */
    String value() default "";
}
