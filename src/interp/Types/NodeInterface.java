package interp.Types;

import processing.core.PGraphics;
import processing.core.PImage;

public abstract class NodeInterface {
    int id;
    int references;
    public int width;
    public int height;

    public NodeInterface() {
        id = -1;
        references = 0;
    }

    public abstract void init();
    public abstract PImage getImage();
    public abstract boolean writable();
    public abstract PGraphics getRenderer();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getReferences() { return references; }
    public void addReference() { references++; }
    public void removeReference() { references--; }
}
