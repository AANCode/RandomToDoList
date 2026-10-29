public class Task {
    private static int Counter = 1;
    private int Id;
    private String Title;
    private String Description;

    public Task(String title, String description) {
        Id = Counter;
        Title = title;
        Description = description;
        Counter++;
    }


    public int getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }


    @Override
    public String toString() {
        return "Id: " + Id + ", Title: " + Title + ", Description: " + Description ;
    }
}
