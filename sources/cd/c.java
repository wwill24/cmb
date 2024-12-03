package cd;

import com.google.android.datatransport.Priority;

public abstract class c<T> {
    public static <T> c<T> d(T t10) {
        return new a((Integer) null, t10, Priority.DEFAULT);
    }

    public static <T> c<T> e(T t10) {
        return new a((Integer) null, t10, Priority.VERY_LOW);
    }

    public static <T> c<T> f(T t10) {
        return new a((Integer) null, t10, Priority.HIGHEST);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();
}
