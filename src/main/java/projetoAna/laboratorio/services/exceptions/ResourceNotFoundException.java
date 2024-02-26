package projetoAna.laboratorio.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long SerialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("recurso não encontrado com o identificador " + id);
    }
}
