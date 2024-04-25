    package com.example.examanhoussemhosni.Service;
    import com.example.examanhoussemhosni.Entity.*;
    import com.example.examanhoussemhosni.Repo.BankRepository;
    import com.example.examanhoussemhosni.Repo.CompteRepository;

    import com.example.examanhoussemhosni.Repo.TransactionRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.scheduling.annotation.Scheduled;
    import org.springframework.stereotype.Service;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.List;

    @Service
    public class ServiceExamImp implements ServiceExam {

        @Autowired
        private BankRepository bankRepository;

        @Autowired
        private CompteRepository compteRepository;

        @Autowired
        private TransactionRepository transactionRepository;

        @Override
        public Bank ajouterBank(Bank bank) {
            return bankRepository.save(bank);
        }

        @Override
        public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agenceBank) {
            Bank bank = bankRepository.findByAgence(agenceBank);
            if (bank != null) {
                compte.setBank(bank);
                return compteRepository.save(compte);
            } else {
                return null;
            }
        }

        @Override
        public String ajouterVirement(Transaction transaction) {
            Compte compteExp = transaction.getCompteExpiediteur();
            Compte compteDest = transaction.getCompteDestinataire();

            if (transaction.getType() != TypeTransaction.VIREMENT) {
                return "Type de transaction invalide.";
            }

            if (compteExp.getType() == TypeCompte.EPARGNE) {
                return "On ne peut pas faire un virement à partir d'un compte épargne.";
            }

            double montant = transaction.getMontant();
            if (compteExp.getSolde() < (montant + 3)) {
                return "On ne peut pas faire un virement : Solde insuffisant.";
            }

            compteExp.setSolde(compteExp.getSolde() - montant);
            compteDest.setSolde(compteDest.getSolde() + montant);


            transaction.setDateTransaction(new Date());

            transactionRepository.save(transaction);

            return "VIREMENT de " + montant + " DT de compte " +
                    compteExp.getIdCompte() + " vers le compte " + compteDest.getIdCompte() +
                    " approuvé avec succès.";
        }

        @Override
        public String ajouterRetrait(Transaction transaction) {
            Compte compte = transaction.getCompteExpiediteur();

            if (transaction.getType() != TypeTransaction.RETRAIT) {
                return "Type de transaction invalide.";
            }

            double montant = transaction.getMontant();
            if (compte.getSolde() < (montant + 2)) {
                return "On ne peut pas faire un retrait : Solde insuffisant.";
            }

            compte.setSolde(compte.getSolde() - montant);
            transaction.setDateTransaction(new Date());
            transactionRepository.save(transaction);
            return "RETRAIT de " + montant + " DT de compte " +
                    compte.getIdCompte() + " approuvé avec succès.";
        }

        @Override
        public String ajouterVersement(Transaction transaction) {
            Compte compteDest = transaction.getCompteDestinataire();
            if (transaction.getType() != TypeTransaction.VERSEMENT) {
                return "Type de transaction invalide.";
            }

            double montant = transaction.getMontant();
            if (compteDest.getType() != TypeCompte.EPARGNE) {
                montant -= 2;
            }

            compteDest.setSolde(compteDest.getSolde() + montant);

            transaction.setDateTransaction(new Date());

            transactionRepository.save(transaction);

            return "Versement de " + montant + " DT vers compte " +
                    compteDest.getIdCompte() + " approuvé avec succès.";
        }
        @Override
        @Scheduled(fixedRate = 30000)
        public void getAllTransactionByDate() {
            Date today = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String todayString = formatter.format(today);

            List<Transaction> transactions = transactionRepository.findByDateTransaction(todayString);

            // Log transactions
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getIdTransaction());

            }
        }
        @Override
        public List<Transaction> getAllTransactionByBankId(long idBank) {
            return transactionRepository.getAllTransactionByBankId(idBank);
        }

        @Override
        public List<Transaction> getAllTransactionByTypeAndCompte(TypeTransaction type, long idCompte) {
            return transactionRepository.findAllByTypeAndCompte_IdCompte(type, idCompte);
        }
    }