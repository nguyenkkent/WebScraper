import java.util.Objects;

public class JobPosting {

    private String role, company, datePosted, URL, city, state;

    public JobPosting(){
    }

    public JobPosting(String role, String company, String datePosted, String URL, String city, String state) {
        this.role = role;
        this.company = company;
        this.datePosted = datePosted;
        this.URL = URL;
        this.city = city;
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public String getURL() {
        return URL;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public JobPosting setRole(String role) {
        this.role = role;
        return this;
    }

    public JobPosting setCompany(String company) {
        this.company = company;
        return this;
    }

    public JobPosting setDatePosted(String datePosted) {
        this.datePosted = datePosted;
        return this;
    }

    public JobPosting setURL(String URL) {
        this.URL = URL;
        return this;
    }

    public JobPosting setCity(String city) {
        this.city = city;
        return this;
    }

    public JobPosting setState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "role='" + role + '\'' +
                ", company='" + company + '\'' +
                ", datePosted='" + datePosted + '\'' +
                ", URL='" + URL + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPosting that = (JobPosting) o;
        return Objects.equals(role, that.role)
                && Objects.equals(company, that.company)
                && Objects.equals(datePosted, that.datePosted)
                && Objects.equals(URL, that.URL) && Objects.equals(city, that.city)
                && Objects.equals(state, that.state);
    }

}
