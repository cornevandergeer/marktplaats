package nl.corne.marktplaats.model.gebruiker;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

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
    @Mock
    private final Gebruiker mockGebruiker = Gebruiker.builder().
            username("Tester").
            wachtwoord("1234").
            voornaam("Test").
            achternaam("Testing").
            woonplaats("TestCity").
            favorieteProgrammeertaal("Mockito").
            build();


    @Test
    void getGebruikerFromDatabase() {
        when(emMock.find(any(), anyString())).thenReturn(new Gebruiker());

        Gebruiker actual = target.get("Test");

        Assertions.assertNotNull(actual);
        verify(emMock).find(any(), anyString());
    }

    @Test
    void getListOfAllGebruikersFromDataBase() {
        TypedQuery<Gebruiker> mockedQuery = mock(TypedQuery.class);
        when(emMock.createNamedQuery(anyString(), eq(Gebruiker.class))).thenReturn(mockedQuery);
        when(mockedQuery.getResultList()).thenReturn(List.of(mockGebruiker));

        List<Gebruiker> actual = target.getAll();

        Assertions.assertNotNull(actual);
        verify(emMock).createNamedQuery(anyString(),any());
    }

    @Test
    void whenInsertWithValidGebruikerThenTransactionIsCommitted() {
        // Given
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
    void whenInsertWithInvalidGebruikerThenTransactionIsRollback(){
        // Given
        when(emMock.getTransaction()).thenReturn(tMock);
        doNothing().when(tMock).begin();
        doNothing().when(tMock).rollback();

        doThrow(new EntityExistsException("Fake news, fake error. It is all a hoax.")).
                when(emMock).
                persist(any(Gebruiker.class));

        target.insert(new Gebruiker());

        verify(tMock).begin();
        verify(emMock).persist(any(Gebruiker.class));
        verify(tMock, never()).commit();
        verify(tMock).rollback();
    }


    @Test
    void whenUpdateWithValidGebruikerThenTransactionIsCommitted() {
        when(emMock.getTransaction()).thenReturn(tMock);
        doNothing().when(tMock).begin();

        target.update(new Gebruiker());

        verify(tMock).begin();
        verify(emMock).merge(any(Gebruiker.class));
        verify(tMock).commit();
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