package co.com.core.dto.psaber;

import java.util.Collection;

import co.com.core.domain.psaber.Institucion;

public class TipoInstitucionDTO {
	private Integer tipoInstitucionId;
	
	private String nombre;
	private Collection<Institucion> institucionCollection;
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
	public Collection<Institucion> getInstitucionCollection() {
		return institucionCollection;
	}
	public void setInstitucionCollection(
			Collection<Institucion> institucionCollection) {
		this.institucionCollection = institucionCollection;
	}
	@Override
	public String toString() {
		return "TipoInstitucionDTO [tipoInstitucionId=" + tipoInstitucionId
				+ ", nombre=" + nombre + ", institucionCollection="
				+ institucionCollection + "]";
	}
}
