package services;

import beans.TRF;
import dao.TRFDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class TRFServiceTest {

    @InjectMocks
    private TRFService mockTRF = new TRFService();

    @Mock
    TRFDao mockDoa = mock(TRFDao.class);
    TRF test = new TRF(0,"Event",1,"2017-12-23","12:30:00","2017-12-13","2017-12-15",8,"delaware","aldsfjal",50,2,1,"1231",null,1);

    @Test
    void getByID() {
        when(mockDoa.getByID(0)).thenReturn(test);
        assertEquals(test,mockTRF.getByID(0));

    }

    @Test
    void newForm() {
        TRFService mockTRF = mock(TRFService.class);
        mockTRF.newForm(any(TRF.class));
        verify(mockTRF,times(1)).newForm(any(TRF.class));
    }

    @Test
    void update() {
        TRFService mockTRF = mock(TRFService.class);
        mockTRF.update(any(TRF.class));
        verify(mockTRF,times(1)).update(any(TRF.class));
    }

    @Test
    void delete() {
        TRFService mockTRF = mock(TRFService.class);
        mockTRF.delete(any(TRF.class));
        verify(mockTRF,times(1)).delete(any(TRF.class));
    }
}