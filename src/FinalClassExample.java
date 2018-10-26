import java.util.HashMap;
import java.util.Iterator;
/*
要创建不可变类，要实现下面几个步骤：

1. 将类声明为final，所以它不能被继承
2. 将所有的成员声明为私有的，这样就不允许直接访问这些成员
3. 对变量不要提供setter方法,提供getter方法
4. 将所有可变的成员声明为final，这样只能对它们赋值一次
5. 通过构造器初始化所有成员，进行深拷贝(deep copy)
6. 在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝
 */

//将类声明为final，所以它不能被继承
public final class FinalClassExample {
//将所有的成员声明为私有的，这样就不允许直接访问这些成员
    private final int id;
    private final String name;
    private final HashMap testMap;
/*
对变量不要提供setter方法,提供getter方法
 */
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public HashMap getTestMap() {
        return testMap;
    }

    public FinalClassExample(int i, String n, HashMap hm){
        this.id=i;
        this.name=n;
        HashMap tempMap=new HashMap();
        String key;
        Iterator it = hm.keySet().iterator();
        while(it.hasNext()){
            key= (String) it.next();
            tempMap.put(key, hm.get(key));
        }
        this.testMap=tempMap;
    }

    public static void main(String[] args) {
        HashMap h1 = new HashMap();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i=10;

        FinalClassExample ce = new FinalClassExample(i,s,h1);

        //Lets see whether its copy by field or reference
        System.out.println(s==ce.getName());
        System.out.println(h1 == ce.getTestMap());
        //print the ce values
        System.out.println("ce id:"+ce.getId());
        System.out.println("ce name:"+ce.getName());
        System.out.println("ce testMap:"+ce.getTestMap());
        //change the local variable values
        i=20;
        s="modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:"+ce.getId());
        System.out.println("ce name after local variable change:"+ce.getName());
        System.out.println("ce testMap after local variable change:"+ce.getTestMap());

        HashMap hmTest = ce.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:"+ce.getTestMap());

    }

}
