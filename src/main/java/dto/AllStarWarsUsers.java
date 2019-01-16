package dto;

import lombok.Data;

@Data
public class AllStarWarsUsers {

    private Integer count;
    private String next;
    private String previous;
    private StarWarsUser[] results;
}
