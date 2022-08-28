package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository <Programa, Long>{

}
