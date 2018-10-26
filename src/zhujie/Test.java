package zhujie;

import java.lang.reflect.Field;

/*
在这个测试类里面可以使用自己自定义的注解了
 */
public class Test {
    @Zhujie("")
    String name="dada";

    String name1="xiaoxiao";

    @Override
    public String toString(){
        Class c=this.getClass();
        Field[] f=c.getDeclaredFields();
        StringBuffer s=new StringBuffer();
        for (int i=0;i<f.length;i++){
            if (f[i].isAnnotationPresent(Zhujie.class)){

            }else{
                try {
                    s.append(f[i].getName()+""+f[i].get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return s+"";
    }
    public static void main(String[] args){

    }
}
