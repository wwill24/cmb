package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import gk.g;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"T", "Lcom/google/android/gms/tasks/Task;", "a", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcom/google/android/gms/tasks/CancellationTokenSource;", "cancellationTokenSource", "b", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-play-services"}, k = 2, mv = {1, 6, 0})
public final class TasksKt {

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Lcom/google/android/gms/tasks/Task;", "kotlin.jvm.PlatformType", "onComplete"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a<TResult> implements OnCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n<T> f32725a;

        a(n<? super T> nVar) {
            this.f32725a = nVar;
        }

        public final void onComplete(Task<T> task) {
            Exception exception = task.getException();
            if (exception != null) {
                n<T> nVar = this.f32725a;
                Result.a aVar = Result.f32010a;
                nVar.resumeWith(Result.b(g.a(exception)));
            } else if (task.isCanceled()) {
                n.a.a(this.f32725a, (Throwable) null, 1, (Object) null);
            } else {
                n<T> nVar2 = this.f32725a;
                Result.a aVar2 = Result.f32010a;
                nVar2.resumeWith(Result.b(task.getResult()));
            }
        }
    }

    public static final <T> Object a(Task<T> task, c<? super T> cVar) {
        return b(task, (CancellationTokenSource) null, cVar);
    }

    private static final <T> Object b(Task<T> task, CancellationTokenSource cancellationTokenSource, c<? super T> cVar) {
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception != null) {
                throw exception;
            } else if (!task.isCanceled()) {
                return task.getResult();
            } else {
                throw new CancellationException("Task " + task + " was cancelled normally.");
            }
        } else {
            o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
            oVar.y();
            task.addOnCompleteListener((Executor) a.f32726a, (OnCompleteListener<T>) new a(oVar));
            if (cancellationTokenSource != null) {
                oVar.o(new TasksKt$awaitImpl$2$2(cancellationTokenSource));
            }
            Object v10 = oVar.v();
            if (v10 == b.d()) {
                f.c(cVar);
            }
            return v10;
        }
    }
}
