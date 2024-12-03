package com.withpersona.sdk2.inquiry.steps.ui.network;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

abstract class d {

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, Object> f28344a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map<String, ? extends Object> map) {
            super((DefaultConstructorMarker) null);
            j.g(map, "expression");
            this.f28344a = map;
        }

        public final Map<String, Object> a() {
            return this.f28344a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && j.b(this.f28344a, ((a) obj).f28344a);
        }

        public int hashCode() {
            return this.f28344a.hashCode();
        }

        public String toString() {
            return "ComplexRules(expression=" + this.f28344a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        private final Object f28345a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Object obj) {
            super((DefaultConstructorMarker) null);
            j.g(obj, "value");
            this.f28345a = obj;
        }

        public final Object a() {
            return this.f28345a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && j.b(this.f28345a, ((b) obj).f28345a);
        }

        public int hashCode() {
            return this.f28345a.hashCode();
        }

        public String toString() {
            return "PrimitiveRule(value=" + this.f28345a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
