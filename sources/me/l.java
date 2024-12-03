package me;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.common.zzo;
import com.google.android.gms.internal.common.zzx;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.bouncycastle.i18n.LocalizedMessage;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f41269a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f41270b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f41271c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    @NonNull
    public static Map<String, String> a(@NonNull URI uri, @NonNull String str) {
        String str2;
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            emptyMap = new HashMap<>();
            zzx zzc = zzx.zzc(zzo.zzb(SignatureVisitor.INSTANCEOF));
            for (String zzf : zzx.zzc(zzo.zzb('&')).zzb().zzd(rawQuery)) {
                List zzf2 = zzc.zzf(zzf);
                if (zzf2.isEmpty() || zzf2.size() > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                String b10 = b((String) zzf2.get(0), str);
                if (zzf2.size() == 2) {
                    str2 = b((String) zzf2.get(1), str);
                } else {
                    str2 = null;
                }
                emptyMap.put(b10, str2);
            }
        }
        return emptyMap;
    }

    private static String b(String str, String str2) {
        if (str2 == null) {
            str2 = LocalizedMessage.DEFAULT_ENCODING;
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
