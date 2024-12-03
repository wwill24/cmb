package com.squareup.workflow1.ui.modal;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import ci.b;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.ui.WorkflowViewState;
import com.squareup.workflow1.ui.WorkflowViewStub;
import com.squareup.workflow1.ui.androidx.WorkflowLifecycleOwner;
import com.squareup.workflow1.ui.androidx.WorkflowSavedStateRegistryAggregator;
import com.squareup.workflow1.ui.d;
import com.squareup.workflow1.ui.e;
import com.squareup.workflow1.ui.p;
import com.squareup.workflow1.ui.v;
import gk.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0003\u0018/0B1\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*\u0012\b\b\u0002\u0010,\u001a\u00020*¢\u0006\u0004\b-\u0010.J\"\u0010\t\u001a\u00020\b2\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J%\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006H$¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\fH$J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\bH\u0014J\b\u0010\u0016\u001a\u00020\bH\u0014R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$¨\u00061"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalContainer;", "", "ModalRenderingT", "Landroid/widget/FrameLayout;", "Lcom/squareup/workflow1/ui/modal/d;", "newScreen", "Lcom/squareup/workflow1/ui/p;", "viewEnvironment", "", "c", "initialModalRendering", "initialViewEnvironment", "Lcom/squareup/workflow1/ui/modal/ModalContainer$a;", "b", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;)Lcom/squareup/workflow1/ui/modal/ModalContainer$a;", "dialogRef", "d", "Landroid/os/Parcelable;", "onSaveInstanceState", "state", "onRestoreInstanceState", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/squareup/workflow1/ui/WorkflowViewStub;", "a", "Lcom/squareup/workflow1/ui/WorkflowViewStub;", "baseViewStub", "", "Ljava/util/List;", "dialogs", "Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner;", "Lgk/f;", "getParentLifecycleOwner", "()Lcom/squareup/workflow1/ui/androidx/WorkflowLifecycleOwner;", "parentLifecycleOwner", "Lcom/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator;", "Lcom/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator;", "stateRegistryAggregator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "KeyAndBundle", "SavedState", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public abstract class ModalContainer<ModalRenderingT> extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final WorkflowViewStub f23262a;

    /* renamed from: b  reason: collision with root package name */
    private List<a<ModalRenderingT>> f23263b = q.j();

    /* renamed from: c  reason: collision with root package name */
    private final f f23264c = b.a(LazyThreadSafetyMode.NONE, new ModalContainer$parentLifecycleOwner$2(this));

    /* renamed from: d  reason: collision with root package name */
    private final WorkflowSavedStateRegistryAggregator f23265d = new WorkflowSavedStateRegistryAggregator();

    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "toString", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "compatibilityKey", "Landroid/os/Bundle;", "b", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "bundle", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;)V", "CREATOR", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    public static final class KeyAndBundle implements Parcelable {
        public static final a CREATOR = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f23266a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f23267b;

        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle;", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
        public static final class a implements Parcelable.Creator<KeyAndBundle> {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: a */
            public KeyAndBundle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                j.d(readString);
                j.f(readString, "parcel.readString()!!");
                Bundle readBundle = parcel.readBundle(KeyAndBundle.class.getClassLoader());
                j.d(readBundle);
                j.f(readBundle, "parcel.readBundle(KeyAnd…class.java.classLoader)!!");
                return new KeyAndBundle(readString, readBundle);
            }

            /* renamed from: b */
            public KeyAndBundle[] newArray(int i10) {
                return new KeyAndBundle[i10];
            }
        }

        public KeyAndBundle(String str, Bundle bundle) {
            j.g(str, "compatibilityKey");
            j.g(bundle, "bundle");
            this.f23266a = str;
            this.f23267b = bundle;
        }

        public final Bundle a() {
            return this.f23267b;
        }

        public final String c() {
            return this.f23266a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof KeyAndBundle)) {
                return false;
            }
            KeyAndBundle keyAndBundle = (KeyAndBundle) obj;
            return j.b(this.f23266a, keyAndBundle.f23266a) && j.b(this.f23267b, keyAndBundle.f23267b);
        }

        public int hashCode() {
            return (this.f23266a.hashCode() * 31) + this.f23267b.hashCode();
        }

        public String toString() {
            return "KeyAndBundle(compatibilityKey=" + this.f23266a + ", bundle=" + this.f23267b + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "parcel");
            parcel.writeString(this.f23266a);
            parcel.writeBundle(this.f23267b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalContainer(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        j.g(context, IdentityHttpResponse.CONTEXT);
        WorkflowViewStub workflowViewStub = new WorkflowViewStub(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        addView(workflowViewStub, new ViewGroup.LayoutParams(-1, -1));
        this.f23262a = workflowViewStub;
    }

    /* access modifiers changed from: private */
    public final WorkflowLifecycleOwner getParentLifecycleOwner() {
        return (WorkflowLifecycleOwner) this.f23264c.getValue();
    }

    /* access modifiers changed from: protected */
    public abstract a<ModalRenderingT> b(ModalRenderingT modalrenderingt, p pVar);

    /* access modifiers changed from: protected */
    public final void c(d<?, ? extends ModalRenderingT> dVar, p pVar) {
        a aVar;
        j.g(dVar, "newScreen");
        j.g(pVar, "viewEnvironment");
        this.f23262a.c(dVar.b(), pVar);
        ArrayList<a> arrayList = new ArrayList<>();
        int i10 = 0;
        for (Object next : dVar.a()) {
            int i11 = i10 + 1;
            if (i10 >= this.f23263b.size() || !e.a(this.f23263b.get(i10).f(), next)) {
                a b10 = b(next, pVar);
                b10.k(d.f23236a.a(next, String.valueOf(i10)));
                View a10 = e.b(b10.d());
                if (a10 != null) {
                    WorkflowLifecycleOwner.f23206o.d(a10, new ModalContainer$update$2$1$1(this));
                    this.f23265d.h(a10, b10.g());
                    a10.addOnAttachStateChangeListener(new ModalContainer$update$2$1$2(b10, this));
                }
                b10.d().show();
                aVar = b10;
            } else {
                aVar = a.b(this.f23263b.get(i10), next, pVar, (Dialog) null, (Object) null, 12, (Object) null);
                d(aVar);
            }
            arrayList.add(aVar);
            i10 = i11;
        }
        for (a c10 : CollectionsKt___CollectionsKt.e0(this.f23263b, arrayList)) {
            c10.c();
        }
        WorkflowSavedStateRegistryAggregator workflowSavedStateRegistryAggregator = this.f23265d;
        ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
        for (a g10 : arrayList) {
            arrayList2.add(g10.g());
        }
        workflowSavedStateRegistryAggregator.j(arrayList2);
        this.f23263b = arrayList;
    }

    /* access modifiers changed from: protected */
    public abstract void d(a<ModalRenderingT> aVar);

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Object obj;
        super.onAttachedToWindow();
        r1.d c10 = b.f19008a.c(this);
        d.a aVar = d.f23236a;
        WorkflowViewState<?> d10 = v.d(this);
        if (d10 == null) {
            obj = null;
        } else {
            obj = d10.c();
        }
        if (obj == null) {
            obj = null;
        }
        j.d(obj);
        this.f23265d.f(d.a.b(aVar, obj, (String) null, 2, (Object) null), c10);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f23265d.g();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState;
        j.g(parcelable, "state");
        Unit unit = null;
        if (parcelable instanceof SavedState) {
            savedState = (SavedState) parcelable;
        } else {
            savedState = null;
        }
        if (savedState != null) {
            if (savedState.a().size() == this.f23263b.size()) {
                List<KeyAndBundle> a10 = savedState.a();
                List<a<ModalRenderingT>> list = this.f23263b;
                Iterator<T> it = a10.iterator();
                Iterator<T> it2 = list.iterator();
                ArrayList arrayList = new ArrayList(Math.min(r.t(a10, 10), r.t(list, 10)));
                while (it.hasNext() && it2.hasNext()) {
                    ((a) it2.next()).i((KeyAndBundle) it.next());
                    arrayList.add(Unit.f32013a);
                }
            }
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
        List<a<ModalRenderingT>> list = this.f23263b;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (a j10 : list) {
            arrayList.add(j10.j());
        }
        return new SavedState(onSaveInstanceState, arrayList);
    }

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\nB!\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalContainer$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "out", "", "flags", "", "writeToParcel", "", "Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle;", "a", "Ljava/util/List;", "()Ljava/util/List;", "dialogBundles", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;Ljava/util/List;)V", "source", "(Landroid/os/Parcel;)V", "CREATOR", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    private static final class SavedState extends View.BaseSavedState {
        public static final a CREATOR = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final List<KeyAndBundle> f23268a;

        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalContainer$SavedState$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/modal/ModalContainer$SavedState;", "Landroid/os/Parcel;", "source", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/modal/ModalContainer$SavedState;", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
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
        public SavedState(Parcelable parcelable, List<KeyAndBundle> list) {
            super(parcelable);
            j.g(list, "dialogBundles");
            this.f23268a = list;
        }

        public final List<KeyAndBundle> a() {
            return this.f23268a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            super.writeToParcel(parcel, i10);
            parcel.writeTypedList(this.f23268a);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            j.g(parcel, "source");
            ArrayList arrayList = new ArrayList();
            parcel.readTypedList(arrayList, KeyAndBundle.CREATOR);
            this.f23268a = arrayList;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0005\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b+\u0010,J=\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0017\u0010\u0003\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b#\u0010\u001bR\"\u0010*\u001a\u00020$8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b#\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/squareup/workflow1/ui/modal/ModalContainer$a;", "", "ModalRenderingT", "modalRendering", "Lcom/squareup/workflow1/ui/p;", "viewEnvironment", "Landroid/app/Dialog;", "dialog", "extra", "a", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Landroid/app/Dialog;Ljava/lang/Object;)Lcom/squareup/workflow1/ui/modal/ModalContainer$a;", "Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle;", "j", "()Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle;", "keyAndBundle", "", "i", "(Lcom/squareup/workflow1/ui/modal/ModalContainer$KeyAndBundle;)V", "c", "()V", "other", "", "equals", "", "hashCode", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "b", "Lcom/squareup/workflow1/ui/p;", "h", "()Lcom/squareup/workflow1/ui/p;", "Landroid/app/Dialog;", "d", "()Landroid/app/Dialog;", "e", "", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "savedStateRegistryKey", "<init>", "(Ljava/lang/Object;Lcom/squareup/workflow1/ui/p;Landroid/app/Dialog;Ljava/lang/Object;)V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    protected static final class a<ModalRenderingT> {

        /* renamed from: a  reason: collision with root package name */
        private final ModalRenderingT f23269a;

        /* renamed from: b  reason: collision with root package name */
        private final p f23270b;

        /* renamed from: c  reason: collision with root package name */
        private final Dialog f23271c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f23272d;

        /* renamed from: e  reason: collision with root package name */
        public String f23273e;

        public a(ModalRenderingT modalrenderingt, p pVar, Dialog dialog, Object obj) {
            j.g(modalrenderingt, "modalRendering");
            j.g(pVar, "viewEnvironment");
            j.g(dialog, "dialog");
            this.f23269a = modalrenderingt;
            this.f23270b = pVar;
            this.f23271c = dialog;
            this.f23272d = obj;
        }

        public static /* synthetic */ a b(a aVar, ModalRenderingT modalrenderingt, p pVar, Dialog dialog, Object obj, int i10, Object obj2) {
            if ((i10 & 1) != 0) {
                modalrenderingt = aVar.f23269a;
            }
            if ((i10 & 2) != 0) {
                pVar = aVar.f23270b;
            }
            if ((i10 & 4) != 0) {
                dialog = aVar.f23271c;
            }
            if ((i10 & 8) != 0) {
                obj = aVar.f23272d;
            }
            return aVar.a(modalrenderingt, pVar, dialog, obj);
        }

        public final a<ModalRenderingT> a(ModalRenderingT modalrenderingt, p pVar, Dialog dialog, Object obj) {
            j.g(modalrenderingt, "modalRendering");
            j.g(pVar, "viewEnvironment");
            j.g(dialog, "dialog");
            a<ModalRenderingT> aVar = new a<>(modalrenderingt, pVar, dialog, obj);
            aVar.k(g());
            return aVar;
        }

        public final void c() {
            WorkflowLifecycleOwner c10;
            View a10 = e.b(this.f23271c);
            if (!(a10 == null || (c10 = WorkflowLifecycleOwner.f23206o.c(a10)) == null)) {
                c10.P();
            }
            this.f23271c.dismiss();
        }

        public final Dialog d() {
            return this.f23271c;
        }

        public final Object e() {
            return this.f23272d;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            Class<a> cls2 = a.class;
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            if (!j.b(cls2, cls)) {
                return false;
            }
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.squareup.workflow1.ui.modal.ModalContainer.DialogRef<*>");
            } else if (!j.b(this.f23271c, ((a) obj).f23271c)) {
                return false;
            } else {
                return true;
            }
        }

        public final ModalRenderingT f() {
            return this.f23269a;
        }

        public final String g() {
            String str = this.f23273e;
            if (str != null) {
                return str;
            }
            j.y("savedStateRegistryKey");
            return null;
        }

        public final p h() {
            return this.f23270b;
        }

        public int hashCode() {
            return this.f23271c.hashCode();
        }

        public final void i(KeyAndBundle keyAndBundle) {
            j.g(keyAndBundle, "keyAndBundle");
            if (j.b(d.a.b(d.f23236a, this.f23269a, (String) null, 2, (Object) null), keyAndBundle.c())) {
                Window window = this.f23271c.getWindow();
                j.d(window);
                window.restoreHierarchyState(keyAndBundle.a());
            }
        }

        public final KeyAndBundle j() {
            Window window = this.f23271c.getWindow();
            j.d(window);
            Bundle saveHierarchyState = window.saveHierarchyState();
            String b10 = d.a.b(d.f23236a, this.f23269a, (String) null, 2, (Object) null);
            j.f(saveHierarchyState, "saved");
            return new KeyAndBundle(b10, saveHierarchyState);
        }

        public final void k(String str) {
            j.g(str, "<set-?>");
            this.f23273e = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(Object obj, p pVar, Dialog dialog, Object obj2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, pVar, dialog, (i10 & 8) != 0 ? null : obj2);
        }
    }
}
