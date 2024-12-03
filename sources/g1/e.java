package g1;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;

final class e implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final KeyListener f15013a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15014b;

    public static class a {
        public boolean a(@NonNull Editable editable, int i10, @NonNull KeyEvent keyEvent) {
            return androidx.emoji2.text.e.f(editable, i10, keyEvent);
        }
    }

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    public void clearMetaKeyState(View view, Editable editable, int i10) {
        this.f15013a.clearMetaKeyState(view, editable, i10);
    }

    public int getInputType() {
        return this.f15013a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
        if (this.f15014b.a(editable, i10, keyEvent) || this.f15013a.onKeyDown(view, editable, i10, keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f15013a.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
        return this.f15013a.onKeyUp(view, editable, i10, keyEvent);
    }

    e(KeyListener keyListener, a aVar) {
        this.f15013a = keyListener;
        this.f15014b = aVar;
    }
}
