package engine.draw;

import engine.component.Volume;

/***
 * a general draw component usable by the developer to give entities and buttons an appearance
 */
public interface facade extends drawable{
    void giveVolume(Volume V);
}
