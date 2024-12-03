package gm;

import java.io.File;
import java.io.FileFilter;
import org.jivesoftware.smack.roster.rosterstore.DirectoryRosterStore;

public final /* synthetic */ class a implements FileFilter {
    public final boolean accept(File file) {
        return DirectoryRosterStore.rosterDirFilter(file);
    }
}
