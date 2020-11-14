package engine.event;

import engine.entity.entity;
import engine.physics.Collide;

public class collisionEvent {

    entity e;
    String direction;

    public collisionEvent(entity E, String direction) {
        this.e = E;
        this.direction = direction;
    }

    public entity getEntity() {
        return e;
    }

    public String getDirection() {
        return direction;
    }

}
