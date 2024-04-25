package org.example.examenzeineb.Service;
    import org.example.examenzeineb.Entity.Bank;
    import org.example.examenzeineb.Entity.Compte;
    import org.example.examenzeineb.Entity.Transaction;
    import org.example.examenzeineb.Entity.TypeTransaction;

    import java.util.List;

    public interface ServiceExam {
        Bank ajouterBank(Bank bank);
        Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank);
        String ajouterVirement(Transaction transaction);
        String ajouterRetrait(Transaction transaction);
        String ajouterVersement(Transaction transaction);
        void getAllTransactionByDate();
        List<Transaction> getAllTransactionByBankId(long idBank);
        List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte);
    }
