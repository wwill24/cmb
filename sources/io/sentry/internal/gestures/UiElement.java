package io.sentry.internal.gestures;

import io.sentry.util.l;
import java.lang.ref.WeakReference;

public final class UiElement {

    /* renamed from: a  reason: collision with root package name */
    final WeakReference<Object> f31287a;

    /* renamed from: b  reason: collision with root package name */
    final String f31288b;

    /* renamed from: c  reason: collision with root package name */
    final String f31289c;

    /* renamed from: d  reason: collision with root package name */
    final String f31290d;

    public enum Type {
        CLICKABLE,
        SCROLLABLE
    }

    public UiElement(Object obj, String str, String str2, String str3) {
        this.f31287a = new WeakReference<>(obj);
        this.f31288b = str;
        this.f31289c = str2;
        this.f31290d = str3;
    }

    public String a() {
        return this.f31288b;
    }

    public String b() {
        String str = this.f31289c;
        if (str != null) {
            return str;
        }
        return (String) l.c(this.f31290d, "UiElement.tag can't be null");
    }

    public String c() {
        return this.f31289c;
    }

    public String d() {
        return this.f31290d;
    }

    public Object e() {
        return this.f31287a.get();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UiElement.class != obj.getClass()) {
            return false;
        }
        UiElement uiElement = (UiElement) obj;
        if (!l.a(this.f31288b, uiElement.f31288b) || !l.a(this.f31289c, uiElement.f31289c) || !l.a(this.f31290d, uiElement.f31290d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return l.b(this.f31287a, this.f31289c, this.f31290d);
    }
}
