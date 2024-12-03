package io.sentry.cache;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class c implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.endsWith(".envelope");
    }
}
