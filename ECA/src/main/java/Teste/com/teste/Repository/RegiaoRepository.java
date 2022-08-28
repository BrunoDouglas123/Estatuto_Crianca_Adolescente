package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository <Regiao, Long> {

}
