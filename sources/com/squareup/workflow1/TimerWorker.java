package com.squareup.workflow1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/squareup/workflow1/TimerWorker;", "Lcom/squareup/workflow1/j;", "", "Lkotlinx/coroutines/flow/b;", "run", "otherWorker", "", "a", "", "toString", "", "hashCode", "", "other", "equals", "", "b", "J", "delayMs", "c", "Ljava/lang/String;", "key", "<init>", "(JLjava/lang/String;)V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
final class TimerWorker implements j<Unit> {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f23057b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23058c;

    public TimerWorker(long j10, String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        this.f23057b = j10;
        this.f23058c = str;
    }

    public boolean a(j<?> jVar) {
        j.g(jVar, "otherWorker");
        return (jVar instanceof TimerWorker) && j.b(((TimerWorker) jVar).f23058c, this.f23058c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimerWorker)) {
            return false;
        }
        TimerWorker timerWorker = (TimerWorker) obj;
        return this.f23057b == timerWorker.f23057b && j.b(this.f23058c, timerWorker.f23058c);
    }

    public int hashCode() {
        return (Long.hashCode(this.f23057b) * 31) + this.f23058c.hashCode();
    }

    public b<Unit> run() {
        return d.v(new TimerWorker$run$1(this, (c<? super TimerWorker$run$1>) null));
    }

    public String toString() {
        return "TimerWorker(delayMs=" + this.f23057b + ", key=" + this.f23058c + PropertyUtils.MAPPED_DELIM2;
    }
}
