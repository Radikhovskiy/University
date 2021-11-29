package bots.crew.juniortask.service;

import bots.crew.juniortask.entity.Lector;
import java.util.List;
import java.util.Set;

public interface LectorService {
    Lector add(Lector lector);

    List<Lector> getAll();

    Set<String> getLectorsByTemplate(String template);
}
