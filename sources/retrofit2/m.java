package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.b0;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.f;

@IgnoreJRERequirement
final class m extends f.a {

    /* renamed from: a  reason: collision with root package name */
    static final f.a f42312a = new m();

    @IgnoreJRERequirement
    static final class a<T> implements f<b0, Optional<T>> {

        /* renamed from: a  reason: collision with root package name */
        final f<b0, T> f42313a;

        a(f<b0, T> fVar) {
            this.f42313a = fVar;
        }

        /* renamed from: a */
        public Optional<T> convert(b0 b0Var) throws IOException {
            return Optional.ofNullable(this.f42313a.convert(b0Var));
        }
    }

    m() {
    }

    public f<b0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        if (f.a.b(type) != Optional.class) {
            return null;
        }
        return new a(sVar.h(f.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
