package com.github.tntim96.jmonitaur.service;

import com.github.tntim96.jmonitaur.model.Level;
import com.github.tntim96.jmonitaur.model.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JMonitaurService {
    public List<Status> getStatues() {
        List<Status> statuses = new ArrayList<Status>();
        statuses.add(new Status(Level.CRITICAL, "Shields", "30% power"));
        statuses.add(new Status(Level.WARNING, "Fuel", "40% capacity"));
        statuses.add(new Status(Level.INFO, "Food", "80% capacity"));
        statuses.add(new Status(Level.SUCCESS, "Phasers", "90% power"));
        return statuses;
    }
}
