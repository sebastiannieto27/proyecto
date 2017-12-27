package co.com.core.domain.psaber;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import co.com.core.domain.City;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i")
    , @NamedQuery(name = "Institucion.findByInstitucionId", query = "SELECT i FROM Institucion i WHERE i.institucionId = :institucionId")
    , @NamedQuery(name = "Institucion.findByNombre", query = "SELECT i FROM Institucion i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Institucion.findByDireccion", query = "SELECT i FROM Institucion i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "Institucion.findByNit", query = "SELECT i FROM Institucion i WHERE i.nit = :nit")
    , @NamedQuery(name = "Institucion.findByCodigo", query = "SELECT i FROM Institucion i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Institucion.findByTelefono", query = "SELECT i FROM Institucion i WHERE i.telefono = :telefono")
    , @NamedQuery(name = "Institucion.findByCorreo", query = "SELECT i FROM Institucion i WHERE i.correo = :correo")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "institucion_id")
    private Integer institucionId;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "nit")
    private String nit;
    @Size(max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private City cityId;
    @JoinColumn(name = "tipo_institucion_id", referencedColumnName = "tipo_institucion_id")
    @ManyToOne(optional = false)
    private TipoInstitucion tipoInstitucionId;

    public Institucion() {
    }

    public Institucion(Integer institucionId) {
        this.institucionId = institucionId;
    }

    public Integer getInstitucionId() {
        return institucionId;
    }

    public void setInstitucionId(Integer institucionId) {
        this.institucionId = institucionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    public TipoInstitucion getTipoInstitucionId() {
        return tipoInstitucionId;
    }

    public void setTipoInstitucionId(TipoInstitucion tipoInstitucionId) {
        this.tipoInstitucionId = tipoInstitucionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (institucionId != null ? institucionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.institucionId == null && other.institucionId != null) || (this.institucionId != null && !this.institucionId.equals(other.institucionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Institucion[ institucionId=" + institucionId + " ]";
    }
    
}
