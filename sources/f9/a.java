package f9;

import com.coffeemeetsbagel.models.dto.RetryCall;
import com.coffeemeetsbagel.models.dto.RetryCallPartial;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import nc.b;

public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final b f14960a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14961b;

    /* renamed from: f9.a$a  reason: collision with other inner class name */
    private class C0159a<T> implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final RetryCall f14962a;

        /* renamed from: b  reason: collision with root package name */
        private final T f14963b;

        public C0159a(RetryCall retryCall, Class<T> cls) {
            this.f14962a = retryCall;
            this.f14963b = a.this.f(retryCall.getPayloadObject(), cls);
        }

        public T a() {
            return this.f14963b;
        }

        public RetryCall b() {
            return this.f14962a;
        }
    }

    public a(int i10, b bVar) {
        this.f14961b = i10;
        this.f14960a = bVar;
    }

    public <T> List<c<T>> a(String str, Class<T> cls) {
        List<RetryCall> g10 = g();
        ArrayList arrayList = new ArrayList();
        for (RetryCall next : g10) {
            int timesTriedSoFar = next.getTimesTriedSoFar();
            long lastTimeTried = next.getLastTimeTried();
            String internalTag = next.getInternalTag();
            if (timesTriedSoFar >= this.f14961b) {
                d(next);
            } else if (str.equals(internalTag)) {
                long b10 = d.b(lastTimeTried, timesTriedSoFar);
                if (this.f14960a.getCurrentTimeMillis() >= b10) {
                    d(next);
                    arrayList.add(new C0159a(next, cls));
                } else {
                    long convert = TimeUnit.SECONDS.convert(b10 - this.f14960a.getCurrentTimeMillis(), TimeUnit.MILLISECONDS);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("call not ready to retry, ");
                    sb2.append(convert);
                    sb2.append(" seconds remaining");
                }
            }
        }
        return arrayList;
    }

    public final <T> void b(String str, T t10) {
        e(new RetryCallPartial(str, h(t10), this.f14960a.getCurrentTimeMillis(), 0));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("adding call to retry tag=");
        sb2.append(str);
    }

    public final void c(RetryCall retryCall) {
        if (retryCall.getTimesTriedSoFar() + 1 < this.f14961b) {
            e(new RetryCallPartial(retryCall.getInternalTag(), retryCall.getPayloadObject(), this.f14960a.getCurrentTimeMillis(), retryCall.getTimesTriedSoFar() + 1));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("read call to retry, tag=");
            sb2.append(retryCall.getInternalTag());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void d(RetryCall retryCall);

    /* access modifiers changed from: protected */
    public abstract void e(RetryCallPartial retryCallPartial);

    /* access modifiers changed from: protected */
    public abstract <T> T f(String str, Class<T> cls);

    /* access modifiers changed from: protected */
    public abstract List<RetryCall> g();

    /* access modifiers changed from: protected */
    public abstract <T> String h(T t10);
}
