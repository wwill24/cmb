package io.sentry.android.core.internal.gestures;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.GestureDetectorCompat;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class h extends j {

    /* renamed from: b  reason: collision with root package name */
    private final Window.Callback f31013b;

    /* renamed from: c  reason: collision with root package name */
    private final g f31014c;

    /* renamed from: d  reason: collision with root package name */
    private final GestureDetectorCompat f31015d;

    /* renamed from: e  reason: collision with root package name */
    private final SentryOptions f31016e;

    /* renamed from: f  reason: collision with root package name */
    private final b f31017f;

    class a implements b {
        a() {
        }
    }

    interface b {
        MotionEvent a(MotionEvent motionEvent) {
            return MotionEvent.obtain(motionEvent);
        }
    }

    public h(Window.Callback callback, Context context, g gVar, SentryOptions sentryOptions) {
        this(callback, new GestureDetectorCompat(context, gVar), gVar, sentryOptions, new a());
    }

    private void b(MotionEvent motionEvent) {
        this.f31015d.a(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            this.f31014c.n(motionEvent);
        }
    }

    public Window.Callback a() {
        return this.f31013b;
    }

    public void c() {
        this.f31014c.p(SpanStatus.CANCELLED);
    }

    public /* bridge */ /* synthetic */ boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            MotionEvent a10 = this.f31017f.a(motionEvent);
            try {
                b(a10);
            } catch (Throwable th2) {
                a10.recycle();
                throw th2;
            }
            a10.recycle();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return super.dispatchTrackballEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void onActionModeFinished(ActionMode actionMode) {
        super.onActionModeFinished(actionMode);
    }

    public /* bridge */ /* synthetic */ void onActionModeStarted(ActionMode actionMode) {
        super.onActionModeStarted(actionMode);
    }

    public /* bridge */ /* synthetic */ void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public /* bridge */ /* synthetic */ void onContentChanged() {
        super.onContentChanged();
    }

    public /* bridge */ /* synthetic */ boolean onCreatePanelMenu(int i10, Menu menu) {
        return super.onCreatePanelMenu(i10, menu);
    }

    public /* bridge */ /* synthetic */ View onCreatePanelView(int i10) {
        return super.onCreatePanelView(i10);
    }

    public /* bridge */ /* synthetic */ void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public /* bridge */ /* synthetic */ boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return super.onMenuItemSelected(i10, menuItem);
    }

    public /* bridge */ /* synthetic */ boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    public /* bridge */ /* synthetic */ void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    public /* bridge */ /* synthetic */ boolean onPreparePanel(int i10, View view, Menu menu) {
        return super.onPreparePanel(i10, view, menu);
    }

    public /* bridge */ /* synthetic */ boolean onSearchRequested() {
        return super.onSearchRequested();
    }

    public /* bridge */ /* synthetic */ void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        super.onWindowAttributesChanged(layoutParams);
    }

    public /* bridge */ /* synthetic */ void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    public /* bridge */ /* synthetic */ ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return super.onWindowStartingActionMode(callback);
    }

    h(Window.Callback callback, GestureDetectorCompat gestureDetectorCompat, g gVar, SentryOptions sentryOptions, b bVar) {
        super(callback);
        this.f31013b = callback;
        this.f31014c = gVar;
        this.f31016e = sentryOptions;
        this.f31015d = gestureDetectorCompat;
        this.f31017f = bVar;
    }

    @SuppressLint({"NewApi"})
    public /* bridge */ /* synthetic */ boolean onSearchRequested(SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    @SuppressLint({"NewApi"})
    public /* bridge */ /* synthetic */ ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return super.onWindowStartingActionMode(callback, i10);
    }
}
