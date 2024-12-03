package com.squareup.workflow1.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.internal.d;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00008\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/squareup/workflow1/internal/f;", "Lcom/squareup/workflow1/internal/d$a;", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "key", "Lkotlinx/coroutines/s1;", "b", "Lkotlinx/coroutines/s1;", "c", "()Lkotlinx/coroutines/s1;", "job", "Lcom/squareup/workflow1/internal/f;", "e", "()Lcom/squareup/workflow1/internal/f;", "f", "(Lcom/squareup/workflow1/internal/f;)V", "nextListNode", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/s1;)V", "wf1-workflow-runtime"}, k = 1, mv = {1, 6, 0})
public final class f implements d.a<f> {

    /* renamed from: a  reason: collision with root package name */
    private final String f23128a;

    /* renamed from: b  reason: collision with root package name */
    private final s1 f23129b;

    /* renamed from: c  reason: collision with root package name */
    private f f23130c;

    public f(String str, s1 s1Var) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(s1Var, "job");
        this.f23128a = str;
        this.f23129b = s1Var;
    }

    public final s1 c() {
        return this.f23129b;
    }

    public final String d() {
        return this.f23128a;
    }

    /* renamed from: e */
    public f a() {
        return this.f23130c;
    }

    /* renamed from: f */
    public void b(f fVar) {
        this.f23130c = fVar;
    }
}
