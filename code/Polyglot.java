import org.graalvm.polyglot.*;

class Polyglot {
    public static void main(String[] args) {
        javaJS();
        // javaR(); -- not working as of now
        javaPy();
    }

    private static void javaJS() {
        Context ctx = Context.create();
        Value array = ctx.eval("js", "[1,2,42,4]");
        int result = array.getArrayElement(2).asInt();
        System.out.println("Java executing JS: " + result);
    }

    private static void javaR(){
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value array = polyglot.eval("R", "c(1,2,42,4)");
        int result = array.getArrayElement(2).asInt();
        System.out.println("Java executing R: " + result);
    }

    private static void javaPy() {
        Context context = Context.newBuilder().allowIO(true).build();
        Value array = context.eval("python", "[1,2,42,4]");
        int result = array.getArrayElement(2).asInt();
        System.out.println(result);
    }

}