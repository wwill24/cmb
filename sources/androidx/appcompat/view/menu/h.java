package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.m;
import d.g;
import net.bytebuddy.jar.asm.Opcodes;

class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: a  reason: collision with root package name */
    private g f850a;

    /* renamed from: b  reason: collision with root package name */
    private b f851b;

    /* renamed from: c  reason: collision with root package name */
    e f852c;

    /* renamed from: d  reason: collision with root package name */
    private m.a f853d;

    public h(g gVar) {
        this.f850a = gVar;
    }

    public void a() {
        b bVar = this.f851b;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void b(IBinder iBinder) {
        g gVar = this.f850a;
        b.a aVar = new b.a(gVar.u());
        e eVar = new e(aVar.b(), g.abc_list_menu_item_layout);
        this.f852c = eVar;
        eVar.e(this);
        this.f850a.b(this.f852c);
        aVar.c(this.f852c.a(), this);
        View y10 = gVar.y();
        if (y10 != null) {
            aVar.d(y10);
        } else {
            aVar.e(gVar.w()).k(gVar.x());
        }
        aVar.h(this);
        b a10 = aVar.a();
        this.f851b = a10;
        a10.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f851b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= Opcodes.ACC_DEPRECATED;
        this.f851b.show();
    }

    public void c(@NonNull g gVar, boolean z10) {
        if (z10 || gVar == this.f850a) {
            a();
        }
        m.a aVar = this.f853d;
        if (aVar != null) {
            aVar.c(gVar, z10);
        }
    }

    public boolean d(@NonNull g gVar) {
        m.a aVar = this.f853d;
        if (aVar != null) {
            return aVar.d(gVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f850a.L((i) this.f852c.a().getItem(i10), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f852c.c(this.f850a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f851b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f851b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f850a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f850a.performShortcut(i10, keyEvent, 0);
    }
}
