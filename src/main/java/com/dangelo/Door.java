package com.dangelo;

import java.util.Objects;

public class Door {

    private String id;

    public Door(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Door door = (Door) o;
        return id.equals(door.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
