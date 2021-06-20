package step4.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_LENGTH_CONDITION = 5;
    private final String name;

    public Name(String name){
        inputNameValidate(name);
        this.name = name;
    }

    private void inputNameValidate(String name) {
        if(name.length() > NAME_LENGTH_CONDITION){
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        if(Objects.isNull(name) || name.length() == 0){
            throw new IllegalArgumentException("자동차 이름은 한글자 이상이어야 합니다.");
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Name)){
            return false;
        }
        Name name = (Name) obj;
        return Objects.equals(this.name, name.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name);
    }
}
