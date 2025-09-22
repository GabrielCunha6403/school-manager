package org.acme.loader;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.entities.TpUsers;

@ApplicationScoped
public class TpUserLoader {
    @PostConstruct
    @Transactional
    public void loadUsers() {
        if (TpUsers.count() == 0) { // Só cria se não existir
            TpUsers.persist(new TpUsers(1L, "ADMINISTRADOR"));
            TpUsers.persist(new TpUsers(2L, "COORDENADOR"));
            TpUsers.persist(new TpUsers(3L, "PROFESSOR"));
            TpUsers.persist(new TpUsers(4L, "ALUNO"));
        }
    }
}
