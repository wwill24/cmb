package net.bytebuddy.build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.commons.ClassRemapper;
import net.bytebuddy.jar.asm.commons.Remapper;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class RenamingPlugin extends AsmVisitorWrapper.AbstractBase implements Plugin {
    private final ElementMatcher<? super TypeDescription> matcher;
    private final Renaming renaming;

    public interface Renaming {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements Renaming {
            private final List<Renaming> renamings;

            public Compound(Renaming... renamingArr) {
                this((List<? extends Renaming>) Arrays.asList(renamingArr));
            }

            public String apply(String str) {
                for (Renaming apply : this.renamings) {
                    str = apply.apply(str);
                }
                return str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.renamings.equals(((Compound) obj).renamings);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.renamings.hashCode();
            }

            public Compound(List<? extends Renaming> list) {
                this.renamings = new ArrayList(list.size());
                for (Renaming renaming : list) {
                    if (renaming instanceof Compound) {
                        this.renamings.addAll(((Compound) renaming).renamings);
                    } else if (!(renaming instanceof NoOp)) {
                        this.renamings.add(renaming);
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForPattern implements Renaming {
            private final Pattern pattern;
            private final String replacement;

            public ForPattern(Pattern pattern2, String str) {
                this.pattern = pattern2;
                this.replacement = str;
            }

            public String apply(String str) {
                Matcher matcher = this.pattern.matcher(str);
                if (!matcher.find()) {
                    return str;
                }
                StringBuffer stringBuffer = new StringBuffer();
                do {
                    matcher.appendReplacement(stringBuffer, this.replacement);
                } while (matcher.find());
                return matcher.appendTail(stringBuffer).toString();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForPattern forPattern = (ForPattern) obj;
                return this.replacement.equals(forPattern.replacement) && this.pattern.equals(forPattern.pattern);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.pattern.hashCode()) * 31) + this.replacement.hashCode();
            }
        }

        public enum NoOp implements Renaming {
            INSTANCE;

            public String apply(String str) {
                return str;
            }
        }

        String apply(String str);
    }

    protected static class RenamingRemapper extends Remapper {
        private final Map<String, String> cache = new HashMap();
        private final Renaming renaming;

        protected RenamingRemapper(Renaming renaming2) {
            this.renaming = renaming2;
        }

        public String map(String str) {
            String str2 = this.cache.get(str);
            if (str2 != null) {
                return str2;
            }
            String replace = this.renaming.apply(str.replace('/', '.')).replace('.', '/');
            this.cache.put(str, replace);
            return replace;
        }
    }

    public RenamingPlugin(String str, String str2) {
        this(new Renaming.ForPattern(Pattern.compile(str), str2));
    }

    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return builder.visit(this);
    }

    public void close() {
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RenamingPlugin renamingPlugin = (RenamingPlugin) obj;
        return this.renaming.equals(renamingPlugin.renaming) && this.matcher.equals(renamingPlugin.matcher);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.renaming.hashCode()) * 31) + this.matcher.hashCode();
    }

    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i10, int i11) {
        return new ClassRemapper(classVisitor, new RenamingRemapper(this.renaming));
    }

    public RenamingPlugin(String str, String str2, String str3) {
        this((Renaming) new Renaming.ForPattern(Pattern.compile(str), str2), (ElementMatcher<? super TypeDescription>) ElementMatchers.nameStartsWith(str3));
    }

    public boolean matches(TypeDescription typeDescription) {
        return this.matcher.matches(typeDescription);
    }

    public RenamingPlugin(Renaming renaming2) {
        this(renaming2, (ElementMatcher<? super TypeDescription>) ElementMatchers.any());
    }

    public RenamingPlugin(Renaming renaming2, ElementMatcher<? super TypeDescription> elementMatcher) {
        this.renaming = renaming2;
        this.matcher = elementMatcher;
    }
}
