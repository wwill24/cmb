package th;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smack.util.StringUtils;

public class c {

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f24633f;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f24634g;

    /* renamed from: a  reason: collision with root package name */
    private String f24635a;

    /* renamed from: b  reason: collision with root package name */
    private String f24636b;

    /* renamed from: c  reason: collision with root package name */
    private String f24637c;

    /* renamed from: d  reason: collision with root package name */
    private String f24638d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f24639e;

    static {
        Boolean bool = Boolean.FALSE;
        f24633f = bool;
        f24634g = bool;
    }

    public c(String str, String str2, String str3, String str4, Map<String, String> map) {
        this.f24635a = str;
        this.f24636b = str2;
        this.f24637c = str3;
        this.f24638d = str4;
        this.f24639e = new TreeMap(map);
    }

    private static String a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(StringUtils.MD5).digest(str.getBytes("UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : digest) {
                stringBuffer.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static String b(String str, String str2, String str3, String str4) {
        String format2 = String.format("%s://%s%s?%s", new Object[]{str, str2, str3, str4});
        if (format2.endsWith("#")) {
            format2 = format2.substring(0, format2.length() - 1);
        }
        if (format2.endsWith(TypeDescription.Generic.OfWildcardType.SYMBOL)) {
            return format2.substring(0, format2.length() - 1);
        }
        return format2;
    }

    public static Map<String, Boolean> c(String str) {
        HashMap hashMap = new HashMap();
        str.replaceAll("^/", "");
        if (str.startsWith("http://") || str.startsWith("https://")) {
            f24634g = Boolean.TRUE;
            f24633f = Boolean.FALSE;
        } else if (str.startsWith("http%3A%2F%2F") || str.startsWith("https%3A%2F%2F") || str.startsWith("http%3a%2f%2f") || str.startsWith("https%3a%2f%2f")) {
            Boolean bool = Boolean.TRUE;
            f24634g = bool;
            f24633f = bool;
        } else {
            Boolean bool2 = Boolean.FALSE;
            f24634g = bool2;
            f24633f = bool2;
        }
        hashMap.put("isProxy", f24634g);
        hashMap.put("isEncoded", f24633f);
        return hashMap;
    }

    private String d(String str) {
        try {
            return new String(Base64.getEncoder().encode(str.getBytes("UTF-8")), "UTF-8").replace("=", "").replace('/', '_').replace(SignatureVisitor.EXTENDS, SignatureVisitor.SUPER);
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static String e(String str) {
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING);
        for (int i10 = 0; i10 < split.length; i10++) {
            try {
                split[i10] = URLEncoder.encode(split[i10], "UTF-8").replaceAll("\\+", "%20").replaceAll("\\:", "%3A").replaceAll("\\?", "%3F").replaceAll("\\#", "%23").replaceAll(" ", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return b.a(RemoteSettings.FORWARD_SLASH_STRING, split);
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private static String h(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        for (String append : list) {
            sb2.append(str2);
            sb2.append(append);
            str2 = str;
        }
        return sb2.toString();
    }

    public static String i(String str) {
        String replaceAll = str.replaceAll("^/", "");
        Map<String, Boolean> c10 = c(replaceAll);
        Boolean bool = c10.get("isProxy");
        Boolean bool2 = c10.get("isEncoded");
        Boolean bool3 = Boolean.TRUE;
        if (bool.equals(bool3) && bool2.equals(Boolean.FALSE)) {
            return RemoteSettings.FORWARD_SLASH_STRING + f(replaceAll);
        } else if (!bool.equals(bool3) || !bool2.equals(bool3)) {
            return RemoteSettings.FORWARD_SLASH_STRING + e(replaceAll);
        } else {
            return RemoteSettings.FORWARD_SLASH_STRING + replaceAll;
        }
    }

    public String g() {
        String str;
        String str2;
        this.f24636b = i(this.f24636b);
        LinkedList linkedList = new LinkedList();
        for (Map.Entry next : this.f24639e.entrySet()) {
            String f10 = f((String) next.getKey());
            String str3 = (String) next.getValue();
            if (f10.endsWith("64")) {
                str2 = d(str3);
            } else {
                str2 = f(str3);
            }
            linkedList.add(f10 + "=" + str2);
        }
        String h10 = h(linkedList, "&");
        String str4 = this.f24638d;
        if (str4 == null || str4.length() <= 0) {
            return b(this.f24637c, this.f24635a, this.f24636b, h10);
        }
        String str5 = "";
        if (!h10.equals(str5)) {
            str5 = TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        String a10 = a(this.f24638d + this.f24636b + str5 + h10);
        if (h10.length() > 0) {
            str = h10 + "&s=" + a10;
        } else {
            str = "s=" + a10;
        }
        return b(this.f24637c, this.f24635a, this.f24636b, str);
    }

    public String toString() {
        return g();
    }
}
