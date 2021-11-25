package bots.crew.juniortask.service;

import bots.crew.juniortask.entity.Lector;
import bots.crew.juniortask.repository.LectorRepository;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<Lector> getLectorsByTemplate(String template) {
        return getAll().stream()
                .filter(l -> l.getName().contains(template)
                        || l.getLastName().contains(template))
                .collect(Collectors.toList());
    }
}
