package w0;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.core.util.c;
import androidx.core.util.h;
import androidx.core.view.c;
import androidx.core.view.n0;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class d {

    class a extends InputConnectionWrapper {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f18159a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(InputConnection inputConnection, boolean z10, b bVar) {
            super(inputConnection, z10);
            this.f18159a = bVar;
        }

        public boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
            if (this.f18159a.a(e.f(inputContentInfo), i10, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i10, bundle);
        }
    }

    public interface b {
        boolean a(@NonNull e eVar, int i10, Bundle bundle);
    }

    @NonNull
    private static b b(@NonNull View view) {
        h.g(view);
        return new c(view);
    }

    @NonNull
    public static InputConnection c(@NonNull View view, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return d(inputConnection, editorInfo, b(view));
    }

    @NonNull
    @Deprecated
    public static InputConnection d(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull b bVar) {
        c.d(inputConnection, "inputConnection must be non-null");
        c.d(editorInfo, "editorInfo must be non-null");
        c.d(bVar, "onCommitContentListener must be non-null");
        return new a(inputConnection, false, bVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean e(View view, e eVar, int i10, Bundle bundle) {
        if ((i10 & 1) != 0) {
            try {
                eVar.d();
                InputContentInfo inputContentInfo = (InputContentInfo) eVar.e();
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception unused) {
                return false;
            }
        }
        if (n0.i0(view, new c.a(new ClipData(eVar.b(), new ClipData.Item(eVar.a())), 2).d(eVar.c()).b(bundle).a()) == null) {
            return true;
        }
        return false;
    }
}
