package com.pcompieta.graalvm;

import org.graalvm.polyglot.*;

class App {
    public static void main(String[] args) {
        javaR();
        javaPy();
    }

    private static final int x = 42;

    private static void javaR(){
        try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
            context.getBindings("R").putMember("x", x);
            Value array = context.eval("R", "c(1,2,x,4)");
            int result = array.getArrayElement(2).asInt();
            System.out.println("Java executing R: " + result);
        }
    }

    private static void javaPy() {
        try (Context context = Context.newBuilder().allowIO(true).allowAllAccess(true).build()) {
            context.getPolyglotBindings().putMember("x", x);
            Value array = context.eval("python", "" +
                "import polyglot \n" +
                "x = polyglot.import_value('x') \n" +
                "[1,2,x,4]");
            int result = array.getArrayElement(2).asInt();
            System.out.println("Java executing Python: " + result);
        }
    }

}
