package dao;

import beans.Reimbursement;

public interface ReimbursementDao {
    public Reimbursement getByID(int id);

    public void newTRF(Reimbursement reimbursement);

    public void update(Reimbursement reimbursement);

    public void delete(Reimbursement reimbursement);
}
