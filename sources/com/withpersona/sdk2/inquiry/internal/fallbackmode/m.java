package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.internal.network.a;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final List<NextStep> f26392a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26393b;

    /* renamed from: c  reason: collision with root package name */
    private int f26394c;

    /* renamed from: d  reason: collision with root package name */
    private final String f26395d;

    /* renamed from: e  reason: collision with root package name */
    private final String f26396e;

    public m(List<? extends NextStep> list, String str) {
        j.g(list, "steps");
        j.g(str, "sessionToken");
        this.f26392a = list;
        this.f26393b = str;
        String uuid = UUID.randomUUID().toString();
        j.f(uuid, "randomUUID().toString()");
        this.f26395d = uuid;
        this.f26396e = "Bearer " + str;
    }

    public final InquiryState a() {
        NextStep c10 = c();
        String str = null;
        if (c10 instanceof NextStep.Ui) {
            return a.w((NextStep.Ui) c10, this.f26396e, this.f26395d, "fake_status", (Map<String, ? extends InquiryField>) null);
        }
        if (c10 instanceof NextStep.GovernmentId) {
            return a.u((NextStep.GovernmentId) c10, this.f26396e, this.f26395d, (String) null);
        }
        if (c10 instanceof NextStep.Selfie) {
            return a.v((NextStep.Selfie) c10, this.f26396e, this.f26395d);
        }
        if (c10 instanceof NextStep.Document) {
            return a.t((NextStep.Document) c10, this.f26396e, this.f26395d);
        }
        if (c10 instanceof NextStep.Complete) {
            return a.s((NextStep.Complete) c10, this.f26396e, this.f26395d, "fake_status", (Map<String, ? extends InquiryField>) null);
        }
        boolean z10 = true;
        if (!j.b(c10, NextStep.b.f26717c) && c10 != null) {
            z10 = false;
        }
        if (z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown type for step ");
            if (c10 != null) {
                str = c10.a();
            }
            sb2.append(str);
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String b() {
        return this.f26396e;
    }

    public final NextStep c() {
        return this.f26392a.get(this.f26394c);
    }

    public final String d() {
        return this.f26395d;
    }

    public final NextStep e() {
        if (this.f26394c == q.l(this.f26392a)) {
            return null;
        }
        int i10 = this.f26394c + 1;
        this.f26394c = i10;
        return this.f26392a.get(i10);
    }
}
