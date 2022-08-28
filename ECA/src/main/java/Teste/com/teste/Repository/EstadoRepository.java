package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Long> {

}
