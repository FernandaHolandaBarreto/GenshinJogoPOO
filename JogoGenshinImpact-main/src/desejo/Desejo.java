package desejo;

public class Desejo {

    private String personagemNoBanner;
    private String bannerDeArma;
    private String bannerMochileiro;
    private String qtdDePrimogemas;

    public Desejo(String personagemNoBanner, String bannerDeArma, String bannerMochileiro, String qtdDePrimogemas) {
        this.personagemNoBanner = personagemNoBanner;
        this.bannerDeArma = bannerDeArma;
        this.bannerMochileiro = bannerMochileiro;
        this.qtdDePrimogemas = qtdDePrimogemas;
    }

    @Override
    public String toString() {
        return "Desejo.Desejo{" +
                "personagemNoBanner='" + personagemNoBanner + '\'' +
                ", bannerDeArma='" + bannerDeArma + '\'' +
                ", bannerMochileiro='" + bannerMochileiro + '\'' +
                ", qtdDePrimogemas='" + qtdDePrimogemas + '\'' +
                '}';
    }

    public String getPersonagemNoBanner() {
        return personagemNoBanner;
    }

    public void setPersonagemNoBanner(String personagemNoBanner) {
        this.personagemNoBanner = personagemNoBanner;
    }

    public String getBannerDeArma() {
        return bannerDeArma;
    }

    public void setBannerDeArma(String bannerDeArma) {
        this.bannerDeArma = bannerDeArma;
    }

    public String getBannerMochileiro() {
        return bannerMochileiro;
    }

    public void setBannerMochileiro(String bannerMochileiro) {
        this.bannerMochileiro = bannerMochileiro;
    }

    public String getQtdDePrimogemas() {
        return qtdDePrimogemas;
    }

    public void setQtdDePrimogemas(String qtdDePrimogemas) {
        this.qtdDePrimogemas = qtdDePrimogemas;
    }
}
