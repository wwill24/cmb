package g5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mparticle.AttributionError;
import com.mparticle.AttributionListener;
import com.mparticle.AttributionResult;
import fa.a;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.json.b;

public final class a implements AttributionListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15189a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15190b = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private final String f15191c = "android_deeplink_path";

    public a(Context context) {
        j.g(context, "applicationContext");
        this.f15189a = context;
    }

    public void onError(AttributionError attributionError) {
        j.g(attributionError, "attributionError");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f15190b;
        j.f(str, "tag");
        aVar.a(str, "Got error: " + attributionError.getMessage());
    }

    public void onResult(AttributionResult attributionResult) {
        String str;
        j.g(attributionResult, MamElements.MamResultExtension.ELEMENT);
        b parameters = attributionResult.getParameters();
        boolean z10 = true;
        if (parameters == null || !parameters.has(this.f15191c)) {
            z10 = false;
        }
        if (z10) {
            b parameters2 = attributionResult.getParameters();
            if (parameters2 != null) {
                str = parameters2.getString(this.f15191c);
            } else {
                str = null;
            }
            a.C0491a aVar = fa.a.f40771d;
            String str2 = this.f15190b;
            j.f(str2, "tag");
            aVar.a(str2, "Got link: " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(335544320);
            this.f15189a.startActivity(intent);
            return;
        }
        a.C0491a aVar2 = fa.a.f40771d;
        String str3 = this.f15190b;
        j.f(str3, "tag");
        aVar2.a(str3, "No " + this.f15191c + " provided: " + attributionResult.getParameters());
    }
}
