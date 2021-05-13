package step1;

public final class StringUtils {

    private StringUtils() {}

    private static class LazyHolder {
        public static final StringUtils INSTANCE = new StringUtils();
    }

    public static StringUtils getInstance(){
        return LazyHolder.INSTANCE;
    }
    
    public String subString(String input, int begin, int end){
        return input.substring(begin, end);
    }

}
