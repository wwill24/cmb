package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.b0;
import okhttp3.z;

public interface f<F, T> {

    public static abstract class a {
        protected static Type a(int i10, ParameterizedType parameterizedType) {
            return w.g(i10, parameterizedType);
        }

        protected static Class<?> b(Type type) {
            return w.h(type);
        }

        public f<?, z> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
            return null;
        }

        public f<b0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }

        public f<?, String> e(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }
    }

    T convert(F f10) throws IOException;
}
