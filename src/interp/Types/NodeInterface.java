package interp.Types;

import processing.core.PGraphics;
import processing.core.PImage;

public interface NodeInterface {
    public void init();
    public int getId();
    public void setId(int id);
    public PImage getImage();
    public boolean writable();
    public PGraphics getRenderer();
}
