    package org.example.examenzeineb.Repo;
    import org.example.examenzeineb.Entity.Transaction;
    import org.example.examenzeineb.Entity.TypeTransaction;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;

    import java.util.Date;
    import java.util.List;

    public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        List<Transaction> findByDateTransaction(Date date);
        @Query("SELECT t FROM Transaction t WHERE t.compteExpiediteur.bank.idBank = ?1")
        List<Transaction> getAllTransactionByBankId(long idBank);

        List<Transaction> findAllByTypeAndCompte_IdCompte(TypeTransaction type, long idCompte);
    }
