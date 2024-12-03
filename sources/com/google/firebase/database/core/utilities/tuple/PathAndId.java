package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.core.Path;

public class PathAndId {

    /* renamed from: id  reason: collision with root package name */
    private long f21078id;
    private Path path;

    public PathAndId(Path path2, long j10) {
        this.path = path2;
        this.f21078id = j10;
    }

    public long getId() {
        return this.f21078id;
    }

    public Path getPath() {
        return this.path;
    }
}
