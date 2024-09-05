package votingsystem;

import java.util.*;

public class Admin {
    private Map<String, Integer> candidates = new HashMap<>();
    private Set<String> voters = new HashSet<>();  // Track who has voted

    // Add a candidate to the election
    public void addCandidate(String candidate) {
        if (!candidates.containsKey(candidate)) {
            candidates.put(candidate, 0);  // Initialize vote count for the candidate
            System.out.println(candidate + " added to the election.");
        } else {
            System.out.println(candidate + " is already in the list.");
        }
    }

    // Cast a vote for a candidate, ensuring the voter hasn't already voted
    public void castVote(String voterName, String candidate) throws Exception {
        if (voters.contains(voterName)) {
            throw new Exception("You have already voted.");
        }
        if (!candidates.containsKey(candidate)) {
            throw new Exception("Invalid candidate!");
        }

        candidates.put(candidate, candidates.get(candidate) + 1);
        voters.add(voterName);
        System.out.println("Vote cast for " + candidate + " by " + voterName);
    }

    // Get the election results and show who's winning
    public String getResults() {
        StringBuilder result = new StringBuilder("Election Results:\n");

        int maxVotes = -1;
        String leadingCandidate = "No winner yet";

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append(" votes\n");
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                leadingCandidate = entry.getKey();
            }
        }

        result.append("\nLeading Candidate: ").append(leadingCandidate).append(" with ").append(maxVotes).append(" votes");
        return result.toString();
    }

    // Get the list of candidates
    public List<String> getCandidates() {
        return new ArrayList<>(candidates.keySet());
    }
}
