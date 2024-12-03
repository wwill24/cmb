package io.sentry;

import io.sentry.util.j;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class z0 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f31819a;

    public z0(int i10) {
        this.f31819a = new b1(i10);
    }

    private void b(a1 a1Var, h0 h0Var, Collection<?> collection) throws IOException {
        a1Var.c();
        for (Object a10 : collection) {
            a(a1Var, h0Var, a10);
        }
        a1Var.g();
    }

    private void c(a1 a1Var, h0 h0Var, Date date) throws IOException {
        try {
            a1Var.I(g.g(date));
        } catch (Exception e10) {
            h0Var.b(SentryLevel.ERROR, "Error when serializing Date", e10);
            a1Var.m();
        }
    }

    private void d(a1 a1Var, h0 h0Var, Map<?, ?> map) throws IOException {
        a1Var.e();
        for (Object next : map.keySet()) {
            if (next instanceof String) {
                a1Var.N((String) next);
                a(a1Var, h0Var, map.get(next));
            }
        }
        a1Var.h();
    }

    private void e(a1 a1Var, h0 h0Var, TimeZone timeZone) throws IOException {
        try {
            a1Var.I(timeZone.getID());
        } catch (Exception e10) {
            h0Var.b(SentryLevel.ERROR, "Error when serializing TimeZone", e10);
            a1Var.m();
        }
    }

    public void a(a1 a1Var, h0 h0Var, Object obj) throws IOException {
        if (obj == null) {
            a1Var.m();
        } else if (obj instanceof Character) {
            a1Var.I(Character.toString(((Character) obj).charValue()));
        } else if (obj instanceof String) {
            a1Var.I((String) obj);
        } else if (obj instanceof Boolean) {
            a1Var.J(((Boolean) obj).booleanValue());
        } else if (obj instanceof Number) {
            a1Var.G((Number) obj);
        } else if (obj instanceof Date) {
            c(a1Var, h0Var, (Date) obj);
        } else if (obj instanceof TimeZone) {
            e(a1Var, h0Var, (TimeZone) obj);
        } else if (obj instanceof c1) {
            ((c1) obj).serialize(a1Var, h0Var);
        } else if (obj instanceof Collection) {
            b(a1Var, h0Var, (Collection) obj);
        } else if (obj.getClass().isArray()) {
            b(a1Var, h0Var, Arrays.asList((Object[]) obj));
        } else if (obj instanceof Map) {
            d(a1Var, h0Var, (Map) obj);
        } else if (obj instanceof Locale) {
            a1Var.I(obj.toString());
        } else if (obj instanceof AtomicIntegerArray) {
            b(a1Var, h0Var, j.a((AtomicIntegerArray) obj));
        } else if (obj instanceof AtomicBoolean) {
            a1Var.J(((AtomicBoolean) obj).get());
        } else if (obj instanceof URI) {
            a1Var.I(obj.toString());
        } else if (obj instanceof InetAddress) {
            a1Var.I(obj.toString());
        } else if (obj instanceof UUID) {
            a1Var.I(obj.toString());
        } else if (obj instanceof Currency) {
            a1Var.I(obj.toString());
        } else if (obj instanceof Calendar) {
            d(a1Var, h0Var, j.c((Calendar) obj));
        } else if (obj.getClass().isEnum()) {
            a1Var.I(obj.toString());
        } else {
            try {
                a(a1Var, h0Var, this.f31819a.d(obj, h0Var));
            } catch (Exception e10) {
                h0Var.b(SentryLevel.ERROR, "Failed serializing unknown object.", e10);
                a1Var.I("[OBJECT]");
            }
        }
    }
}
