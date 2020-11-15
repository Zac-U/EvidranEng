package engine.event;

import engine.component.Location;
import engine.core.tick;

public class windowEvent{

   String event;
   String key;
   Location local;

   public windowEvent(String event) {
       this.event = event;
   }

   public windowEvent(String event, Location local) {
        this.event = event;
        this.local = local;
    }

    public windowEvent(String event, String key) {
        this.event = event;
        this.key = key;
    }


    public String getEvent() {
       return event;
    }

    public String getKey() {
        return key;
    }



}
