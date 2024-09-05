package votingsystem;
// Interface for common functionalities
interface VotingOperations<T> {
    void castVote(T voteData);
    void displayResults();
}

// Generic User Class
class User<T> implements VotingOperations<T> {
    private String name;
    private T vote;
    
    public User(String name) {
        this.name = name;
    }

    @Override
    public void castVote(T voteData) {
        this.vote = voteData;
        System.out.println(name + " voted for: " + voteData);
    }

    @Override
    public void displayResults() {
        System.out.println(name + "'s vote: " + vote);
    }
}
