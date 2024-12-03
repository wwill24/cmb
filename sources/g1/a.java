package g1;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import com.google.android.gms.common.api.a;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f14999a;

    /* renamed from: b  reason: collision with root package name */
    private int f15000b = a.e.API_PRIORITY_OTHER;

    /* renamed from: c  reason: collision with root package name */
    private int f15001c = 0;

    /* renamed from: g1.a$a  reason: collision with other inner class name */
    private static class C0160a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f15002a;

        /* renamed from: b  reason: collision with root package name */
        private final g f15003b;

        C0160a(@NonNull EditText editText, boolean z10) {
            this.f15002a = editText;
            g gVar = new g(editText, z10);
            this.f15003b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(b.getInstance());
        }

        /* access modifiers changed from: package-private */
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new e(keyListener);
        }

        /* access modifiers changed from: package-private */
        public InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            if (inputConnection instanceof c) {
                return inputConnection;
            }
            return new c(this.f15002a, inputConnection, editorInfo);
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            this.f15003b.c(z10);
        }
    }

    static class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        public KeyListener a(KeyListener keyListener) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public InputConnection b(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            throw null;
        }
    }

    public a(@NonNull EditText editText, boolean z10) {
        h.h(editText, "editText cannot be null");
        this.f14999a = new C0160a(editText, z10);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f14999a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f14999a.b(inputConnection, editorInfo);
    }

    public void c(boolean z10) {
        this.f14999a.c(z10);
    }
}
