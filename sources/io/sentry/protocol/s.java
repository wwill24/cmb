package io.sentry.protocol;

import com.facebook.internal.AnalyticsEvents;
import com.leanplum.internal.Constants;
import io.sentry.a1;
import io.sentry.c1;
import io.sentry.h0;
import io.sentry.s0;
import io.sentry.vendor.gson.stream.JsonToken;
import io.sentry.y0;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class s implements c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31537a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31538b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31539c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Integer f31540d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Integer f31541e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f31542f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f31543g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Boolean f31544h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f31545j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Boolean f31546k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String f31547l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f31548m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f31549n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f31550p;

    /* renamed from: q  reason: collision with root package name */
    private Map<String, Object> f31551q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public String f31552t;

    public static final class a implements s0<s> {
        /* renamed from: b */
        public s a(y0 y0Var, h0 h0Var) throws Exception {
            s sVar = new s();
            y0Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (y0Var.J() == JsonToken.NAME) {
                String y10 = y0Var.y();
                y10.hashCode();
                char c10 = 65535;
                switch (y10.hashCode()) {
                    case -1443345323:
                        if (y10.equals("image_addr")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1184392185:
                        if (y10.equals("in_app")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1113875953:
                        if (y10.equals("raw_function")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1102671691:
                        if (y10.equals("lineno")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1068784020:
                        if (y10.equals("module")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (y10.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -807062458:
                        if (y10.equals("package")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -734768633:
                        if (y10.equals(Constants.Keys.FILENAME)) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -330260936:
                        if (y10.equals("symbol_addr")) {
                            c10 = 8;
                            break;
                        }
                        break;
                    case 94842689:
                        if (y10.equals("colno")) {
                            c10 = 9;
                            break;
                        }
                        break;
                    case 410194178:
                        if (y10.equals("instruction_addr")) {
                            c10 = 10;
                            break;
                        }
                        break;
                    case 1116694660:
                        if (y10.equals("context_line")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case 1380938712:
                        if (y10.equals("function")) {
                            c10 = 12;
                            break;
                        }
                        break;
                    case 1713445842:
                        if (y10.equals("abs_path")) {
                            c10 = 13;
                            break;
                        }
                        break;
                    case 1874684019:
                        if (y10.equals("platform")) {
                            c10 = 14;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        String unused = sVar.f31548m = y0Var.H0();
                        break;
                    case 1:
                        Boolean unused2 = sVar.f31544h = y0Var.m0();
                        break;
                    case 2:
                        String unused3 = sVar.f31552t = y0Var.H0();
                        break;
                    case 3:
                        Integer unused4 = sVar.f31540d = y0Var.u0();
                        break;
                    case 4:
                        String unused5 = sVar.f31539c = y0Var.H0();
                        break;
                    case 5:
                        Boolean unused6 = sVar.f31546k = y0Var.m0();
                        break;
                    case 6:
                        String unused7 = sVar.f31545j = y0Var.H0();
                        break;
                    case 7:
                        String unused8 = sVar.f31537a = y0Var.H0();
                        break;
                    case 8:
                        String unused9 = sVar.f31549n = y0Var.H0();
                        break;
                    case 9:
                        Integer unused10 = sVar.f31541e = y0Var.u0();
                        break;
                    case 10:
                        String unused11 = sVar.f31550p = y0Var.H0();
                        break;
                    case 11:
                        String unused12 = sVar.f31543g = y0Var.H0();
                        break;
                    case 12:
                        String unused13 = sVar.f31538b = y0Var.H0();
                        break;
                    case 13:
                        String unused14 = sVar.f31542f = y0Var.H0();
                        break;
                    case 14:
                        String unused15 = sVar.f31547l = y0Var.H0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        y0Var.N0(h0Var, concurrentHashMap, y10);
                        break;
                }
            }
            sVar.v(concurrentHashMap);
            y0Var.h();
            return sVar;
        }
    }

    public void p(String str) {
        this.f31537a = str;
    }

    public void q(String str) {
        this.f31538b = str;
    }

    public void r(Boolean bool) {
        this.f31544h = bool;
    }

    public void s(Integer num) {
        this.f31540d = num;
    }

    public void serialize(a1 a1Var, h0 h0Var) throws IOException {
        a1Var.e();
        if (this.f31537a != null) {
            a1Var.N(Constants.Keys.FILENAME).I(this.f31537a);
        }
        if (this.f31538b != null) {
            a1Var.N("function").I(this.f31538b);
        }
        if (this.f31539c != null) {
            a1Var.N("module").I(this.f31539c);
        }
        if (this.f31540d != null) {
            a1Var.N("lineno").G(this.f31540d);
        }
        if (this.f31541e != null) {
            a1Var.N("colno").G(this.f31541e);
        }
        if (this.f31542f != null) {
            a1Var.N("abs_path").I(this.f31542f);
        }
        if (this.f31543g != null) {
            a1Var.N("context_line").I(this.f31543g);
        }
        if (this.f31544h != null) {
            a1Var.N("in_app").F(this.f31544h);
        }
        if (this.f31545j != null) {
            a1Var.N("package").I(this.f31545j);
        }
        if (this.f31546k != null) {
            a1Var.N(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE).F(this.f31546k);
        }
        if (this.f31547l != null) {
            a1Var.N("platform").I(this.f31547l);
        }
        if (this.f31548m != null) {
            a1Var.N("image_addr").I(this.f31548m);
        }
        if (this.f31549n != null) {
            a1Var.N("symbol_addr").I(this.f31549n);
        }
        if (this.f31550p != null) {
            a1Var.N("instruction_addr").I(this.f31550p);
        }
        if (this.f31552t != null) {
            a1Var.N("raw_function").I(this.f31552t);
        }
        Map<String, Object> map = this.f31551q;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.f31551q.get(next);
                a1Var.N(next);
                a1Var.O(h0Var, obj);
            }
        }
        a1Var.h();
    }

    public void t(String str) {
        this.f31539c = str;
    }

    public void u(Boolean bool) {
        this.f31546k = bool;
    }

    public void v(Map<String, Object> map) {
        this.f31551q = map;
    }
}
