package model;

import repository.IModel;


public class Film implements IModel<Film> {
    private long id;
    private String name;
    private long durationTime;
    private EType typeOfFilm;
    private EStatus status;

    public Film() {
    }

    public Film(long id, String name, long durationTime, EType typeOfFilm, EStatus status) {
        this.id = id;
        this.name = name;
        this.durationTime = durationTime;
        this.typeOfFilm = typeOfFilm;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    @Override
    public void update(Film obj) {
    }

    @Override
    public Film parseData(String line) {
        String[] itemInfo = line.split(",");
        //long id, String name, long durationTime, EFormat typeOfFilm, status
        long id = Long.parseLong(itemInfo[0]);
        long durationTime = Long.parseLong(itemInfo[2]);
        EType typeOfFilm = EType.getTypeByName(itemInfo[3]);
        EStatus status = EStatus.getStatusByName(itemInfo[4]);

        Film film = new Film(id,itemInfo[1],durationTime,typeOfFilm,status);
        return film;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(long durationTime) {
        this.durationTime = durationTime;
    }

    public EType getTypeOfFilm() {
        return typeOfFilm;
    }

    public void setTypeOfFilm(EType typeOfFilm) {
        this.typeOfFilm = typeOfFilm;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public String toView() {
        return String.format("                        ║%7s║%-30s║ %-15s║%-15s║%-15s║", this.id, this.name, this.durationTime + " minutes", this.typeOfFilm, this.status);
    }
}
