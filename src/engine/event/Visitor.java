package engine.event;

public interface Visitor {
    void accept(Visitor visitor);
}
