package engine.event;

import engine.core.tick;

public interface event {
    void visit(tick.game game);
}
