package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
import java.util.Objects;

public final class m extends j {

    /* renamed from: a  reason: collision with root package name */
    private final Object f21378a;

    public m(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f21378a = bool;
    }

    private static boolean u(m mVar) {
        Object obj = mVar.f21378a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f21378a == null) {
            if (mVar.f21378a == null) {
                return true;
            }
            return false;
        } else if (!u(this) || !u(mVar)) {
            Object obj2 = this.f21378a;
            if (!(obj2 instanceof Number) || !(mVar.f21378a instanceof Number)) {
                return obj2.equals(mVar.f21378a);
            }
            double doubleValue = r().doubleValue();
            double doubleValue2 = mVar.r().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (r().longValue() == mVar.r().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f21378a == null) {
            return 31;
        }
        if (u(this)) {
            doubleToLongBits = r().longValue();
        } else {
            Object obj = this.f21378a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(r().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean n() {
        if (t()) {
            return ((Boolean) this.f21378a).booleanValue();
        }
        return Boolean.parseBoolean(s());
    }

    public double o() {
        return v() ? r().doubleValue() : Double.parseDouble(s());
    }

    public int p() {
        return v() ? r().intValue() : Integer.parseInt(s());
    }

    public long q() {
        return v() ? r().longValue() : Long.parseLong(s());
    }

    public Number r() {
        Object obj = this.f21378a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String s() {
        Object obj = this.f21378a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (v()) {
            return r().toString();
        }
        if (t()) {
            return ((Boolean) this.f21378a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f21378a.getClass());
    }

    public boolean t() {
        return this.f21378a instanceof Boolean;
    }

    public boolean v() {
        return this.f21378a instanceof Number;
    }

    public boolean w() {
        return this.f21378a instanceof String;
    }

    public m(Number number) {
        Objects.requireNonNull(number);
        this.f21378a = number;
    }

    public m(String str) {
        Objects.requireNonNull(str);
        this.f21378a = str;
    }
}
