package bots.crew.juniortask.service;

import bots.crew.juniortask.entity.Lector;
import java.util.List;

public interface LectorService {
    Lector add(Lector lector);

    List<Lector> getAll();

    List<Lector> getLectorsByTemplate(String template);
}
