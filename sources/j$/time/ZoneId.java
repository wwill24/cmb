package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.o;
import j$.time.zone.c;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public abstract class ZoneId implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f42573a;

    static {
        HashMap hashMap = new HashMap(64);
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        f42573a = Collections.unmodifiableMap(hashMap);
    }

    ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != q.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId m(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.k(o.f());
        if (zoneId != null) {
            return zoneId;
        }
        throw new d("Unable to obtain ZoneId from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static ZoneId of(String str) {
        int i10;
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            return ZoneOffset.s(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            i10 = 3;
        } else if (!str.startsWith("UT")) {
            return q.q(str);
        } else {
            i10 = 2;
        }
        String substring = str.substring(0, i10);
        if (str.length() == i10) {
            return p(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i10) != '+' && str.charAt(i10) != '-') {
            return q.q(str);
        }
        try {
            ZoneOffset s10 = ZoneOffset.s(str.substring(i10));
            ZoneOffset zoneOffset = ZoneOffset.UTC;
            return p(substring, s10);
        } catch (d e10) {
            throw new d("Invalid ID for offset-based ZoneId: " + str, e10);
        }
    }

    public static ZoneId p(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, Range.ATTR_OFFSET);
        if (str.length() == 0) {
            return zoneOffset;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (zoneOffset.r() != 0) {
                str = str.concat(zoneOffset.n());
            }
            return new q(str, c.j(zoneOffset));
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return n().equals(((ZoneId) obj).n());
        }
        return false;
    }

    public int hashCode() {
        return n().hashCode();
    }

    public abstract String n();

    public abstract c o();

    public String toString() {
        return n();
    }
}
