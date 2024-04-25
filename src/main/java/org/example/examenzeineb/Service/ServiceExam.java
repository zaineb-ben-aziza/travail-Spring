    package com.example.examanhoussemhosni.Service;

    import com.example.examanhoussemhosni.Entity.Bank;
    import com.example.examanhoussemhosni.Entity.Compte;
    import com.example.examanhoussemhosni.Entity.Transaction;
    import com.example.examanhoussemhosni.Entity.TypeTransaction;

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
