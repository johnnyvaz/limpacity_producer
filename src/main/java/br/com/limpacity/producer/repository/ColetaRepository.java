package br.com.limpacity.producer.repository;

import br.com.limpacity.producer.model.ColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColetaRepository extends JpaRepository<ColetaModel, Long> {

    @Query(" select m from ColetaModel m " +
            " where m.integrationStatus = 'N' ")
    List<ColetaModel> findAllAndIntegrationStatus();

}
