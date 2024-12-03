package com.withpersona.sdk2.inquiry.steps.ui;

import android.view.View;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final UiComponent f27560a;

    /* renamed from: b  reason: collision with root package name */
    private final View f27561b;

    public a(UiComponent uiComponent, View view) {
        j.g(uiComponent, "component");
        j.g(view, "view");
        this.f27560a = uiComponent;
        this.f27561b = view;
    }

    public final UiComponent a() {
        return this.f27560a;
    }

    public final View b() {
        return this.f27561b;
    }

    public final UiComponent c() {
        return this.f27560a;
    }

    public final View d() {
        return this.f27561b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f27560a, aVar.f27560a) && j.b(this.f27561b, aVar.f27561b);
    }

    public int hashCode() {
        return (this.f27560a.hashCode() * 31) + this.f27561b.hashCode();
    }

    public String toString() {
        return "ComponentView(component=" + this.f27560a + ", view=" + this.f27561b + PropertyUtils.MAPPED_DELIM2;
    }
}
