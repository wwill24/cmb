package com.withpersona.sdk2.inquiry.types.collected_data;

import java.io.File;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class GovernmentIdCapture {

    /* renamed from: a  reason: collision with root package name */
    private final String f29268a;

    /* renamed from: b  reason: collision with root package name */
    private final Side f29269b;

    /* renamed from: c  reason: collision with root package name */
    private final CaptureMethod f29270c;

    /* renamed from: d  reason: collision with root package name */
    private final List<a> f29271d;

    public enum CaptureMethod {
        Manual,
        Auto,
        Upload
    }

    public enum Side {
        Front,
        Back,
        FrontAndBack
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final File f29280a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29281b;

        public a(File file, String str) {
            j.g(file, "data");
            j.g(str, "mimeType");
            this.f29280a = file;
            this.f29281b = str;
        }

        public final File a() {
            return this.f29280a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return j.b(this.f29280a, aVar.f29280a) && j.b(this.f29281b, aVar.f29281b);
        }

        public int hashCode() {
            return (this.f29280a.hashCode() * 31) + this.f29281b.hashCode();
        }

        public String toString() {
            return "Frame(data=" + this.f29280a + ", mimeType=" + this.f29281b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public GovernmentIdCapture(String str, Side side, CaptureMethod captureMethod, List<a> list) {
        j.g(str, "idClass");
        j.g(side, "side");
        j.g(captureMethod, "captureMethod");
        j.g(list, "frames");
        this.f29268a = str;
        this.f29269b = side;
        this.f29270c = captureMethod;
        this.f29271d = list;
    }

    public final List<a> a() {
        return this.f29271d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GovernmentIdCapture)) {
            return false;
        }
        GovernmentIdCapture governmentIdCapture = (GovernmentIdCapture) obj;
        return j.b(this.f29268a, governmentIdCapture.f29268a) && this.f29269b == governmentIdCapture.f29269b && this.f29270c == governmentIdCapture.f29270c && j.b(this.f29271d, governmentIdCapture.f29271d);
    }

    public int hashCode() {
        return (((((this.f29268a.hashCode() * 31) + this.f29269b.hashCode()) * 31) + this.f29270c.hashCode()) * 31) + this.f29271d.hashCode();
    }

    public String toString() {
        return "GovernmentIdCapture(idClass=" + this.f29268a + ", side=" + this.f29269b + ", captureMethod=" + this.f29270c + ", frames=" + this.f29271d + PropertyUtils.MAPPED_DELIM2;
    }
}
