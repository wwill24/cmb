package c;

import android.content.Context;
import android.content.Intent;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public abstract class a<I, O> {

    /* renamed from: c.a$a  reason: collision with other inner class name */
    public static final class C0091a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f7895a;

        public C0091a(T t10) {
            this.f7895a = t10;
        }

        public final T a() {
            return this.f7895a;
        }
    }

    public abstract Intent createIntent(Context context, I i10);

    public C0091a<O> getSynchronousResult(Context context, I i10) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return null;
    }

    public abstract O parseResult(int i10, Intent intent);
}
