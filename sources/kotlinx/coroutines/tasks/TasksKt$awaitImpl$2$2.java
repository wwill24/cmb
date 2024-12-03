package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
final class TasksKt$awaitImpl$2$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellationTokenSource $cancellationTokenSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TasksKt$awaitImpl$2$2(CancellationTokenSource cancellationTokenSource) {
        super(1);
        this.$cancellationTokenSource = cancellationTokenSource;
    }

    public final void a(Throwable th2) {
        this.$cancellationTokenSource.cancel();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
