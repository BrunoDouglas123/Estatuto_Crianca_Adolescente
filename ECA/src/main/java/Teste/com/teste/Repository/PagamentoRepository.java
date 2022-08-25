package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {

}
