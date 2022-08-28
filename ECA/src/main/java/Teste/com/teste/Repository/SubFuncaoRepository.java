package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.SubFuncao;

@Repository
public interface SubFuncaoRepository extends JpaRepository <SubFuncao, Long> {

}
