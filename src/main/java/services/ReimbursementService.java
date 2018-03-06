package services;

import beans.Reimbursement;
import dao.ReimbursementDao;
import dao.ReimbursementDaoJdbcPg;

public class ReimbursementService {
    private static ReimbursementDao reimbursementDao = new ReimbursementDaoJdbcPg();

    public Reimbursement getByID(int id){
        return reimbursementDao.getByID(id);
    }

    public void newTRF(Reimbursement reimbursement){
        reimbursementDao.newTRF(reimbursement);
    }

    public void update(Reimbursement reimbursement){
        reimbursementDao.update(reimbursement);
    }

    public void delete(Reimbursement reimbursement){
        reimbursementDao.delete(reimbursement);
    }

}
