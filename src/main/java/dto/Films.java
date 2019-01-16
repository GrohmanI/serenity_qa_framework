package dto;

import lombok.Data;

@Data
public class Films {
    private String title;
    private String episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String[] characters;
    private String[] planets;
    private String[] starships;
    private String[] vehicles;
    private String[] species;
    private String created;
    private String url;


}
