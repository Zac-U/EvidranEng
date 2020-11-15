package engine.event;

import engine.component.Direction;
import engine.entity.entity;
import engine.physics.Collide;

public class collisionEvent {

    entity e;
    Direction direction;

    public collisionEvent(entity E, Direction direction) {
        this.e = E;
        this.direction = direction;
    }

    public entity getEntity() {
        return e;
    }

    public Direction getDirection() {
        return direction;
    }

}
