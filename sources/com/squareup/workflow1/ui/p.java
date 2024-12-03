package com.squareup.workflow1.ui;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\t\u001a\u00020\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00000\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016R'\u0010\u0015\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/squareup/workflow1/ui/p;", "", "T", "Lcom/squareup/workflow1/ui/q;", "key", "a", "(Lcom/squareup/workflow1/ui/q;)Ljava/lang/Object;", "Lkotlin/Pair;", "pair", "c", "", "toString", "other", "", "equals", "", "hashCode", "", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "map", "<init>", "(Ljava/util/Map;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Map<q<?>, Object> f23291a;

    public p() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    public p(Map<q<?>, ? extends Object> map) {
        j.g(map, "map");
        this.f23291a = map;
    }

    public final <T> T a(q<T> qVar) {
        j.g(qVar, SDKConstants.PARAM_KEY);
        T t10 = this.f23291a.get(qVar);
        if (t10 == null) {
            t10 = null;
        }
        return t10 == null ? qVar.a() : t10;
    }

    public final Map<q<?>, Object> b() {
        return this.f23291a;
    }

    public final <T> p c(Pair<? extends q<T>, ? extends T> pair) {
        j.g(pair, "pair");
        return new p(h0.p(this.f23291a, pair));
    }

    public boolean equals(Object obj) {
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar == null) {
            return false;
        }
        return j.b(pVar.b(), b());
    }

    public int hashCode() {
        return this.f23291a.hashCode();
    }

    public String toString() {
        return "ViewEnvironment(" + this.f23291a + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? h0.i() : map);
    }
}
