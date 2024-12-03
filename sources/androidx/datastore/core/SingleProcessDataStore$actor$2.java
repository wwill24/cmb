package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.w;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"T", "Landroidx/datastore/core/SingleProcessDataStore$b;", "msg", "", "ex", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class SingleProcessDataStore$actor$2 extends Lambda implements Function2<SingleProcessDataStore.b<T>, Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final SingleProcessDataStore$actor$2 f5018a = new SingleProcessDataStore$actor$2();

    SingleProcessDataStore$actor$2() {
        super(2);
    }

    public final void a(SingleProcessDataStore.b<T> bVar, Throwable th2) {
        j.g(bVar, SDKConstants.PARAM_DEBUG_MESSAGE);
        if (bVar instanceof SingleProcessDataStore.b.C0050b) {
            w a10 = ((SingleProcessDataStore.b.C0050b) bVar).a();
            if (th2 == null) {
                th2 = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            a10.J(th2);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((SingleProcessDataStore.b) obj, (Throwable) obj2);
        return Unit.f32013a;
    }
}
