package lista02.questao02.model;

public class Municipio {
	int codigo_municipio;
	String nome_municipio;
	int geoibgeId;
	int geonamesId;
	
	
	public int getCodigo_municipio() {
		return codigo_municipio;
	}
	public void setCodigo_municipio(int codigo_municipio) {
		this.codigo_municipio = codigo_municipio;
	}
	public String getNome_municipio() {
		return nome_municipio;
	}
	public void setNome_municipio(String nome_municipio) {
		this.nome_municipio = nome_municipio;
	}
	public int getGeoibgeId() {
		return geoibgeId;
	}
	public void setGeoibgeId(int geoibgeId) {
		this.geoibgeId = geoibgeId;
	}
	public int getGeonamesId() {
		return geonamesId;
	}
	public void setGeonamesId(int geonamesId) {
		this.geonamesId = geonamesId;
	}
}