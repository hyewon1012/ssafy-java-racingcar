package step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {
    private static final int NAMES_LENGTH_CONDITION = 1;
    private final List<Name> names;

    public Names(String[] names){
        inputNamesValidate(names);
        this.names = Arrays.asList(names)
                .stream()
                .map(name -> new Name(name))
                .collect(Collectors.toList());
    }

    private void inputNamesValidate(String[] names) {
        if(Objects.isNull(names) || names.length < NAMES_LENGTH_CONDITION){
            throw new IllegalArgumentException();
        }
    }

    public Names(List<Name> name){
        this.names = name;
    }

    public List<Name> getNames(){
        return this.names;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Names)){
            return false;
        }
        Names names = (Names) obj;
        return Objects.equals(this.names, names.getNames());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.names);
    }
}
