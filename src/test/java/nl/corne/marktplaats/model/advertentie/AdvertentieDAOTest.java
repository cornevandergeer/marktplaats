package nl.corne.marktplaats.model.advertentie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdvertentieDAOTest {

    @Mock
    private EntityManager emMock;
    @Mock
    private EntityTransaction tMock;
//    @Mock
//    private Advertentie adMock = Advertentie.builder().build();
    @InjectMocks
    private AdvertentieDAO target;


    @Test
    void whenInsertWithValidAdvertentieThenTransactionIsCommitted() {
        // given
        when(emMock.getTransaction()).thenReturn(tMock);
        doNothing().when(emMock).persist(any(Advertentie.class));

        // when
        target.insert(new Advertentie());

        // then
        verify(emMock).persist(any(Advertentie.class));
        verify(tMock).begin();
        verify(tMock).commit();
    }
    @Test
    void whenGetAdvertentieByIdThenAdvertentieIsReturned() {
        // given
        when(emMock.find(any(), anyLong())).thenReturn(new Advertentie());
        // when
        Advertentie actual = target.get(1);

        // then
        Assertions.assertNotNull(actual);
        verify(emMock).find(any(), anyLong());

    }

    // TODO?
    // - nog een test voor als exception optreedt bij insert
    // de update testen

    @Test
    void getAllAdvertentieFromGebruiker() {
    }

    @Test
    void getAllBeschikbareAdvertenties() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }


}