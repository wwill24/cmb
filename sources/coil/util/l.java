package coil.util;

import gk.g;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.n;
import okhttp3.a0;
import okhttp3.e;
import okhttp3.f;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcoil/util/l;", "Lokhttp3/f;", "Lkotlin/Function1;", "", "", "Lkotlinx/coroutines/CompletionHandler;", "Lokhttp3/e;", "call", "Lokhttp3/a0;", "response", "onResponse", "Ljava/io/IOException;", "e", "onFailure", "cause", "a", "Lokhttp3/e;", "Lkotlinx/coroutines/n;", "b", "Lkotlinx/coroutines/n;", "continuation", "<init>", "(Lokhttp3/e;Lkotlinx/coroutines/n;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
final class l implements f, Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    private final e f8434a;

    /* renamed from: b  reason: collision with root package name */
    private final n<a0> f8435b;

    public l(e eVar, n<? super a0> nVar) {
        this.f8434a = eVar;
        this.f8435b = nVar;
    }

    public void a(Throwable th2) {
        try {
            this.f8434a.cancel();
        } catch (Throwable unused) {
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }

    public void onFailure(e eVar, IOException iOException) {
        if (!eVar.m()) {
            n<a0> nVar = this.f8435b;
            Result.a aVar = Result.f32010a;
            nVar.resumeWith(Result.b(g.a(iOException)));
        }
    }

    public void onResponse(e eVar, a0 a0Var) {
        this.f8435b.resumeWith(Result.b(a0Var));
    }
}
