package tauon.app.ui.components.simpletable;

import java.util.function.Function;

public class SimpleColumn<T, V> {
    
    String name;
    Class<?> type;
    Function<T, V> getValue;
    
    public SimpleColumn(String name, Class<V> type, Function<T, V> getValue) {
        this.name = name;
        this.type = type;
        this.getValue = getValue;
    }
    public SimpleColumn(String name, Function<T, V> getValue) {
        this.name = name;
        this.type = Object.class;
        this.getValue = getValue;
    }
}
