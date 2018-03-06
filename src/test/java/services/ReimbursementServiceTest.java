package services;

import beans.Reimbursement;
import dao.ReimbursementDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ReimbursementServiceTest {

    @InjectMocks
    private ReimbursementService mockRS = new ReimbursementService();

    @Mock
    ReimbursementDao mockDoa = mock(ReimbursementDao.class);
    Reimbursement test = new Reimbursement(0,0,5,1,1,1,1,1,1,100,1,200.40);

    @Test
    void getByID() {
        when(mockDoa.getByID(0)).thenReturn(test);
        assertEquals(test,mockRS.getByID(0));
    }

    @Test
    void newTRF() {
        ReimbursementService mockRSTRF = mock(ReimbursementService.class);
        mockRSTRF.newTRF(any(Reimbursement.class));
        verify(mockRSTRF,times(1)).newTRF(any(Reimbursement.class));
    }

    @Test
    void update() {
        ReimbursementService mockRSTRF = mock(ReimbursementService.class);
        mockRSTRF.update(any(Reimbursement.class));
        verify(mockRSTRF,times(1)).update(any(Reimbursement.class));
    }

    @Test
    void delete() {
        ReimbursementService mockRSTRF = mock(ReimbursementService.class);
        mockRSTRF.delete(any(Reimbursement.class));
        verify(mockRSTRF,times(1)).delete(any(Reimbursement.class));
    }
}