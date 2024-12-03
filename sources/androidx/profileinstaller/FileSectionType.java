package androidx.profileinstaller;

enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);
    
    private final long mValue;

    private FileSectionType(long j10) {
        this.mValue = j10;
    }

    public long b() {
        return this.mValue;
    }
}
