package rest.dto;

/**
 * Created by TKK on 2017-01-28.
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ZwierzeDto {

    private int id;

    private String nazwa;

    private Integer poziomNajedzenia;

    private Integer tempoJedzenia;



    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNazwa() {

        return nazwa;

    }



    public void setNazwa(String nazwa) {

        this.nazwa = nazwa;

    }

    public Integer getPoziomNajedzenia() {
        return poziomNajedzenia;
    }

    public void setPoziomNajedzenia() {
        this.poziomNajedzenia = poziomNajedzenia;
    }

    public Integer getTempoJedzenia() {
        return tempoJedzenia;
    }

    public void setTempoJedzenia() {
        this.tempoJedzenia = tempoJedzenia;
    }
}