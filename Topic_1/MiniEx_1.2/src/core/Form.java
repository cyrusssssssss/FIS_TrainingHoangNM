package core;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
public class Form {
    private List<Component> components;

    public Form(List components) {
        this.components = components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }
    public void addComponent(Component component){
        //TODO
    }
    public boolean validate(){
        //TODO
    }
}
