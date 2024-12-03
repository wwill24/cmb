package com.squareup.workflow1.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\b\u001a\u00020\u0007\"\u001a\b\u0000\u0010\u0001*\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004*\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/squareup/workflow1/k;", "W", "I", "O", "R", "", "key", "Lcom/squareup/workflow1/internal/h;", "a", "(Lcom/squareup/workflow1/k;Ljava/lang/String;)Lcom/squareup/workflow1/internal/h;", "wf1-workflow-runtime"}, k = 2, mv = {1, 6, 0})
public final class i {
    public static final <W extends k<? super I, ? extends O, ? extends R>, I, O, R> h a(W w10, String str) {
        j.g(w10, "<this>");
        j.g(str, SDKConstants.PARAM_KEY);
        return new h((k<?, ?, ?>) w10, str);
    }

    public static /* synthetic */ h b(k kVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return a(kVar, str);
    }
}
