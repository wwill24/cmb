package com.squareup.workflow1.ui.modal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001:\u0002\"\u000bBO\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a¢\u0006\u0004\b \u0010!J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007HÖ\u0001R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018R#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u0016\u0010\u001e¨\u0006#"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertScreen;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "Lcom/squareup/workflow1/ui/modal/AlertScreen$Button;", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "buttons", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "message", "e", "title", "d", "Z", "()Z", "cancelable", "Lkotlin/Function1;", "Lcom/squareup/workflow1/ui/modal/AlertScreen$a;", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "onEvent", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "Button", "wf1-container-common"}, k = 1, mv = {1, 6, 0})
public final class AlertScreen {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Button, String> f23251a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23252b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23253c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23254d;

    /* renamed from: e  reason: collision with root package name */
    private final Function1<a, Unit> f23255e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertScreen$Button;", "", "(Ljava/lang/String;I)V", "POSITIVE", "NEGATIVE", "NEUTRAL", "wf1-container-common"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Button {
        POSITIVE,
        NEGATIVE,
        NEUTRAL
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertScreen$a;", "", "<init>", "()V", "a", "b", "Lcom/squareup/workflow1/ui/modal/AlertScreen$a$a;", "Lcom/squareup/workflow1/ui/modal/AlertScreen$a$b;", "wf1-container-common"}, k = 1, mv = {1, 6, 0})
    public static abstract class a {

        @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertScreen$a$a;", "Lcom/squareup/workflow1/ui/modal/AlertScreen$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/squareup/workflow1/ui/modal/AlertScreen$Button;", "a", "Lcom/squareup/workflow1/ui/modal/AlertScreen$Button;", "getButton", "()Lcom/squareup/workflow1/ui/modal/AlertScreen$Button;", "button", "<init>", "(Lcom/squareup/workflow1/ui/modal/AlertScreen$Button;)V", "wf1-container-common"}, k = 1, mv = {1, 6, 0})
        /* renamed from: com.squareup.workflow1.ui.modal.AlertScreen$a$a  reason: collision with other inner class name */
        public static final class C0267a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final Button f23260a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0267a(Button button) {
                super((DefaultConstructorMarker) null);
                j.g(button, "button");
                this.f23260a = button;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0267a) && this.f23260a == ((C0267a) obj).f23260a;
            }

            public int hashCode() {
                return this.f23260a.hashCode();
            }

            public String toString() {
                return "ButtonClicked(button=" + this.f23260a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/squareup/workflow1/ui/modal/AlertScreen$a$b;", "Lcom/squareup/workflow1/ui/modal/AlertScreen$a;", "<init>", "()V", "wf1-container-common"}, k = 1, mv = {1, 6, 0})
        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f23261a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AlertScreen(Map<Button, String> map, String str, String str2, boolean z10, Function1<? super a, Unit> function1) {
        j.g(map, "buttons");
        j.g(str, "message");
        j.g(str2, "title");
        j.g(function1, "onEvent");
        this.f23251a = map;
        this.f23252b = str;
        this.f23253c = str2;
        this.f23254d = z10;
        this.f23255e = function1;
    }

    public final Map<Button, String> a() {
        return this.f23251a;
    }

    public final boolean b() {
        return this.f23254d;
    }

    public final String c() {
        return this.f23252b;
    }

    public final Function1<a, Unit> d() {
        return this.f23255e;
    }

    public final String e() {
        return this.f23253c;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<AlertScreen> cls2 = AlertScreen.class;
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        if (!j.b(cls2, cls)) {
            return false;
        }
        if (obj != null) {
            AlertScreen alertScreen = (AlertScreen) obj;
            if (!j.b(this.f23251a, alertScreen.f23251a) || !j.b(this.f23252b, alertScreen.f23252b) || !j.b(this.f23253c, alertScreen.f23253c) || this.f23254d != alertScreen.f23254d) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.squareup.workflow1.ui.modal.AlertScreen");
    }

    public int hashCode() {
        return (((((this.f23251a.hashCode() * 31) + this.f23252b.hashCode()) * 31) + this.f23253c.hashCode()) * 31) + Boolean.hashCode(this.f23254d);
    }

    public String toString() {
        return "AlertScreen(buttons=" + this.f23251a + ", message=" + this.f23252b + ", title=" + this.f23253c + ", cancelable=" + this.f23254d + ", onEvent=" + this.f23255e + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AlertScreen(Map map, String str, String str2, boolean z10, Function1 function1, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? h0.i() : map, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? true : z10, function1);
    }
}
