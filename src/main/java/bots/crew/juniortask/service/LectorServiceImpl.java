package bots.crew.juniortask.service;

import bots.crew.juniortask.entity.Lector;
import bots.crew.juniortask.repository.LectorRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository repository;

    public LectorServiceImpl(LectorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lector add(Lector lector) {
        return repository.save(lector);
    }

    @Override
    public List<Lector> getAll() {
        return repository.findAll();
    }

    @Override
    public Set<String> getLectorsByTemplate(String template) {
        Set<String> lectors = new HashSet<>();
        for (Lector lector: getAll()) {
            if (lector.getName().contains(template) || lector.getLastName().contains(template)) {
                lectors.add(lector.getName() + " " + lector.getLastName());
            }
        }
        return lectors;
    }
}
