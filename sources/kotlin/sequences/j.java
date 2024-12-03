package kotlin.sequences;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

class j {

    public static final class a implements Sequence<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Function2 f32191a;

        public a(Function2 function2) {
            this.f32191a = function2;
        }

        public Iterator<T> iterator() {
            return j.a(this.f32191a);
        }
    }

    public static <T> Iterator<T> a(Function2<? super h<? super T>, ? super c<? super Unit>, ? extends Object> function2) {
        kotlin.jvm.internal.j.g(function2, BlockContactsIQ.ELEMENT);
        g gVar = new g();
        gVar.j(IntrinsicsKt__IntrinsicsJvmKt.b(function2, gVar, gVar));
        return gVar;
    }

    public static <T> Sequence<T> b(Function2<? super h<? super T>, ? super c<? super Unit>, ? extends Object> function2) {
        kotlin.jvm.internal.j.g(function2, BlockContactsIQ.ELEMENT);
        return new a(function2);
    }
}
