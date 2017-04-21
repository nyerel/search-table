package eu.nyerel.searchtable.api.model;

import java.io.Serializable;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class Order implements Serializable {

    private String property;
    private Direction direction;

    public Order() {
    }

    public Order(String property, Direction direction) {
        this.property = property;
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
