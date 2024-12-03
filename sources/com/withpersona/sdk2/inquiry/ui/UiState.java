package com.withpersona.sdk2.inquiry.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class UiState implements Parcelable {

    public static final class Submitting extends UiState {
        public static final Parcelable.Creator<Submitting> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final List<UiComponent> f29330a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, ComponentParam> f29331b;

        /* renamed from: c  reason: collision with root package name */
        private final List<UiTransitionErrorResponse.UiComponentError> f29332c;

        /* renamed from: d  reason: collision with root package name */
        private final String f29333d;

        /* renamed from: e  reason: collision with root package name */
        private final UiComponent f29334e;

        /* renamed from: f  reason: collision with root package name */
        private final StepStyles$UiStepStyle f29335f;

        public static final class a implements Parcelable.Creator<Submitting> {
            /* renamed from: a */
            public final Submitting createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(Submitting.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    linkedHashMap.put(parcel.readString(), parcel.readParcelable(Submitting.class.getClassLoader()));
                }
                int readInt3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt3);
                for (int i12 = 0; i12 != readInt3; i12++) {
                    arrayList2.add(parcel.readParcelable(Submitting.class.getClassLoader()));
                }
                return new Submitting(arrayList, linkedHashMap, arrayList2, parcel.readString(), (UiComponent) parcel.readParcelable(Submitting.class.getClassLoader()), (StepStyles$UiStepStyle) parcel.readParcelable(Submitting.class.getClassLoader()));
            }

            /* renamed from: b */
            public final Submitting[] newArray(int i10) {
                return new Submitting[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Submitting(List<? extends UiComponent> list, Map<String, ? extends ComponentParam> map, List<? extends UiTransitionErrorResponse.UiComponentError> list2, String str, UiComponent uiComponent, StepStyles$UiStepStyle stepStyles$UiStepStyle) {
            super((DefaultConstructorMarker) null);
            j.g(list, "components");
            j.g(map, "componentParams");
            j.g(list2, "componentErrors");
            j.g(str, "stepName");
            j.g(uiComponent, "triggeringComponent");
            this.f29330a = list;
            this.f29331b = map;
            this.f29332c = list2;
            this.f29333d = str;
            this.f29334e = uiComponent;
            this.f29335f = stepStyles$UiStepStyle;
        }

        public final List<UiTransitionErrorResponse.UiComponentError> a() {
            return this.f29332c;
        }

        public final StepStyles$UiStepStyle b() {
            return this.f29335f;
        }

        public final Map<String, ComponentParam> c() {
            return this.f29331b;
        }

        public final String d() {
            return this.f29333d;
        }

        public int describeContents() {
            return 0;
        }

        public final UiComponent e() {
            return this.f29334e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Submitting)) {
                return false;
            }
            Submitting submitting = (Submitting) obj;
            return j.b(this.f29330a, submitting.f29330a) && j.b(this.f29331b, submitting.f29331b) && j.b(this.f29332c, submitting.f29332c) && j.b(this.f29333d, submitting.f29333d) && j.b(this.f29334e, submitting.f29334e) && j.b(this.f29335f, submitting.f29335f);
        }

        public final List<UiComponent> getComponents() {
            return this.f29330a;
        }

        public int hashCode() {
            int hashCode = ((((((((this.f29330a.hashCode() * 31) + this.f29331b.hashCode()) * 31) + this.f29332c.hashCode()) * 31) + this.f29333d.hashCode()) * 31) + this.f29334e.hashCode()) * 31;
            StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f29335f;
            return hashCode + (stepStyles$UiStepStyle == null ? 0 : stepStyles$UiStepStyle.hashCode());
        }

        public String toString() {
            return "Submitting(components=" + this.f29330a + ", componentParams=" + this.f29331b + ", componentErrors=" + this.f29332c + ", stepName=" + this.f29333d + ", triggeringComponent=" + this.f29334e + ", styles=" + this.f29335f + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<UiComponent> list = this.f29330a;
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            Map<String, ComponentParam> map = this.f29331b;
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeParcelable((Parcelable) next.getValue(), i10);
            }
            List<UiTransitionErrorResponse.UiComponentError> list2 = this.f29332c;
            parcel.writeInt(list2.size());
            for (UiTransitionErrorResponse.UiComponentError writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeString(this.f29333d);
            parcel.writeParcelable(this.f29334e, i10);
            parcel.writeParcelable(this.f29335f, i10);
        }
    }

    private UiState() {
    }

    public /* synthetic */ UiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final class Displaying extends UiState {
        public static final Parcelable.Creator<Displaying> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final List<UiComponent> f29325a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29326b;

        /* renamed from: c  reason: collision with root package name */
        private final List<UiTransitionErrorResponse.UiComponentError> f29327c;

        /* renamed from: d  reason: collision with root package name */
        private final StepStyles$UiStepStyle f29328d;

        /* renamed from: e  reason: collision with root package name */
        private final String f29329e;

        public static final class a implements Parcelable.Creator<Displaying> {
            /* renamed from: a */
            public final Displaying createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(Displaying.class.getClassLoader()));
                }
                String readString = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(Displaying.class.getClassLoader()));
                }
                return new Displaying(arrayList, readString, arrayList2, (StepStyles$UiStepStyle) parcel.readParcelable(Displaying.class.getClassLoader()), parcel.readString());
            }

            /* renamed from: b */
            public final Displaying[] newArray(int i10) {
                return new Displaying[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Displaying(List list, String str, List list2, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, str, (i10 & 4) != 0 ? q.j() : list2, stepStyles$UiStepStyle, (i10 & 16) != 0 ? null : str2);
        }

        public static /* synthetic */ Displaying c(Displaying displaying, List<UiComponent> list, String str, List<UiTransitionErrorResponse.UiComponentError> list2, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = displaying.f29325a;
            }
            if ((i10 & 2) != 0) {
                str = displaying.f29326b;
            }
            String str3 = str;
            if ((i10 & 4) != 0) {
                list2 = displaying.f29327c;
            }
            List<UiTransitionErrorResponse.UiComponentError> list3 = list2;
            if ((i10 & 8) != 0) {
                stepStyles$UiStepStyle = displaying.f29328d;
            }
            StepStyles$UiStepStyle stepStyles$UiStepStyle2 = stepStyles$UiStepStyle;
            if ((i10 & 16) != 0) {
                str2 = displaying.f29329e;
            }
            return displaying.a(list, str3, list3, stepStyles$UiStepStyle2, str2);
        }

        public final Displaying a(List<? extends UiComponent> list, String str, List<? extends UiTransitionErrorResponse.UiComponentError> list2, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str2) {
            j.g(list, "components");
            j.g(str, "stepName");
            j.g(list2, "componentErrors");
            return new Displaying(list, str, list2, stepStyles$UiStepStyle, str2);
        }

        public final StepStyles$UiStepStyle b() {
            return this.f29328d;
        }

        public final List<UiTransitionErrorResponse.UiComponentError> d() {
            return this.f29327c;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f29326b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Displaying)) {
                return false;
            }
            Displaying displaying = (Displaying) obj;
            return j.b(this.f29325a, displaying.f29325a) && j.b(this.f29326b, displaying.f29326b) && j.b(this.f29327c, displaying.f29327c) && j.b(this.f29328d, displaying.f29328d) && j.b(this.f29329e, displaying.f29329e);
        }

        public final List<UiComponent> getComponents() {
            return this.f29325a;
        }

        public final String getError() {
            return this.f29329e;
        }

        public int hashCode() {
            int hashCode = ((((this.f29325a.hashCode() * 31) + this.f29326b.hashCode()) * 31) + this.f29327c.hashCode()) * 31;
            StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f29328d;
            int i10 = 0;
            int hashCode2 = (hashCode + (stepStyles$UiStepStyle == null ? 0 : stepStyles$UiStepStyle.hashCode())) * 31;
            String str = this.f29329e;
            if (str != null) {
                i10 = str.hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "Displaying(components=" + this.f29325a + ", stepName=" + this.f29326b + ", componentErrors=" + this.f29327c + ", styles=" + this.f29328d + ", error=" + this.f29329e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<UiComponent> list = this.f29325a;
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            parcel.writeString(this.f29326b);
            List<UiTransitionErrorResponse.UiComponentError> list2 = this.f29327c;
            parcel.writeInt(list2.size());
            for (UiTransitionErrorResponse.UiComponentError writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeParcelable(this.f29328d, i10);
            parcel.writeString(this.f29329e);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Displaying(List<? extends UiComponent> list, String str, List<? extends UiTransitionErrorResponse.UiComponentError> list2, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str2) {
            super((DefaultConstructorMarker) null);
            j.g(list, "components");
            j.g(str, "stepName");
            j.g(list2, "componentErrors");
            this.f29325a = list;
            this.f29326b = str;
            this.f29327c = list2;
            this.f29328d = stepStyles$UiStepStyle;
            this.f29329e = str2;
        }
    }
}
