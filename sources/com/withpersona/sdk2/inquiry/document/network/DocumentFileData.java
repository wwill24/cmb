package com.withpersona.sdk2.inquiry.document.network;

import com.leanplum.internal.Constants;
import com.squareup.moshi.i;
import java.util.List;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class DocumentFileData {

    /* renamed from: a  reason: collision with root package name */
    private final String f25198a;

    /* renamed from: b  reason: collision with root package name */
    private final Attributes f25199b;

    @i(generateAdapter = true)
    public static final class Attributes {

        /* renamed from: a  reason: collision with root package name */
        private final List<RemoteDocumentFile> f25200a;

        public Attributes(List<RemoteDocumentFile> list) {
            this.f25200a = list;
        }

        public final List<RemoteDocumentFile> a() {
            return this.f25200a;
        }
    }

    @i(generateAdapter = true)
    public static final class RemoteDocumentFile {

        /* renamed from: a  reason: collision with root package name */
        private final String f25201a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25202b;

        public RemoteDocumentFile(String str, String str2) {
            j.g(str, "url");
            j.g(str2, Constants.Keys.FILENAME);
            this.f25201a = str;
            this.f25202b = str2;
        }

        public final String a() {
            return this.f25202b;
        }

        public final String b() {
            return this.f25201a;
        }
    }

    public DocumentFileData(String str, Attributes attributes) {
        j.g(str, "id");
        this.f25198a = str;
        this.f25199b = attributes;
    }

    public final Attributes a() {
        return this.f25199b;
    }

    public final String b() {
        return this.f25198a;
    }
}
