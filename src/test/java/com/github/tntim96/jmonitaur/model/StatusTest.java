package com.github.tntim96.jmonitaur.model;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StatusTest {
    @Test
    public void shouldConstructStatus() {
        Status status = new Status(Level.CRITICAL, "id", "description");
        assertThat(status.getLevel(), is(Level.CRITICAL));
        assertThat(status.getSystemId(), equalTo("id"));
        assertThat(status.getDescription(), equalTo("description"));
    }
}