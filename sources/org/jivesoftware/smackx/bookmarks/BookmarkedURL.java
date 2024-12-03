package org.jivesoftware.smackx.bookmarks;

public class BookmarkedURL implements SharedBookmark {
    private final String URL;
    private boolean isRss;
    private boolean isShared;
    private String name;

    protected BookmarkedURL(String str) {
        this.URL = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BookmarkedURL)) {
            return false;
        }
        return ((BookmarkedURL) obj).getURL().equalsIgnoreCase(this.URL);
    }

    public String getName() {
        return this.name;
    }

    public String getURL() {
        return this.URL;
    }

    public int hashCode() {
        return getURL().hashCode();
    }

    public boolean isRss() {
        return this.isRss;
    }

    public boolean isShared() {
        return this.isShared;
    }

    /* access modifiers changed from: protected */
    public void setName(String str) {
        this.name = str;
    }

    /* access modifiers changed from: protected */
    public void setRss(boolean z10) {
        this.isRss = z10;
    }

    /* access modifiers changed from: protected */
    public void setShared(boolean z10) {
        this.isShared = z10;
    }

    protected BookmarkedURL(String str, String str2, boolean z10) {
        this.URL = str;
        this.name = str2;
        this.isRss = z10;
    }
}
