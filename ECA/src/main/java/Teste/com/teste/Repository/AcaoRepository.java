package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Acao;

@Repository
public interface AcaoRepository extends JpaRepository <Acao, Long > {

}
