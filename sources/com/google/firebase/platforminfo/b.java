package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;

public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f21185a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LibraryVersionComponent.VersionExtractor f21186b;

    public /* synthetic */ b(String str, LibraryVersionComponent.VersionExtractor versionExtractor) {
        this.f21185a = str;
        this.f21186b = versionExtractor;
    }

    public final Object create(ComponentContainer componentContainer) {
        return LibraryVersion.create(this.f21185a, this.f21186b.extract((Context) componentContainer.get(Context.class)));
    }
}
