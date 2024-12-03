package com.withpersona.sdk2.inquiry.document.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.shared.data_collection.StepData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentStepData implements StepData {
    public static final Parcelable.Creator<DocumentStepData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25241a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DocumentFile> f25242b;

    public static final class a implements Parcelable.Creator<DocumentStepData> {
        /* renamed from: a */
        public final DocumentStepData createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(parcel.readParcelable(DocumentStepData.class.getClassLoader()));
            }
            return new DocumentStepData(readString, arrayList);
        }

        /* renamed from: b */
        public final DocumentStepData[] newArray(int i10) {
            return new DocumentStepData[i10];
        }
    }

    public DocumentStepData(String str, List<? extends DocumentFile> list) {
        j.g(str, "stepName");
        j.g(list, "documents");
        this.f25241a = str;
        this.f25242b = list;
    }

    public final List<DocumentFile> a() {
        return this.f25242b;
    }

    public String c() {
        return this.f25241a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentStepData)) {
            return false;
        }
        DocumentStepData documentStepData = (DocumentStepData) obj;
        return j.b(c(), documentStepData.c()) && j.b(this.f25242b, documentStepData.f25242b);
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f25242b.hashCode();
    }

    public String toString() {
        return "DocumentStepData(stepName=" + c() + ", documents=" + this.f25242b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25241a);
        List<DocumentFile> list = this.f25242b;
        parcel.writeInt(list.size());
        for (DocumentFile writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i10);
        }
    }
}
