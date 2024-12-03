package com.withpersona.sdk2.inquiry.governmentid.capture_tips;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f25761a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25762b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25763c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25764d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25765e;

    public d(String str, String str2, String str3, String str4, String str5) {
        j.g(str, "helpButtonText");
        j.g(str2, "title");
        j.g(str3, "prompt");
        j.g(str4, ModelDeeplinkData.VALUE_PAGE_TIPS);
        j.g(str5, "buttonText");
        this.f25761a = str;
        this.f25762b = str2;
        this.f25763c = str3;
        this.f25764d = str4;
        this.f25765e = str5;
    }

    public final String a() {
        return this.f25765e;
    }

    public final String b() {
        return this.f25761a;
    }

    public final String c() {
        return this.f25763c;
    }

    public final String d() {
        return this.f25764d;
    }

    public final String e() {
        return this.f25762b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.b(this.f25761a, dVar.f25761a) && j.b(this.f25762b, dVar.f25762b) && j.b(this.f25763c, dVar.f25763c) && j.b(this.f25764d, dVar.f25764d) && j.b(this.f25765e, dVar.f25765e);
    }

    public int hashCode() {
        return (((((((this.f25761a.hashCode() * 31) + this.f25762b.hashCode()) * 31) + this.f25763c.hashCode()) * 31) + this.f25764d.hashCode()) * 31) + this.f25765e.hashCode();
    }

    public String toString() {
        return "CaptureTipsViewModel(helpButtonText=" + this.f25761a + ", title=" + this.f25762b + ", prompt=" + this.f25763c + ", tips=" + this.f25764d + ", buttonText=" + this.f25765e + PropertyUtils.MAPPED_DELIM2;
    }
}
