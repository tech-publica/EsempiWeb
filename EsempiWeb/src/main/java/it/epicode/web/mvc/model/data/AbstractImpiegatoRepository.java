package it.epicode.web.mvc.model.data;

import java.util.List;

import it.epicode.web.mvc.model.Impiegato;

public interface AbstractImpiegatoRepository {
    Impiegato inserisciImpiegato(Impiegato nuovoImpiegato) throws DataException;
    List<Impiegato> listaImpiegati() throws DataException;
    
}
