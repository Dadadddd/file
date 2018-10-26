public enum SomeEnumTest{
    A("ADes", 1),
    B("BDes", 2),
    unknown("UNKNWONDes", 3);

    private String des;
    private int order;

    private SomeEnumTest(String des, int order){
        this.des = des;
        this.order = order;
    }

    static final EnumFindHelper<SomeEnumTest, String> desptHelper = new EnumFindHelper<SomeEnumTest, String>(
            SomeEnumTest.class, new DesptGetter());

    static final EnumFindHelper<SomeEnumTest, Integer> orderHelper = new EnumFindHelper<SomeEnumTest, Integer>(
            SomeEnumTest.class, new OrderKeyGetter());

    static class DesptGetter implements EnumKeyGetter<SomeEnumTest, String> {
        @Override
        public String getKey(SomeEnumTest enumValue) {
            return enumValue.des;
        }
    }

    static class OrderKeyGetter implements EnumKeyGetter<SomeEnumTest, Integer> {

        @Override
        public Integer getKey(SomeEnumTest enumValue) {
            return null;
        }
    }

    public static SomeEnumTest find(String despt, SomeEnumTest defaultValue){
        return desptHelper.find(despt, defaultValue);
    }

    public static SomeEnumTest find(int order, SomeEnumTest defaultValue){
        return orderHelper.find(order, defaultValue);
    }
}