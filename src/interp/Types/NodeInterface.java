package interp.Types;

import processing.core.PGraphics;
import processing.core.PImage;

public interface NodeInterface {
    public void init();

    public void setTarget();

    public void passToShad();

    public void delete();

    public boolean writable();

    public PImage getImage();

    public PGraphics getRenderer();
}
