package com.squareup.workflow1.ui;

import android.content.res.Resources;
import android.view.View;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import ci.b;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.v1;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\f\u0010\r\u001a\u00020\f*\u00020\u0000H\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroid/view/View;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/k0;", "Lkotlin/coroutines/c;", "", "", "block", "Lkotlinx/coroutines/s1;", "b", "(Landroid/view/View;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/s1;", "Lcom/squareup/workflow1/ui/AttachedScope;", "a", "wf1-core-android"}, k = 2, mv = {1, 6, 0})
public final class ViewLaunchWhenAttachedKt {
    private static final AttachedScope a(View view) {
        AttachedScope attachedScope;
        Object tag = view.getTag(i.view_attached_coroutine_scope);
        AttachedScope attachedScope2 = null;
        if (tag instanceof AttachedScope) {
            attachedScope = (AttachedScope) tag;
        } else {
            attachedScope = null;
        }
        if (attachedScope != null && l0.i(attachedScope.b())) {
            attachedScope2 = attachedScope;
        }
        if (attachedScope2 != null) {
            return attachedScope2;
        }
        l a10 = b.f19008a.a(view);
        if (a10 != null) {
            g a11 = m.a(a10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(view.getClass().getName() + '@' + view.hashCode());
            if (view.getId() != -1) {
                try {
                    String resourceEntryName = view.getResources().getResourceEntryName(view.getId());
                    sb2.append(SignatureVisitor.SUPER);
                    sb2.append(resourceEntryName);
                } catch (Resources.NotFoundException unused) {
                }
            }
            String sb3 = sb2.toString();
            j.f(sb3, "StringBuilder().apply(builderAction).toString()");
            AttachedScope attachedScope3 = new AttachedScope(l0.j(a11, new j0(sb3)));
            view.setTag(i.view_attached_coroutine_scope, attachedScope3);
            view.addOnAttachStateChangeListener(attachedScope3);
            return attachedScope3;
        }
        throw new IllegalStateException("ViewTreeLifecycleOwner is required by View.ensureAttachedScope".toString());
    }

    public static final s1 b(View view, CoroutineContext coroutineContext, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2) {
        boolean z10;
        j.g(view, "<this>");
        j.g(coroutineContext, IdentityHttpResponse.CONTEXT);
        j.g(function2, BlockContactsIQ.ELEMENT);
        if (coroutineContext.c(s1.f32618v) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            AttachedScope a10 = a(view);
            ViewLaunchWhenAttachedKt$launchWhenAttached$launch$1 viewLaunchWhenAttachedKt$launchWhenAttached$launch$1 = new ViewLaunchWhenAttachedKt$launchWhenAttached$launch$1(a10, coroutineContext, function2);
            if (view.isAttachedToWindow()) {
                viewLaunchWhenAttachedKt$launchWhenAttached$launch$1.invoke();
            } else {
                a10.c(viewLaunchWhenAttachedKt$launchWhenAttached$launch$1);
            }
            return v1.k(a10.b().G());
        }
        throw new IllegalArgumentException("Expected custom CoroutineContext to not contain a Job.".toString());
    }

    public static /* synthetic */ s1 c(View view, CoroutineContext coroutineContext, Function2 function2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f32070a;
        }
        return b(view, coroutineContext, function2);
    }
}
