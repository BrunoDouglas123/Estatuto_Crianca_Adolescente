package Teste.com.teste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Teste.com.teste.Model.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository <Beneficiario, Long> {

}
