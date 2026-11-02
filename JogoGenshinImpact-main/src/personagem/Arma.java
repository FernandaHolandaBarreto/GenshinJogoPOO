package personagem;

public class Arma {

    private String tipoDeArma;
    private String raridadeDaArma;
    private String atributoPrincipal;
    private String sobreArma;

    public Arma(String tipoDeArma, String raridadeDaArma, String atributoPrincipal, String sobreArma) {
        this.tipoDeArma = tipoDeArma;
        this.raridadeDaArma = raridadeDaArma;
        this.atributoPrincipal = atributoPrincipal;
        this.sobreArma = sobreArma;
    }

    @Override
    public String toString() {
        return "Personagem.Arma{" +
                "tipoDeArma='" + tipoDeArma + '\'' +
                ", raridadeDaArma='" + raridadeDaArma + '\'' +
                ", atributoPrincipal='" + atributoPrincipal + '\'' +
                ", sobreArma='" + sobreArma + '\'' +
                '}';
    }

    public String getTipoDeArma() {
        return tipoDeArma;
    }

    public void setTipoDeArma(String tipoDeArma) {
        this.tipoDeArma = tipoDeArma;
    }

    public String getRaridadeDaArma() {
        return raridadeDaArma;
    }

    public void setRaridadeDaArma(String raridadeDaArma) {
        this.raridadeDaArma = raridadeDaArma;
    }

    public String getAtributoPrincipal() {
        return atributoPrincipal;
    }

    public void setAtributoPrincipal(String atributoPrincipal) {
        this.atributoPrincipal = atributoPrincipal;
    }

    public String getSobreArma() {
        return sobreArma;
    }

    public void setSobreArma(String sobreArma) {
        this.sobreArma = sobreArma;
    }
}
