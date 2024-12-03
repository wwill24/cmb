package com.withpersona.sdk2.inquiry.types.collected_data;

import java.io.File;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class SelfieCapture {

    /* renamed from: a  reason: collision with root package name */
    private final CaptureMethod f29282a;

    /* renamed from: b  reason: collision with root package name */
    private final File f29283b;

    public enum CaptureMethod {
        Manual,
        Auto
    }

    public SelfieCapture(CaptureMethod captureMethod, File file) {
        j.g(captureMethod, "captureMethod");
        j.g(file, "data");
        this.f29282a = captureMethod;
        this.f29283b = file;
    }

    public final File a() {
        return this.f29283b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelfieCapture)) {
            return false;
        }
        SelfieCapture selfieCapture = (SelfieCapture) obj;
        return this.f29282a == selfieCapture.f29282a && j.b(this.f29283b, selfieCapture.f29283b);
    }

    public int hashCode() {
        return (this.f29282a.hashCode() * 31) + this.f29283b.hashCode();
    }

    public String toString() {
        return "SelfieCapture(captureMethod=" + this.f29282a + ", data=" + this.f29283b + PropertyUtils.MAPPED_DELIM2;
    }
}
