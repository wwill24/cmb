package kotlinx.coroutines.tasks;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/tasks/a;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "r", "", "execute", "<init>", "()V", "kotlinx-coroutines-play-services"}, k = 1, mv = {1, 6, 0})
final class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32726a = new a();

    private a() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
