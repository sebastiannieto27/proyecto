package co.com.core.domain.psaber;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "tipo_institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInstitucion.findAll", query = "SELECT t FROM TipoInstitucion t")
    , @NamedQuery(name = "TipoInstitucion.findByTipoInstitucionId", query = "SELECT t FROM TipoInstitucion t WHERE t.tipoInstitucionId = :tipoInstitucionId")
    , @NamedQuery(name = "TipoInstitucion.findByNombre", query = "SELECT t FROM TipoInstitucion t WHERE t.nombre = :nombre")})
public class TipoInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_institucion_id")
    private Integer tipoInstitucionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInstitucionId")
    private Collection<Institucion> institucionCollection;

    public TipoInstitucion() {
    }

    public TipoInstitucion(Integer tipoInstitucionId) {
        this.tipoInstitucionId = tipoInstitucionId;
    }

    public TipoInstitucion(Integer tipoInstitucionId, String nombre) {
        this.tipoInstitucionId = tipoInstitucionId;
        this.nombre = nombre;
    }

    public Integer getTipoInstitucionId() {
        return tipoInstitucionId;
    }

    public void setTipoInstitucionId(Integer tipoInstitucionId) {
        this.tipoInstitucionId = tipoInstitucionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Institucion> getInstitucionCollection() {
        return institucionCollection;
    }

    public void setInstitucionCollection(Collection<Institucion> institucionCollection) {
        this.institucionCollection = institucionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoInstitucionId != null ? tipoInstitucionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstitucion)) {
            return false;
        }
        TipoInstitucion other = (TipoInstitucion) object;
        if ((this.tipoInstitucionId == null && other.tipoInstitucionId != null) || (this.tipoInstitucionId != null && !this.tipoInstitucionId.equals(other.tipoInstitucionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.TipoInstitucion[ tipoInstitucionId=" + tipoInstitucionId + " ]";
    }
    
}

