package step1;

public class StringUtils {
    private String input;

    private StringUtils() {}

    private static class LazyHolder {
        public static final StringUtils INSTANCE = new StringUtils();
    }

    public static StringUtils getInstance(){
        return LazyHolder.INSTANCE;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void charAt(int index) throws StringIndexOutOfBoundsException{
        try{
            this.input.charAt(index);
        }catch (StringIndexOutOfBoundsException e){
            throw new StringIndexOutOfBoundsException("인덱스가 범위를 벗어났습니다.");
        }

    }

}
