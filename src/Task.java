public class Task {
    private int Id;
    private String Title;
    private String Description;

    public Task(int id, String title, String description) {
        Id = id;
        Title = title;
        Description = description;
    }
    public int getId() {
        return Id;
    }


    public String getTitle() {
        return Title;
    }

    public String setTitle(String title) {
        Title = title;
        return title;
    }


    public String getDescription() {
        return Description;
    }
    public String setDescription(String description) {
        Description = description;
        return description;
    }
}
