package com.bjankie1.scalatest;

import java.util.LinkedList;
import java.util.List;

public class Button {

    private boolean on = false;

    private List<Boolean> audit = new LinkedList<Boolean>();

    public boolean isOn() { return on; }

    public List<Boolean> getAudit() { return audit; }

    public void press() {
        on = !on;
        audit.add(on);
    }
}
