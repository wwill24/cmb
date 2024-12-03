package pe;

import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import java.lang.reflect.Field;
import pe.a;

public final class b<T> extends a.C0503a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f41794a;

    private b(Object obj) {
        this.f41794a = obj;
    }

    @NonNull
    public static <T> T f(@NonNull a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f41794a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i10 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i10++;
                field = field2;
            }
        }
        if (i10 == 1) {
            p.k(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e10) {
                    throw new IllegalArgumentException("Binder object is null.", e10);
                } catch (IllegalAccessException e11) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e11);
                }
            } else {
                throw new IllegalArgumentException("IObjectWrapper declared field not private!");
            }
        } else {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
    }

    @NonNull
    public static <T> a g(@NonNull T t10) {
        return new b(t10);
    }
}
