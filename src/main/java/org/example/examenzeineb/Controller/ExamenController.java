    package org.example.examenzeineb.Controller;

    import org.example.examenzeineb.Entity.Bank;
    import org.example.examenzeineb.Entity.Compte;
    import org.example.examenzeineb.Entity.Transaction;
    import org.example.examenzeineb.Entity.TypeTransaction;
    import org.example.examenzeineb.Service.ServiceExam;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @RestController
    public class ExamenController {
        @Autowired
        private ServiceExam serviceExam;

        @PostMapping("/bank")
        public Bank ajouterBank(@RequestBody Bank bank) {
            return serviceExam.ajouterBank(bank);
        }
        @PostMapping("/compte")
        public Compte ajouterCompteEtAffecterAAgence(@RequestBody Compte compte, String agenceBank) {
            return serviceExam.ajouterCompteEtAffecterAAgence(compte, agenceBank);
        }
        @PostMapping("/transaction/virement")
        public String ajouterVirement(@RequestBody Transaction transaction) {
            return serviceExam.ajouterVirement(transaction);
        }

        @PostMapping("/transaction/retrait")
        public String ajouterRetrait(@RequestBody Transaction transaction) {
            return serviceExam.ajouterRetrait(transaction);
        }

        @PostMapping("/transaction/versement")
        public String ajouterVersement(@RequestBody Transaction transaction) {
            return serviceExam.ajouterVersement(transaction);
        }
        @PostMapping("/transaction/allByBankId")
        public List<Transaction> getAllTransactionByBankId(@RequestBody long idBank) {
            return serviceExam.getAllTransactionByBankId(idBank);
        }

        @PostMapping("/transaction/allByTypeAndCompte")
        public List<Transaction> getAllTransactionByTypeAndCompte(@RequestBody TypeTransaction type, @RequestBody long idCompte) {
            return serviceExam.getAllTransactionByTypeAndCompte(type, idCompte);
        }
    }
