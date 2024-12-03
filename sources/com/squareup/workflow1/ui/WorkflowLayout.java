package com.squareup.workflow1.ui;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.mparticle.identity.IdentityHttpResponse;
import gk.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.s1;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J0\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004J$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a¨\u0006#"}, d2 = {"Lcom/squareup/workflow1/ui/WorkflowLayout;", "Landroid/widget/FrameLayout;", "", "newRendering", "Lcom/squareup/workflow1/ui/p;", "environment", "", "d", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlinx/coroutines/flow/b;", "renderings", "Landroidx/lifecycle/Lifecycle$State;", "repeatOnLifecycle", "a", "Lcom/squareup/workflow1/ui/s;", "registry", "b", "Landroid/os/Parcelable;", "onSaveInstanceState", "state", "onRestoreInstanceState", "Lcom/squareup/workflow1/ui/WorkflowViewStub;", "Lcom/squareup/workflow1/ui/WorkflowViewStub;", "showing", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "restoredChildState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "SavedState", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class WorkflowLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final WorkflowViewStub f23183a;

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<Parcelable> f23184b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkflowLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    public static /* synthetic */ void c(WorkflowLayout workflowLayout, Lifecycle lifecycle, b bVar, Lifecycle.State state, p pVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            state = Lifecycle.State.STARTED;
        }
        if ((i10 & 8) != 0) {
            pVar = new p((Map) null, 1, (DefaultConstructorMarker) null);
        }
        workflowLayout.a(lifecycle, bVar, state, pVar);
    }

    public final void a(Lifecycle lifecycle, b<? extends Object> bVar, Lifecycle.State state, p pVar) {
        j.g(lifecycle, "lifecycle");
        j.g(bVar, "renderings");
        j.g(state, "repeatOnLifecycle");
        j.g(pVar, "environment");
        s1 unused = j.d(androidx.lifecycle.j.a(lifecycle), (CoroutineContext) null, (CoroutineStart) null, new WorkflowLayout$start$1(lifecycle, state, bVar, this, pVar, (c<? super WorkflowLayout$start$1>) null), 3, (Object) null);
    }

    public final void b(Lifecycle lifecycle, b<? extends Object> bVar, s sVar) {
        j.g(lifecycle, "lifecycle");
        j.g(bVar, "renderings");
        j.g(sVar, "registry");
        c(this, lifecycle, bVar, (Lifecycle.State) null, new p(g0.f(h.a(s.f23293a, sVar))), 4, (Object) null);
    }

    public final void d(Object obj, p pVar) {
        j.g(obj, "newRendering");
        j.g(pVar, "environment");
        this.f23183a.c(obj, pVar);
        SparseArray<Parcelable> sparseArray = this.f23184b;
        if (sparseArray != null) {
            this.f23184b = null;
            this.f23183a.getActual().restoreHierarchyState(sparseArray);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState;
        Unit unit = null;
        if (parcelable instanceof SavedState) {
            savedState = (SavedState) parcelable;
        } else {
            savedState = null;
        }
        if (savedState != null) {
            this.f23184b = savedState.a();
            super.onRestoreInstanceState(((SavedState) parcelable).getSuperState());
            unit = Unit.f32013a;
        }
        if (unit == null) {
            super.onRestoreInstanceState(super.onSaveInstanceState());
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        j.d(onSaveInstanceState);
        SparseArray sparseArray = new SparseArray();
        this.f23183a.getActual().saveHierarchyState(sparseArray);
        return new SavedState(onSaveInstanceState, sparseArray);
    }

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\nB!\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/squareup/workflow1/ui/WorkflowLayout$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "out", "", "flags", "", "writeToParcel", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "a", "Landroid/util/SparseArray;", "()Landroid/util/SparseArray;", "childState", "superState", "<init>", "(Landroid/os/Parcelable;Landroid/util/SparseArray;)V", "source", "(Landroid/os/Parcel;)V", "CREATOR", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    private static final class SavedState extends View.BaseSavedState {
        public static final a CREATOR = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Parcelable> f23185a;

        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/WorkflowLayout$SavedState$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/WorkflowLayout$SavedState;", "Landroid/os/Parcel;", "source", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/WorkflowLayout$SavedState;", "<init>", "()V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
        public static final class a implements Parcelable.Creator<SavedState> {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                j.g(parcel, "source");
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable, SparseArray<Parcelable> sparseArray) {
            super(parcelable);
            j.g(sparseArray, "childState");
            this.f23185a = sparseArray;
        }

        public final SparseArray<Parcelable> a() {
            return this.f23185a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            super.writeToParcel(parcel, i10);
            parcel.writeSparseArray(this.f23185a);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            j.g(parcel, "source");
            SparseArray<Parcelable> readSparseArray = parcel.readSparseArray(SavedState.class.getClassLoader());
            j.d(readSparseArray);
            j.f(readSparseArray, "source.readSparseArray(S…class.java.classLoader)!!");
            this.f23185a = readSparseArray;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkflowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (getId() == -1) {
            setId(i.workflow_layout);
        }
        WorkflowViewStub workflowViewStub = new WorkflowViewStub(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        workflowViewStub.setUpdatesVisibility(false);
        addView(workflowViewStub, new ViewGroup.LayoutParams(-1, -1));
        this.f23183a = workflowViewStub;
    }
}
