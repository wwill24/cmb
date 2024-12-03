package androidx.work;

import androidx.work.b;
import b2.d;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u001e\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u0012"}, d2 = {"Landroidx/work/ArrayCreatingInputMerger;", "Lb2/d;", "", "array1", "array2", "d", "array", "obj", "Ljava/lang/Class;", "valueClass", "c", "e", "", "Landroidx/work/b;", "inputs", "b", "<init>", "()V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class ArrayCreatingInputMerger extends d {
    private final Object c(Object obj, Object obj2, Class<?> cls) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        j.f(newInstance, "newArray");
        return newInstance;
    }

    private final Object d(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        j.d(componentType);
        Object newInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        j.f(newInstance, "newArray");
        return newInstance;
    }

    private final Object e(Object obj, Class<?> cls) {
        Object newInstance = Array.newInstance(cls, 1);
        Array.set(newInstance, 0, obj);
        j.f(newInstance, "newArray");
        return newInstance;
    }

    public b b(List<b> list) {
        Class cls;
        j.g(list, "inputs");
        b.a aVar = new b.a();
        HashMap hashMap = new HashMap();
        for (b h10 : list) {
            Map<String, Object> h11 = h10.h();
            j.f(h11, "input.keyValueMap");
            Iterator<Map.Entry<String, Object>> it = h11.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != null) {
                        cls = value.getClass();
                    } else {
                        cls = String.class;
                    }
                    Object obj = hashMap.get(str);
                    j.f(str, SDKConstants.PARAM_KEY);
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (j.b(cls2, cls)) {
                            j.f(value, "value");
                            value = d(obj, value);
                        } else if (j.b(cls2.getComponentType(), cls)) {
                            value = c(obj, value, cls);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else if (!cls.isArray()) {
                        value = e(value, cls);
                    }
                    j.f(value, "if (existingValue == nul…      }\n                }");
                    hashMap.put(str, value);
                }
            }
        }
        aVar.d(hashMap);
        b a10 = aVar.a();
        j.f(a10, "output.build()");
        return a10;
    }
}
