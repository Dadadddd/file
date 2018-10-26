import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class EnumFindHelper<T extends Enum<T>, K> {
    protected Map<K, T> map = new HashMap<K, T>();

    public EnumFindHelper(Class<T> clazz, EnumKeyGetter<T, K> keyGetter) {
        try {
            for (T enumValue : EnumSet.allOf(clazz)) {
                map.put(keyGetter.getKey(enumValue), enumValue);
            }
        } catch (Exception e) {
            //eror handler
        }
    }

    public T find(K key, T defautValue) {
        T value = map.get(key);
        if (value == null) {
            value = defautValue;
        }
        return value;
    }
}