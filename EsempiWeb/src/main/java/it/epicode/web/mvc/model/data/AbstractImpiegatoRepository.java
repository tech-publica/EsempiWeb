package it.epicode.web.mvc.model.data;

import java.util.List;
import java.util.Optional;

import it.epicode.web.mvc.model.Impiegato;

public interface AbstractImpiegatoRepository {
    Impiegato inserisciImpiegato(Impiegato nuovoImpiegato) throws DataException;
    List<Impiegato> listaImpiegati() throws DataException;
	Optional<Impiegato> findById(long id) throws DataException;
	void updateImpiegato(Impiegato imp) throws DataException;
    
}
