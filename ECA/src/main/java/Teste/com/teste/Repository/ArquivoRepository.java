package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository <Arquivo, Long > {

}
