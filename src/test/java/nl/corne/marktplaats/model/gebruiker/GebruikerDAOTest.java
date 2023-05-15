package nl.corne.marktplaats.model.gebruiker;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GebruikerDAOTest {

    @Mock
    private EntityManager emMock;
    @Mock
    private EntityTransaction tMock;
    @InjectMocks
    private GebruikerDAO target;

    @Test
    void whenInsertWithValidGebruikerThenTransactionIsCommitted() {
        // given
        when(emMock.getTransaction()).thenReturn(tMock);
        doNothing().when(emMock).persist(any(Gebruiker.class));

        // when
        target.insert(new Gebruiker());

        // then
        verify(emMock).persist(any(Gebruiker.class));
        verify(tMock).begin();
        verify(tMock).commit();
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }


    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void inlogGebruiker() {
    }

    @Test
    void uitlogGebruiker() {
    }

    @Test
    void selectGebruikerByNaam() {
    }

    @Test
    void close() {
    }
}