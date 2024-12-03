package com.squareup.workflow1.ui.modal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B\u001f\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000f\u001a\u00028\u00008\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/squareup/workflow1/ui/modal/c;", "", "B", "Lcom/squareup/workflow1/ui/modal/d;", "Lcom/squareup/workflow1/ui/modal/AlertScreen;", "", "toString", "", "hashCode", "other", "", "equals", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "beneathModals", "", "c", "Ljava/util/List;", "a", "()Ljava/util/List;", "modals", "<init>", "(Ljava/lang/Object;Ljava/util/List;)V", "wf1-container-common"}, k = 1, mv = {1, 6, 0})
public final class c<B> implements d<B, AlertScreen> {

    /* renamed from: b  reason: collision with root package name */
    private final B f23285b;

    /* renamed from: c  reason: collision with root package name */
    private final List<AlertScreen> f23286c;

    public c(B b10, List<AlertScreen> list) {
        j.g(b10, "beneathModals");
        j.g(list, "modals");
        this.f23285b = b10;
        this.f23286c = list;
    }

    public List<AlertScreen> a() {
        return this.f23286c;
    }

    public B b() {
        return this.f23285b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j.b(b(), cVar.b()) && j.b(a(), cVar.a());
    }

    public int hashCode() {
        return (b().hashCode() * 31) + a().hashCode();
    }

    public String toString() {
        return "AlertContainerScreen(beneathModals=" + b() + ", modals=" + a() + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i10 & 2) != 0 ? q.j() : list);
    }
}
