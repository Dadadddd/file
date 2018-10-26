public interface  EnumKeyGetter<T extends Enum<T>, K> {

    K getKey(T enumValue);

}