package com.facebook.login;

import android.os.Bundle;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.ServerProtocol;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.d;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import vk.c;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0006H\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/PKCEUtil;", "", "()V", "createCodeExchangeRequest", "Lcom/facebook/GraphRequest;", "authorizationCode", "", "redirectUri", "codeVerifier", "generateCodeChallenge", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "generateCodeVerifier", "isValidCodeVerifier", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PKCEUtil {
    public static final PKCEUtil INSTANCE = new PKCEUtil();

    private PKCEUtil() {
    }

    public static final GraphRequest createCodeExchangeRequest(String str, String str2, String str3) {
        j.g(str, "authorizationCode");
        j.g(str2, "redirectUri");
        j.g(str3, "codeVerifier");
        Bundle bundle = new Bundle();
        bundle.putString("code", str);
        bundle.putString("client_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, str2);
        bundle.putString("code_verifier", str3);
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "oauth/access_token", (GraphRequest.Callback) null);
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(bundle);
        return newGraphPathRequest;
    }

    public static final String generateCodeChallenge(String str, CodeChallengeMethod codeChallengeMethod) throws FacebookException {
        j.g(str, "codeVerifier");
        j.g(codeChallengeMethod, "codeChallengeMethod");
        if (!isValidCodeVerifier(str)) {
            throw new FacebookException("Invalid Code Verifier.");
        } else if (codeChallengeMethod == CodeChallengeMethod.PLAIN) {
            return str;
        } else {
            try {
                byte[] bytes = str.getBytes(d.f32220f);
                j.f(bytes, "(this as java.lang.String).getBytes(charset)");
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                instance.update(bytes, 0, bytes.length);
                String encodeToString = Base64.encodeToString(instance.digest(), 11);
                j.f(encodeToString, "{\n      // try to generate challenge with S256\n      val bytes: ByteArray = codeVerifier.toByteArray(Charsets.US_ASCII)\n      val messageDigest = MessageDigest.getInstance(\"SHA-256\")\n      messageDigest.update(bytes, 0, bytes.size)\n      val digest = messageDigest.digest()\n\n      Base64.encodeToString(digest, Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP)\n    }");
                return encodeToString;
            } catch (Exception e10) {
                throw new FacebookException((Throwable) e10);
            }
        }
    }

    public static final String generateCodeVerifier() {
        int m10 = j.m(new IntRange(43, 128), Random.f32142a);
        List i02 = CollectionsKt___CollectionsKt.i0(CollectionsKt___CollectionsKt.i0(CollectionsKt___CollectionsKt.i0(CollectionsKt___CollectionsKt.i0(CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.g0(new c('a', 'z'), new c('A', Matrix.MATRIX_TYPE_ZERO)), new c('0', '9')), Character.valueOf(SignatureVisitor.SUPER)), '.'), '_'), '~');
        ArrayList arrayList = new ArrayList(m10);
        for (int i10 = 0; i10 < m10; i10++) {
            arrayList.add(Character.valueOf(((Character) CollectionsKt___CollectionsKt.j0(i02, Random.f32142a)).charValue()));
        }
        return CollectionsKt___CollectionsKt.W(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final boolean isValidCodeVerifier(String str) {
        boolean z10;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || str.length() < 43 || str.length() > 128) {
            return false;
        }
        return new Regex("^[-._~A-Za-z0-9]+$").e(str);
    }
}
