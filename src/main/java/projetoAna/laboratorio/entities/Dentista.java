package projetoAna.laboratorio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_dentista")
public class Dentista implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    public Dentista() {
    }

    public Dentista(Long id, String name,Clinica clinica) {
        this.id = id;
        this.name = name;
        this.clinica = clinica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dentista dentista = (Dentista) o;
        return Objects.equals(id, dentista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
