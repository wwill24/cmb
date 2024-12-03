package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface c<R, T> {

    public static abstract class a {
        protected static Type b(int i10, ParameterizedType parameterizedType) {
            return w.g(i10, parameterizedType);
        }

        protected static Class<?> c(Type type) {
            return w.h(type);
        }

        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, s sVar);
    }

    Type a();

    T b(b<R> bVar);
}
