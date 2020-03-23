package com.pcompieta.graalvm;

import org.graalvm.polyglot.*;

/**
 * See https://www.graalvm.org/docs/reference-manual/embed/
 */
class App {
    public static void main(String[] args) {
        javaR();
        javaPy();
    }

    public static class Input {
        public Input(int num, String text) {
            this.num = num;
            this.text = text;
        }
        public int num;
        public String text;
    }

    private static final Input aGoodInput = new Input(42, "ciao");

    private static void javaR(){
        try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
            context.getBindings("R").putMember("x", aGoodInput);
            Value array = context.eval("R", "c(1,2,x$num,4)");
            int result = array.getArrayElement(2).asInt();
            System.out.println("Java executing R: " + result);
        }
    }

    private static void javaPy() {
        try (Context context = Context.newBuilder().allowIO(true).allowAllAccess(true).build()) {
            context.getPolyglotBindings().putMember("x", aGoodInput);
            Value v = context.eval("python", "" +
                "import polyglot \n" +
                "x = polyglot.import_value('x') \n" +
                "x['text']");
            String returned = v.asString();
            System.out.println("Java executing Python: " + returned);
        }
    }

}
