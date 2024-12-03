package net.bytebuddy;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface NamingStrategy {
    public static final String BYTE_BUDDY_RENAME_PACKAGE = "net.bytebuddy.renamed";
    public static final String NO_PREFIX = "";

    public static abstract class AbstractBase implements NamingStrategy {
        /* access modifiers changed from: protected */
        public abstract String name(TypeDescription typeDescription);

        public String rebase(TypeDescription typeDescription) {
            return typeDescription.getName();
        }

        public String redefine(TypeDescription typeDescription) {
            return typeDescription.getName();
        }

        public String subclass(TypeDescription.Generic generic) {
            return name(generic.asErasure());
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class PrefixingRandom extends AbstractBase {
        private final String prefix;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
        private final RandomString randomString = new RandomString();

        public PrefixingRandom(String str) {
            this.prefix = str;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.prefix.equals(((PrefixingRandom) obj).prefix);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.prefix.hashCode();
        }

        /* access modifiers changed from: protected */
        public String name(TypeDescription typeDescription) {
            return this.prefix + "." + typeDescription.getName() + "$" + this.randomString.nextString();
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Suffixing extends AbstractBase {
        private static final String JAVA_PACKAGE = "java.";
        private final BaseNameResolver baseNameResolver;
        private final String javaLangPackagePrefix;
        private final String suffix;

        public interface BaseNameResolver {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFixedValue implements BaseNameResolver {
                private final String name;

                public ForFixedValue(String str) {
                    this.name = str;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((ForFixedValue) obj).name);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.name.hashCode();
                }

                public String resolve(TypeDescription typeDescription) {
                    return this.name;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForGivenType implements BaseNameResolver {
                private final TypeDescription typeDescription;

                public ForGivenType(TypeDescription typeDescription2) {
                    this.typeDescription = typeDescription2;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForGivenType) obj).typeDescription);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                }

                public String resolve(TypeDescription typeDescription2) {
                    return this.typeDescription.getName();
                }
            }

            public enum ForUnnamedType implements BaseNameResolver {
                INSTANCE;

                public String resolve(TypeDescription typeDescription) {
                    return typeDescription.getName();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class WithCallerSuffix implements BaseNameResolver {
                private final BaseNameResolver delegate;

                public WithCallerSuffix(BaseNameResolver baseNameResolver) {
                    this.delegate = baseNameResolver;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.delegate.equals(((WithCallerSuffix) obj).delegate);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.delegate.hashCode();
                }

                public String resolve(TypeDescription typeDescription) {
                    String str;
                    Class<ByteBuddy> cls = ByteBuddy.class;
                    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    int length = stackTrace.length;
                    int i10 = 0;
                    boolean z10 = false;
                    while (true) {
                        if (i10 >= length) {
                            str = null;
                            break;
                        }
                        StackTraceElement stackTraceElement = stackTrace[i10];
                        if (stackTraceElement.getClassName().equals(cls.getName())) {
                            z10 = true;
                        } else if (z10) {
                            str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
                            break;
                        }
                        i10++;
                    }
                    if (str != null) {
                        return this.delegate.resolve(typeDescription) + "$" + str.replace('.', '$');
                    }
                    throw new IllegalStateException("Base name resolver not invoked via " + cls);
                }
            }

            String resolve(TypeDescription typeDescription);
        }

        public Suffixing(String str) {
            this(str, (BaseNameResolver) BaseNameResolver.ForUnnamedType.INSTANCE);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Suffixing suffixing = (Suffixing) obj;
            return this.suffix.equals(suffixing.suffix) && this.javaLangPackagePrefix.equals(suffixing.javaLangPackagePrefix) && this.baseNameResolver.equals(suffixing.baseNameResolver);
        }

        public int hashCode() {
            return (((((getClass().hashCode() * 31) + this.suffix.hashCode()) * 31) + this.javaLangPackagePrefix.hashCode()) * 31) + this.baseNameResolver.hashCode();
        }

        /* access modifiers changed from: protected */
        public String name(TypeDescription typeDescription) {
            String resolve = this.baseNameResolver.resolve(typeDescription);
            if (resolve.startsWith(JAVA_PACKAGE) && !this.javaLangPackagePrefix.equals("")) {
                resolve = this.javaLangPackagePrefix + "." + resolve;
            }
            return resolve + "$" + this.suffix;
        }

        public Suffixing(String str, String str2) {
            this(str, BaseNameResolver.ForUnnamedType.INSTANCE, str2);
        }

        public Suffixing(String str, BaseNameResolver baseNameResolver2) {
            this(str, baseNameResolver2, NamingStrategy.BYTE_BUDDY_RENAME_PACKAGE);
        }

        public Suffixing(String str, BaseNameResolver baseNameResolver2, String str2) {
            this.suffix = str;
            this.baseNameResolver = baseNameResolver2;
            this.javaLangPackagePrefix = str2;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class SuffixingRandom extends Suffixing {
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
        private final RandomString randomString;

        @Deprecated
        public interface BaseNameResolver extends Suffixing.BaseNameResolver {

            @HashCodeAndEqualsPlugin.Enhance
            @Deprecated
            public static class ForFixedValue extends Suffixing.BaseNameResolver.ForFixedValue implements BaseNameResolver {
                public ForFixedValue(String str) {
                    super(str);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass();
                }

                public int hashCode() {
                    return super.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            @Deprecated
            public static class ForGivenType extends Suffixing.BaseNameResolver.ForGivenType implements BaseNameResolver {
                public ForGivenType(TypeDescription typeDescription) {
                    super(typeDescription);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass();
                }

                public int hashCode() {
                    return super.hashCode();
                }
            }

            @Deprecated
            public enum ForUnnamedType implements BaseNameResolver {
                INSTANCE;

                public String resolve(TypeDescription typeDescription) {
                    return typeDescription.getName();
                }
            }
        }

        public SuffixingRandom(String str) {
            this(str, (Suffixing.BaseNameResolver) Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return super.hashCode();
        }

        /* access modifiers changed from: protected */
        public String name(TypeDescription typeDescription) {
            return super.name(typeDescription) + "$" + this.randomString.nextString();
        }

        public SuffixingRandom(String str, String str2) {
            this(str, (Suffixing.BaseNameResolver) Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE, str2);
        }

        @Deprecated
        public SuffixingRandom(String str, BaseNameResolver baseNameResolver) {
            this(str, (Suffixing.BaseNameResolver) baseNameResolver);
        }

        public SuffixingRandom(String str, Suffixing.BaseNameResolver baseNameResolver) {
            this(str, baseNameResolver, NamingStrategy.BYTE_BUDDY_RENAME_PACKAGE);
        }

        @Deprecated
        public SuffixingRandom(String str, BaseNameResolver baseNameResolver, String str2) {
            this(str, (Suffixing.BaseNameResolver) baseNameResolver, str2);
        }

        public SuffixingRandom(String str, Suffixing.BaseNameResolver baseNameResolver, String str2) {
            this(str, baseNameResolver, str2, new RandomString());
        }

        @Deprecated
        public SuffixingRandom(String str, BaseNameResolver baseNameResolver, String str2, RandomString randomString2) {
            this(str, (Suffixing.BaseNameResolver) baseNameResolver, str2, randomString2);
        }

        public SuffixingRandom(String str, Suffixing.BaseNameResolver baseNameResolver, String str2, RandomString randomString2) {
            super(str, baseNameResolver, str2);
            this.randomString = randomString2;
        }
    }

    String rebase(TypeDescription typeDescription);

    String redefine(TypeDescription typeDescription);

    String subclass(TypeDescription.Generic generic);
}
