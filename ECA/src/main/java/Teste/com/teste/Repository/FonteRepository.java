package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Fonte;

@Repository
public interface FonteRepository extends JpaRepository <Fonte, Long> {

}
