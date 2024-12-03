package com.withpersona.sdk2.inquiry.types.collected_data;

import com.withpersona.sdk2.inquiry.types.collected_data.GovernmentIdCapture;
import java.io.Closeable;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class a implements Closeable {

    /* renamed from: com.withpersona.sdk2.inquiry.types.collected_data.a$a  reason: collision with other inner class name */
    public static final class C0332a extends a {

        /* renamed from: a  reason: collision with root package name */
        private final String f29287a;

        /* renamed from: b  reason: collision with root package name */
        private final List<dj.c> f29288b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0332a(String str, List<dj.c> list) {
            super((DefaultConstructorMarker) null);
            j.g(str, "stepName");
            j.g(list, "documents");
            this.f29287a = str;
            this.f29288b = list;
        }

        public String a() {
            return this.f29287a;
        }

        public void close() {
            for (dj.c a10 : this.f29288b) {
                a10.a().delete();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0332a)) {
                return false;
            }
            C0332a aVar = (C0332a) obj;
            return j.b(a(), aVar.a()) && j.b(this.f29288b, aVar.f29288b);
        }

        public int hashCode() {
            return (a().hashCode() * 31) + this.f29288b.hashCode();
        }

        public String toString() {
            return "DocumentStepData(stepName=" + a() + ", documents=" + this.f29288b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final String f29289a;

        /* renamed from: b  reason: collision with root package name */
        private final List<GovernmentIdCapture> f29290b;

        /* renamed from: c  reason: collision with root package name */
        private final dj.b f29291c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, List<GovernmentIdCapture> list, dj.b bVar) {
            super((DefaultConstructorMarker) null);
            j.g(str, "stepName");
            j.g(list, "captures");
            j.g(bVar, "idDetails");
            this.f29289a = str;
            this.f29290b = list;
            this.f29291c = bVar;
        }

        public String a() {
            return this.f29289a;
        }

        public void close() {
            for (GovernmentIdCapture a10 : this.f29290b) {
                for (GovernmentIdCapture.a a11 : a10.a()) {
                    a11.a().delete();
                }
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return j.b(a(), bVar.a()) && j.b(this.f29290b, bVar.f29290b) && j.b(this.f29291c, bVar.f29291c);
        }

        public int hashCode() {
            return (((a().hashCode() * 31) + this.f29290b.hashCode()) * 31) + this.f29291c.hashCode();
        }

        public String toString() {
            return "GovernmentIdStepData(stepName=" + a() + ", captures=" + this.f29290b + ", idDetails=" + this.f29291c + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private final String f29292a;

        /* renamed from: b  reason: collision with root package name */
        private final SelfieCapture f29293b;

        /* renamed from: c  reason: collision with root package name */
        private final SelfieCapture f29294c;

        /* renamed from: d  reason: collision with root package name */
        private final SelfieCapture f29295d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, SelfieCapture selfieCapture, SelfieCapture selfieCapture2, SelfieCapture selfieCapture3) {
            super((DefaultConstructorMarker) null);
            j.g(str, "stepName");
            this.f29292a = str;
            this.f29293b = selfieCapture;
            this.f29294c = selfieCapture2;
            this.f29295d = selfieCapture3;
        }

        public String a() {
            return this.f29292a;
        }

        public void close() {
            File a10;
            for (SelfieCapture selfieCapture : q.m(this.f29293b, this.f29294c, this.f29295d)) {
                if (!(selfieCapture == null || (a10 = selfieCapture.a()) == null)) {
                    a10.delete();
                }
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return j.b(a(), cVar.a()) && j.b(this.f29293b, cVar.f29293b) && j.b(this.f29294c, cVar.f29294c) && j.b(this.f29295d, cVar.f29295d);
        }

        public int hashCode() {
            int hashCode = a().hashCode() * 31;
            SelfieCapture selfieCapture = this.f29293b;
            int i10 = 0;
            int hashCode2 = (hashCode + (selfieCapture == null ? 0 : selfieCapture.hashCode())) * 31;
            SelfieCapture selfieCapture2 = this.f29294c;
            int hashCode3 = (hashCode2 + (selfieCapture2 == null ? 0 : selfieCapture2.hashCode())) * 31;
            SelfieCapture selfieCapture3 = this.f29295d;
            if (selfieCapture3 != null) {
                i10 = selfieCapture3.hashCode();
            }
            return hashCode3 + i10;
        }

        public String toString() {
            return "SelfieStepData(stepName=" + a() + ", centerCapture=" + this.f29293b + ", leftCapture=" + this.f29294c + ", rightCapture=" + this.f29295d + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private final String f29296a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, Object> f29297b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, Map<String, ? extends Object> map) {
            super((DefaultConstructorMarker) null);
            j.g(str, "stepName");
            j.g(map, "componentParams");
            this.f29296a = str;
            this.f29297b = map;
        }

        public String a() {
            return this.f29296a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return j.b(a(), dVar.a()) && j.b(this.f29297b, dVar.f29297b);
        }

        public int hashCode() {
            return (a().hashCode() * 31) + this.f29297b.hashCode();
        }

        public String toString() {
            return "UiStepData(stepName=" + a() + ", componentParams=" + this.f29297b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void close() {
    }
}
