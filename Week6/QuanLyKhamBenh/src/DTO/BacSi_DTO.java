package DTO;

public class BacSi_DTO 
{
    private String id;
    private String name;

    public BacSi_DTO() {
    }

    public BacSi_DTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
