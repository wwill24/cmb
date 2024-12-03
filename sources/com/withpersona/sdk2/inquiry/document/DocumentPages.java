package com.withpersona.sdk2.inquiry.document;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;

public final class DocumentPages implements Parcelable {
    public static final Parcelable.Creator<DocumentPages> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DocumentStartPage f24992a;

    /* renamed from: b  reason: collision with root package name */
    private final UploadOptionsDialog f24993b;

    public static final class a implements Parcelable.Creator<DocumentPages> {
        /* renamed from: a */
        public final DocumentPages createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new DocumentPages(DocumentStartPage.CREATOR.createFromParcel(parcel), UploadOptionsDialog.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final DocumentPages[] newArray(int i10) {
            return new DocumentPages[i10];
        }
    }

    public DocumentPages(DocumentStartPage documentStartPage, UploadOptionsDialog uploadOptionsDialog) {
        j.g(documentStartPage, "documentStartPage");
        j.g(uploadOptionsDialog, "uploadOptionsDialog");
        this.f24992a = documentStartPage;
        this.f24993b = uploadOptionsDialog;
    }

    public final DocumentStartPage a() {
        return this.f24992a;
    }

    public final UploadOptionsDialog c() {
        return this.f24993b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        this.f24992a.writeToParcel(parcel, i10);
        this.f24993b.writeToParcel(parcel, i10);
    }
}
