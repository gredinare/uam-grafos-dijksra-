package model;
;
public class Vertex {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Vertex(String name) {
        setName(name);
    }
}
