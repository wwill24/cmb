package com.google.firebase.database.core.utilities;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;

public class Utilities {
    private static final char[] HEX_CHARACTERS = "0123456789abcdef".toCharArray();

    public static <C> C castOrNull(Object obj, Class<C> cls) {
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        return null;
    }

    public static int compareInts(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static int compareLongs(long j10, long j11) {
        int i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
        if (i10 < 0) {
            return -1;
        }
        return i10 == 0 ? 0 : 1;
    }

    public static String doubleToHashString(double d10) {
        StringBuilder sb2 = new StringBuilder(16);
        long doubleToLongBits = Double.doubleToLongBits(d10);
        for (int i10 = 7; i10 >= 0; i10--) {
            int i11 = (int) ((doubleToLongBits >>> (i10 * 8)) & 255);
            char[] cArr = HEX_CHARACTERS;
            sb2.append(cArr[(i11 >> 4) & 15]);
            sb2.append(cArr[i11 & 15]);
        }
        return sb2.toString();
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    private static String extractPathString(String str) {
        int indexOf = str.indexOf("//");
        if (indexOf != -1) {
            String substring = str.substring(indexOf + 2);
            int indexOf2 = substring.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
            if (indexOf2 == -1) {
                return "";
            }
            int indexOf3 = substring.indexOf(TypeDescription.Generic.OfWildcardType.SYMBOL);
            if (indexOf3 != -1) {
                return substring.substring(indexOf2 + 1, indexOf3);
            }
            return substring.substring(indexOf2 + 1);
        }
        throw new DatabaseException("Firebase Database URL is missing URL scheme");
    }

    public static <C> C getOrNull(Object obj, String str, Class<C> cls) {
        Object obj2;
        if (obj == null || (obj2 = ((Map) castOrNull(obj, Map.class)).get(str)) == null) {
            return null;
        }
        return castOrNull(obj2, cls);
    }

    public static void hardAssert(boolean z10) {
        hardAssert(z10, "");
    }

    public static ParsedUrl parseUrl(@NonNull String str) throws DatabaseException {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme != null) {
                String host = parse.getHost();
                if (host != null) {
                    String queryParameter = parse.getQueryParameter("ns");
                    boolean z10 = false;
                    if (queryParameter == null) {
                        queryParameter = host.split("\\.", -1)[0].toLowerCase(Locale.US);
                    }
                    RepoInfo repoInfo = new RepoInfo();
                    repoInfo.host = host.toLowerCase(Locale.US);
                    int port = parse.getPort();
                    if (port != -1) {
                        if (scheme.equals("https") || scheme.equals("wss")) {
                            z10 = true;
                        }
                        repoInfo.secure = z10;
                        repoInfo.host += CertificateUtil.DELIMITER + port;
                    } else {
                        repoInfo.secure = true;
                    }
                    repoInfo.internalHost = repoInfo.host;
                    repoInfo.namespace = queryParameter;
                    String replace = extractPathString(str).replace("+", " ");
                    Validation.validateRootPathString(replace);
                    ParsedUrl parsedUrl = new ParsedUrl();
                    parsedUrl.path = new Path(replace);
                    parsedUrl.repoInfo = repoInfo;
                    return parsedUrl;
                }
                throw new IllegalArgumentException("Database URL does not specify a valid host");
            }
            throw new IllegalArgumentException("Database URL does not specify a URL scheme");
        } catch (Exception e10) {
            throw new DatabaseException("Invalid Firebase Database url specified: " + str, e10);
        }
    }

    public static String sha1HexDigest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(instance.digest(), 2);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e10);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        }
    }

    public static String stringHashV2Representation(String str) {
        String str2;
        if (str.indexOf(92) != -1) {
            str2 = str.replace("\\", "\\\\");
        } else {
            str2 = str;
        }
        if (str.indexOf(34) != -1) {
            str2 = str2.replace("\"", "\\\"");
        }
        return '\"' + str2 + '\"';
    }

    public static Integer tryParseInt(String str) {
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        int i10 = 0;
        boolean z10 = true;
        if (str.charAt(0) != '-') {
            z10 = false;
        } else if (str.length() == 1) {
            return null;
        } else {
            i10 = 1;
        }
        long j10 = 0;
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            j10 = (j10 * 10) + ((long) (charAt - '0'));
            i10++;
        }
        if (z10) {
            long j11 = -j10;
            if (j11 < -2147483648L) {
                return null;
            }
            return Integer.valueOf((int) j11);
        } else if (j10 > 2147483647L) {
            return null;
        } else {
            return Integer.valueOf((int) j10);
        }
    }

    public static Pair<Task<Void>, DatabaseReference.CompletionListener> wrapOnComplete(DatabaseReference.CompletionListener completionListener) {
        if (completionListener != null) {
            return new Pair<>(null, completionListener);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return new Pair<>(taskCompletionSource.getTask(), new DatabaseReference.CompletionListener() {
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    TaskCompletionSource.this.setException(databaseError.toException());
                } else {
                    TaskCompletionSource.this.setResult(null);
                }
            }
        });
    }

    public static void hardAssert(boolean z10, String str) {
        if (!z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Assertion failed: ");
            sb2.append(str);
        }
    }
}
